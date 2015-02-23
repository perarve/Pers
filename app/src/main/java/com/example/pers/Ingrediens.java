package com.example.pers;

/**
 * Created by perarve on 15-02-23.
 */
public class Ingrediens {
    private String ingrediens;
    private double amount;
    private String unit;

    public Ingrediens(String ingrediens, double amount, String unit) {
        this.ingrediens = ingrediens;
        this.amount = amount;
        this.unit = unit;
    }


    public String getIngrediens() {
        return ingrediens;
    }

    public void setIngrediens(String ingrediens) {
        this.ingrediens = ingrediens;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
