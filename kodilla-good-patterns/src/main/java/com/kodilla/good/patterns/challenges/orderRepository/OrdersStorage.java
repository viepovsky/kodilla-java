package com.kodilla.good.patterns.challenges.orderRepository;

import com.kodilla.good.patterns.challenges.orderService.OrderService;

public class OrdersStorage implements OrderRepository{
    public void storeOrderInRepository(OrderService orderService) {
        System.out.println("Order has been stored in repository");
    }
}
