package com.hillel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Book {
    private final String type;
    private BigDecimal price;
    private final boolean discount;
    private final LocalDate createDate;

    public Book(String type, BigDecimal price, boolean discount, LocalDate createDate) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.createDate = createDate;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean hasDiscount() {
        return discount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }
}
