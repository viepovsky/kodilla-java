package com.kodilla.good.patterns.challenges.orderService;

import com.kodilla.good.patterns.challenges.Customer;
import com.kodilla.good.patterns.challenges.productService.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Order implements OrderService{
    private final Customer customer;
    private List<ProductService> productList = new ArrayList<>();

    public Order(Customer customer) {
        this.customer = customer;
    }
    public void addProductToOrderList(ProductService productService) {
        productList.add(productService);
    }
}
