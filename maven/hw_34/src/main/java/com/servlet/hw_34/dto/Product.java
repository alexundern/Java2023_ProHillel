package com.servlet.hw_34.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс, представляющий сущность "Продукт".
 */
@Getter
@Setter
@ToString
@Data
public class Product {
    private static final AtomicInteger count = new AtomicInteger(0);
    private Integer id;
    private String name;
    private Double cost;

    /**
     * Конструктор для создания нового продукта.
     *
     * @param name Название продукта.
     * @param cost Стоимость продукта.
     */
    public Product(String name, Double cost) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.cost = cost;
    }
}