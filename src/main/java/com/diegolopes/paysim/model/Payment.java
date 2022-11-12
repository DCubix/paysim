package com.diegolopes.paysim.model;

import javax.validation.constraints.NotNull;

public class Payment {
    
    @NotNull
    private double entry;

    @NotNull
    private int installments;

    public Payment() {
    }

    public Payment(@NotNull double entry, @NotNull int installments) {
        this.entry = entry;
        this.installments = installments;
    }

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
