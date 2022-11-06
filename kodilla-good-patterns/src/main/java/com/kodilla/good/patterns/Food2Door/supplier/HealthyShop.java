package com.kodilla.good.patterns.Food2Door.supplier;

public class HealthyShop extends FoodSupplier{
    public HealthyShop(String supplierName, String suppliesType, int suppliesQuantity){
        super(supplierName, suppliesType, suppliesQuantity);
    }
    public boolean process(FoodSupplier foodSupplier) {
        if(foodSupplier.getSuppliesQuantity() >= 15){
            System.out.println("We: " + foodSupplier.getSupplierName() + " got your order");
            return true;
        } else {
            System.out.println("There are not enough supplies.");
            return false;
        }
    }
}
