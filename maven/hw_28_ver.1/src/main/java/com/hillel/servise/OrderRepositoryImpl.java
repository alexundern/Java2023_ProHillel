package com.hillel.servise;

import com.hillel.dto.Order;

import java.util.Collection;
import java.util.HashMap;
public class OrderRepositoryImpl implements OrderRepository {
    private final HashMap<Integer, Order> orderHashMap;
    public OrderRepositoryImpl() {
        orderHashMap = new HashMap<>();
    }
    @Override
    public Collection<Order> getAllOrders() {
        return orderHashMap.values();
    }
    @Override
    public Order getOrder(Integer id) {
        return orderHashMap.get(id);
    }
    @Override
    public void addOrder(Order order) {
        orderHashMap.put(order.getUuid().hashCode(), order);
    }

}
