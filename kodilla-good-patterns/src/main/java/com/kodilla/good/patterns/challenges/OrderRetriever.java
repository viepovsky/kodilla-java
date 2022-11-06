package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.orderService.OrderService;
import com.kodilla.good.patterns.challenges.orderService.Order;
import com.kodilla.good.patterns.challenges.productService.GameProduct;

public class OrderRetriever {
    public Order retrieveOrder(){
        Customer customer = new Customer("Marek22","Dworcowa 20");
        GameProduct gameProduct1 = new GameProduct("The Witcher 3 PC",199.90,0.2);
        GameProduct gameProduct2 = new GameProduct("Cyberpunk 2077",299.90,0.2);
        Order order = new Order(customer);
        order.addProductToOrderList(gameProduct1);
        order.addProductToOrderList(gameProduct2);
        return new Order(customer);
    }
}
