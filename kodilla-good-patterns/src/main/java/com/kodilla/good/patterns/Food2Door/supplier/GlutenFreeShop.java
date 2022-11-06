package com.kodilla.good.patterns.Food2Door.supplier;

public class GlutenFreeShop extends FoodSupplier{
    public GlutenFreeShop(String supplierName, String suppliesType, int suppliesQuantity){
        super(supplierName, suppliesType, suppliesQuantity);
    }
    public boolean process(FoodSupplier foodSupplier) {
        if(foodSupplier.getSuppliesQuantity() >= 500){
            System.out.println("We: " + foodSupplier.getSupplierName() + " got your order");
            return true;
        } else {
            System.out.println("We: " + foodSupplier.getSupplierName() +" haven't got enough supplies.");
            return false;
        }
    }
}
