package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.checkoutService.Checkout;
import com.kodilla.good.patterns.challenges.exceptions.OrderNotStoredInRepositoryException;
import com.kodilla.good.patterns.challenges.orderRepository.OrdersStorage;
import com.kodilla.good.patterns.challenges.orderService.Order;
import com.kodilla.good.patterns.challenges.productService.GameProduct;
import com.kodilla.good.patterns.challenges.productsStorage.WebsiteShopStorage;

public class Application {
    public static void main(String[] args) throws OrderNotStoredInRepositoryException {
        OrderRetriever orderRetriever = new OrderRetriever();
        Order order =  orderRetriever.retrieveOrder();
        ProductOrderService productOrderService = new ProductOrderService(new WebsiteShopStorage(), new OrdersStorage(), new Checkout());
        productOrderService.processBuyingProductsFromOrder(order);
    }
}
