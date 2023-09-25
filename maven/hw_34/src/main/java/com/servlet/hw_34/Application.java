package com.servlet.hw_34;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Главный класс приложения.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.out.println("The order in process!");
        SpringApplication.run(Application.class, args);
    }
}
