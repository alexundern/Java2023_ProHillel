package com.hillel.service;

import com.hillel.dto.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CoffeeOrderBoard {
    private final LinkedList<Order> orders;
    private static final Logger logger = LoggerFactory.getLogger("logger");

    public CoffeeOrderBoard() {
        orders = new LinkedList<>();
    }

    public boolean add(String name) {
        Order order = new Order(name);
        logger.info(name + " ordered.");
        return orders.add(order);
    }

    public boolean deliver() {
        if (orders.isEmpty()) {
            System.out.println("\nThe order list is empty, there is no one to serve.");
            logger.error("ERROR: The order list is empty, there is no one to serve.");
            return false;
        } else {
            Order order = orders.getFirst();
            System.out.println("\nThe first in line, the order is served: " + "№ " +
                    order.getId() + " | " + order.getName() +
                    "\n The order has been completed.");
            logger.info("Order №" + order.getId() + ", " + order.getName() + " got");
            return orders.remove(order);
        }
    }

    public boolean deliver(int idOrder) {
        Optional<Order> orderOptional = orders.stream()
                .filter(order -> order.getId() == idOrder)
                .findFirst();

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            System.out.println("\n The order is serviced: № " + order.getId() + " name of " +
                    order.getName() + "\n The order has been completed.");
            logger.info("Order №" + order.getId() + ", " + order.getName() + " got");
            return orders.remove(order);
        } else {
            System.out.println("\n Order № " + idOrder + " not exist.\n");
            logger.error("ERROR: Order №" + idOrder + " not exist.---");
            return false;
        }
    }

    public void draw() {
        if (!orders.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n Order issuance procedure\n")
                    .append("=============================================\n")
                    .append(String.format("%-12s %s %-5s", "№ order", "|", "Ім'я"))
                    .append("\n=============================================\n");

            orders.stream()
                    .map(order -> String.format("%-12d %s %5s", order.getId(), "|", order.getName()))
                    .forEach(str -> stringBuilder.append(str).append("\n"));

            stringBuilder.append("=============================================\n");
            System.out.println(stringBuilder);
        }
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void closeCaffe() {
        if (!orders.isEmpty()) {
            logger.error("ERROR: Not all customers have been served yet, and we can't close the cafe.");
        } else logger.info("The cafe is closed.");
    }

    @Override
    public String toString() {
        return "CoffeeOrderBoard{" +
                "orders=" + orders +
                '}';
    }
}
