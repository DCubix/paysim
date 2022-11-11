package com.diegolopes.paysim.model;

public class Payment {
    
    private double entry;
    private int installments;
    
    public double getEntry() {
        return entry;
    }
    
    public void setEntry(double entry) {
        this.entry = entry;
    }
    
    public int getInstallments() {
        return installments;
    }

    public void setInstallments(int installments) {
        this.installments = installments;
    }

}
