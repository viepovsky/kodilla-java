package com.kodilla.good.patterns.challenges.orderRepository;

import com.kodilla.good.patterns.challenges.orderService.OrderService;

public interface OrderRepository {
    void storeOrderInRepository(OrderService orderService);
}
