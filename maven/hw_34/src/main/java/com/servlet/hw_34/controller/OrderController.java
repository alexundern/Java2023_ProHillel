package com.servlet.hw_34.controller;

import com.servlet.hw_34.dto.Order;
import com.servlet.hw_34.dto.Product;
import com.servlet.hw_34.service.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для управления заказами.
 */
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderRepository orderRepository;
    private static final String GET_ORDER_BY_ID_LOG = "call method get from Order by Id...";
    private static final String GET_ALL_ORDERS_LOG = "call method get all Orders...";
    private static final String ADD_ORDER_LOG = "call method add order...";

    /**
     * Получить заказ по идентификатору.
     *
     * @param id Идентификатор заказа.
     * @return Заказ с указанным идентификатором.
     */
    @GetMapping("/{id}")
    public Order getOrderController(@PathVariable("id") Integer id) {
        log.info(GET_ORDER_BY_ID_LOG);
        return orderRepository.getOrder(id);
    }

    /**
     * Получить список всех заказов.
     *
     * @return Список всех заказов.
     */
    @GetMapping("/all")
    public List<Order> getAllOrdersController() {
        log.info(GET_ALL_ORDERS_LOG);
        return orderRepository.getAllOrders();
    }

    /**
     * Добавить новый заказ.
     *
     * @param products Список продуктов в заказе.
     * @return true, если заказ успешно добавлен, в противном случае - false.
     */
    @PostMapping("")
    public boolean addOrderController(@RequestBody List<Product> products) {
        log.info(ADD_ORDER_LOG);
        products.forEach(product -> log.info("Add product: " + product.getName() + " " + product.getCost()));
        return orderRepository.addOrder(products);
    }
}