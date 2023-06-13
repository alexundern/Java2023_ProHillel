package lesson_10.hw_13.coffee.order;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderBoard {

    private List<Order> orders;
    private int orderNumber;

    public CoffeeOrderBoard() {
        orders = new ArrayList<>();
        orderNumber = 1;
    }

    public void add(String name) {
        Order order = new Order(orderNumber, name);
        orders.add(order);
        orderNumber++;
    }

    public void deliver() {
        if (!orders.isEmpty()) {
            Order order = orders.get(0);
            orders.remove(0);
            System.out.println("Delivering order: " + order.getNumber() + " | " + order.getName());
        } else {
            System.out.println("No orders to deliver.");
        }
    }

    public void deliver(int orderNumber) {
        Order orderToDeliver = null;
        int orderIndex = -1;

        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (order.getNumber() == orderNumber) {
                orderToDeliver = order;
                orderIndex = i;
                break;
            }
        }

        if (orderToDeliver != null) {
            orders.remove(orderIndex);
            System.out.println("Delivering order: " + orderToDeliver.getNumber() + " | " + orderToDeliver.getName());
        } else {
            System.out.println("Order not found.");
        }
    }

    public void draw() {
        System.out.println("=============");
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(order.getNumber() + " | " + order.getName());
        }
    }
}

