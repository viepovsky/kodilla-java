package com.kodilla.good.patterns.challenges.checkoutService;

import com.kodilla.good.patterns.challenges.orderService.OrderService;

public class Checkout implements CheckoutService{
    public boolean finaliseOrder(OrderService orderService) {
        System.out.println("Order finalised");
        return true;
    }
}
