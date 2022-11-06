package com.kodilla.good.patterns.Food2Door;

import com.kodilla.good.patterns.Food2Door.supplier.FoodSupplier;

public class FoodSupplierService {
    public void finaliseOrderFromSupplier(FoodSupplier foodSupplier){
        boolean isOrderDone = foodSupplier.process(foodSupplier);
        if(isOrderDone){
            System.out.println("Order done, everything made right\n");
        } else {
            System.out.println("Some error happened, please try again\n");
        }
    }
}
