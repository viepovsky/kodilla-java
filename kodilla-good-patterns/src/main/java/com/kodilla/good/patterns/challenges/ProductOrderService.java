package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.checkoutService.CheckoutService;
import com.kodilla.good.patterns.challenges.exceptions.OrderNotStoredInRepositoryException;
import com.kodilla.good.patterns.challenges.orderRepository.OrderRepository;
import com.kodilla.good.patterns.challenges.orderService.OrderService;
import com.kodilla.good.patterns.challenges.productService.ProductService;
import com.kodilla.good.patterns.challenges.productsStorage.ProductsStorage;

public class ProductOrderService {
    private final ProductsStorage productsStorage;
    private final OrderRepository orderRepository;
    private final CheckoutService checkoutService;

    public ProductOrderService(ProductsStorage productsStorage, OrderRepository orderRepository, CheckoutService checkoutService) {
        this.productsStorage = productsStorage;
        this.orderRepository = orderRepository;
        this.checkoutService = checkoutService;
    }
    public void processBuyingProductsFromOrder(OrderService orderService) throws OrderNotStoredInRepositoryException {
        boolean isInStock = productsStorage.checkStorage(orderService);
        if (isInStock){
            productsStorage.removeProductFromStorage(orderService);
            boolean isOrderFinalised = checkoutService.finaliseOrder(orderService);
            if(isOrderFinalised){
                orderRepository.storeOrderInRepository(orderService);
            } else {
                throw new OrderNotStoredInRepositoryException();
            }
        } else {
            System.out.println("We cannot finalise this order, sorry for waisting your time");
        }
    }
}
