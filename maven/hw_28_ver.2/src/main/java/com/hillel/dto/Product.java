package com.hillel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class Product {
    private final UUID uuid;
    private UUID UUID;
    private String name;
    private Double cost;

    public Product() {
        this.uuid = java.util.UUID.randomUUID();
    }
}
