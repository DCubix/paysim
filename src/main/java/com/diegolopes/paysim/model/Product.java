package com.diegolopes.paysim.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Product {
    
    @NotNull
    private int id;

    @NotEmpty
    @NotBlank
    @NotNull
    private String name;

    @NotNull
    private double price;

    public Product() {
    }

    public Product(@NotNull int id, @NotEmpty @NotBlank @NotNull String name, @NotNull double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

}
