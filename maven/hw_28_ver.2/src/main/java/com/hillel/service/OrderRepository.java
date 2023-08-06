package com.hillel.service;

import com.hillel.dto.Order;

import java.util.Collection;

public interface OrderRepository {
    Order getOrder(Integer id);
    Collection<Order> getAllOrders();
    void addOrder(Order order);;
}
