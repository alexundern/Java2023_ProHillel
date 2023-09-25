package com.servlet.hw_34.service;

import com.servlet.hw_34.dto.Order;
import com.servlet.hw_34.dto.Product;
import com.servlet.hw_34.exception.OrderNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

/**
 * Реализация интерфейса репозитория заказов.
 */
@Service
@Slf4j
public class OrderRepositoryImpl implements OrderRepository {
    private List<Order> orderList;

    public OrderRepositoryImpl() {
        orderList = new ArrayList<>();
    }

    @Override
    public Order getOrder(Integer id) {
        for (Order order : orderList) {
            if (order.getId().equals(id)) return order;
        }
        log.info("ID not found...");
        throw new OrderNotFoundException("ID not found");
    }

    @Override
    public List<Order> getAllOrders() {
        return orderList;
    }

    @Override
    public boolean addOrder(List<Product> products) {
        Order order = new Order();
        order.setDate(new Timestamp(System.currentTimeMillis()));
        order.setProducts(products);
        order.setCost(order.getProducts().stream().mapToDouble(Product::getCost).sum());
        return orderList.add(order);
    }
}