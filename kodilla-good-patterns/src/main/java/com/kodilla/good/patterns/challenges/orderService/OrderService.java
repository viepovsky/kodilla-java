package com.kodilla.good.patterns.challenges.orderService;

import com.kodilla.good.patterns.challenges.productService.ProductService;

public interface OrderService {
    void addProductToOrderList(ProductService productService);
}
