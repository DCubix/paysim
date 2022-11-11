package com.diegolopes.paysim.model;

public class InstallmentDefinition {
    
    private int installmentNum;
    private double price, tax;
    
    public int getInstallmentNum() {
        return installmentNum;
    }
    
    public void setInstallmentNum(int installmentNum) {
        this.installmentNum = installmentNum;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getTax() {
        return tax;
    }
    
    public void setTax(double tax) {
        this.tax = tax;
    }

}
