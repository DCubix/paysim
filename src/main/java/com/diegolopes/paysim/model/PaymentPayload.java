package com.diegolopes.paysim.model;

import javax.validation.constraints.NotNull;

public class PaymentPayload {
    
    @NotNull
    private Payment payment;

    @NotNull
    private Product product;
    
    public PaymentPayload() {
    }

    public PaymentPayload(Payment payment, Product product) {
        this.payment = payment;
        this.product = product;
    }

    public Payment getPayment() {
        return payment;
    }

    public Product getProduct() {
        return product;
    }
    
}
