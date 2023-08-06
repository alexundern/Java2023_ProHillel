package com.hillel.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
    private UUID UUID;
    private String name;
    private Double cost;
}
