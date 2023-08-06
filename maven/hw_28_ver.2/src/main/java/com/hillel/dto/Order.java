package com.hillel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@ToString
public class Order {
    private final Timestamp createdAt;
    private final Timestamp updatedAt;
    private UUID uuid;
    private Timestamp createAt;
    private Timestamp updateAt;
    private double cost;
    private List<Product> products = new ArrayList<>();

    public Order() {
        this.uuid = UUID.randomUUID();
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    private void setCost() {
        cost = 0D;
        if (!products.isEmpty()) {
            for (Product p : products) {
                cost += p.getCost();
            }
        } else {
            System.out.println("Products is empty");
        }
    }

    public void calculateCost() {
        setCost();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
