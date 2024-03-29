package com.hillel.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
@ToString
public class Order {
    private Integer id;
    private Date date;
    private Double cost;
    private List<Product> products;

    public void setCost() {
        cost = 0D;
        if (!products.isEmpty()) {
            for (Product p : products) {
                cost += p.getCost();
            }
        } else {
            System.out.println("Products is empty");
        }
    }
}
