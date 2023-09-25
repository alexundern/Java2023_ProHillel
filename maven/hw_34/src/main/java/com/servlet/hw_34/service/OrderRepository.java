package com.servlet.hw_34.service;

import com.servlet.hw_34.dto.Order;
import com.servlet.hw_34.dto.Product;

import java.util.List;

/**
 * Интерфейс репозитория заказов.
 */
public interface OrderRepository {
    Order getOrder(Integer id);
    List<Order> getAllOrders();
    boolean addOrder(List<Product> product);
}
