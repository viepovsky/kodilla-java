package com.kodilla.good.patterns.Food2Door;

import com.kodilla.good.patterns.Food2Door.supplier.ExtraFoodShop;
import com.kodilla.good.patterns.Food2Door.supplier.FoodSupplier;
import com.kodilla.good.patterns.Food2Door.supplier.GlutenFreeShop;
import com.kodilla.good.patterns.Food2Door.supplier.HealthyShop;

public class Application {
    public static void main(String[] args) {
        FoodSupplier extraShop = new ExtraFoodShop("Extra Food Shop","Frozen food",50);
        FoodSupplier healthyShop = new HealthyShop("Healthy Shop","Vegetables",500);
        FoodSupplier glutenFreeShop = new GlutenFreeShop("Gluten Free Shop","Non gluten milk",5);
        FoodSupplierService foodSupplierService = new FoodSupplierService();
        foodSupplierService.finaliseOrderFromSupplier(extraShop);
        foodSupplierService.finaliseOrderFromSupplier(healthyShop);
        foodSupplierService.finaliseOrderFromSupplier(glutenFreeShop);
    }
}
