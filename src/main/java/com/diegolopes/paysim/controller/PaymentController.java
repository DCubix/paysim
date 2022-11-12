package com.diegolopes.paysim.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegolopes.paysim.model.InstallmentDefinition;
import com.diegolopes.paysim.model.Payment;
import com.diegolopes.paysim.model.PaymentPayload;
import com.diegolopes.paysim.model.Product;
import com.diegolopes.paysim.model.SELICTax;
import com.diegolopes.paysim.services.SELICTaxService;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @PostMapping("/pay")
    public ResponseEntity<ArrayList<InstallmentDefinition>> performPayment(@Valid @RequestBody PaymentPayload payload) {
        final Payment payment = payload.getPayment();
        final Product product = payload.getProduct();

        if (payment.getEntry() >= product.getPrice()) {
            return ResponseEntity.status(400).body(null);
        }

        // TODO: Validar isso...
        final double value = (product.getPrice() - payment.getEntry());
        double installmentValue = 0.0;
        double tax = 0.0;

        if (payment.getInstallments() > 6) { // calculate based on SELIC
            final SELICTax selicTax = SELICTaxService.current();
            final double selic = selicTax != null ? selicTax.getValue() : 0.0;
            installmentValue = value * selic * (Math.pow(1.0 + selic, payment.getInstallments()) / (Math.pow(1.0 + selic, payment.getInstallments()) - 1));
            tax = Math.abs(installmentValue - (value / payment.getInstallments()));
        } else {
            installmentValue = value / payment.getInstallments();
        }

        final ArrayList<InstallmentDefinition> installments = new ArrayList<>();

        if (payment.getEntry() > 0.0) {
            installments.add(new InstallmentDefinition(0, payment.getEntry(), 0.0));
        }

        for (int i = 0; i < payment.getInstallments(); i++) {
            installments.add(new InstallmentDefinition(i+1, installmentValue, tax));
        }

        return ResponseEntity.ok(installments);
    }

}
