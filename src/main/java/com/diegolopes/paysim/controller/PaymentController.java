package com.diegolopes.paysim.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diegolopes.paysim.model.InstallmentDefinition;
import com.diegolopes.paysim.model.PaymentPayload;

@RestController
public class PaymentController {
 
    @PostMapping("/pay")
    public ArrayList<InstallmentDefinition> performPayment(@RequestBody PaymentPayload payload) {
        return null;
    }

}
