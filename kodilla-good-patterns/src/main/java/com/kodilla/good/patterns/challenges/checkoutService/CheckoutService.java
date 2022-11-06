package com.kodilla.good.patterns.challenges.checkoutService;

import com.kodilla.good.patterns.challenges.orderService.OrderService;

public interface CheckoutService {
    boolean finaliseOrder(OrderService orderService);
}
