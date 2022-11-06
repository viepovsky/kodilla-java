package com.kodilla.good.patterns.challenges.productsStorage;

import com.kodilla.good.patterns.challenges.orderService.OrderService;
import com.kodilla.good.patterns.challenges.productService.ProductService;

public interface ProductsStorage {
    boolean checkStorage(OrderService orderService);
    void removeProductFromStorage(OrderService orderService);
    }

