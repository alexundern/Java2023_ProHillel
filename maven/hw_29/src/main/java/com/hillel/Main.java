package com.hillel;

import com.hillel.dto.Order;
import com.hillel.service.ClientList;
import com.hillel.service.CoffeeOrderBoard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger("logger");
    public static void main(String[] args) {
//        String projectRoot = System.getProperty("user.dir");
//
//        File logsDirectory = new File(projectRoot + File.separator + "logs");
//        if (!logsDirectory.exists()) {
//            boolean created = logsDirectory.mkdir();
//            if (!created) {
//                System.out.println("Не удалось создать директорию для логов.");
//                return;
//            }
//        }

        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        int clients = 15;
        logger.info("==================== New Day ====================");
        logger.info("Opening a cafe. " + new Timestamp(System.currentTimeMillis()));
        List<String> listName = ClientList.getList(ClientList.CLIENTS_LIST, clients);
        List<Order> orders = listName.stream()
                .map(Order::new)
                .toList();
        for (Order order1 : orders) {
            coffeeOrderBoard.add(String.valueOf(order1));
        }
        coffeeOrderBoard.draw();
        System.out.println("All odd numbers are served");
        logger.info("================ Issuing orders ================");
        List<Order> ordersToDeliver = coffeeOrderBoard.getOrders().stream()
                .filter(order -> order.getId() % 5 != 0)
                .collect(Collectors.toList());

        ordersToDeliver.forEach(order ->
                coffeeOrderBoard.deliver(order.getId()));

        logger.info("================================================");
        logger.info("Testing logging configuration...");
        int numOrder = 5;
        coffeeOrderBoard.deliver(numOrder);
        coffeeOrderBoard.draw();
        coffeeOrderBoard.deliver();
        coffeeOrderBoard.draw();

        logger.info("Closing of the cafe. " + new Timestamp(System.currentTimeMillis()));
        coffeeOrderBoard.closeCaffe();
    }
}