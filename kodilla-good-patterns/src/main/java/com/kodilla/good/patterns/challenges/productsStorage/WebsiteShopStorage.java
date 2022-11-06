package com.kodilla.good.patterns.challenges.productsStorage;

import com.kodilla.good.patterns.challenges.orderService.OrderService;
import com.kodilla.good.patterns.challenges.productService.ProductService;

public class WebsiteShopStorage implements ProductsStorage{
    public boolean checkStorage(OrderService orderService) {

        return true;
    }
    public void removeProductFromStorage(OrderService orderService) {
        System.out.println("Items removed from storage");
    }
}
