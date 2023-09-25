package com.servlet.hw_34.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.sql.Timestamp;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс, представляющий сущность "Заказ".
 */
@Getter
@Setter
@ToString
@Data
public class Order {
    private static final AtomicInteger count = new AtomicInteger(0);
    private Integer id;
    private Timestamp date;
    private Double cost;
    private List<Product> products;

    /**
     * Конструктор для создания нового заказа.
     */
    public Order() {
        this.id = count.incrementAndGet();
    }
}