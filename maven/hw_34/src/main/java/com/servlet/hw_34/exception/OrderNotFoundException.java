package com.servlet.hw_34.exception;

/**
 * Исключение, сигнализирующее о том, что заказ не найден.
 */
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }
}
