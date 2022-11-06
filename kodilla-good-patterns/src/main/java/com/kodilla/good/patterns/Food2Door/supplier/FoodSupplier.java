package com.kodilla.good.patterns.Food2Door.supplier;

public abstract class FoodSupplier {
    private String supplierName;
    private String suppliesType;
    private int suppliesQuantity;
    public FoodSupplier(String supplierName, String suppliesType, int suppliesQuantity){
        this.supplierName = supplierName;
        this.suppliesType = suppliesType;
        this.suppliesQuantity = suppliesQuantity;
    }
    abstract public boolean process(FoodSupplier foodSupplier);
    protected int getSuppliesQuantity() {
        return suppliesQuantity;
    }

    protected String getSupplierName() {
        return supplierName;
    }
}
