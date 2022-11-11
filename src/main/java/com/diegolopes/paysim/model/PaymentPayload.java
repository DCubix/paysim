package com.diegolopes.paysim.model;

public class PaymentPayload {
    
    private final Payment payment;
    
    public PaymentPayload(Payment payment, Product product) {
        this.payment = payment;
        this.product = product;
    }

    private final Product product;

    public Payment getPayment() {
        return payment;
    }

    public Product getProduct() {
        return product;
    }
    
}
