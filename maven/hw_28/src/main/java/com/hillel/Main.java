//package com.hillel;
//
//import com.hillel.dto.Order;
//import com.hillel.response.StandardResponse;
//import com.hillel.response.StatusResponse;
//import com.hillel.service.OrderRepository;
//import com.hillel.service.OrderRepositoryImpl;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonSyntaxException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import static spark.Spark.*;
//
//public class Main {
//    private static final Logger logger = LoggerFactory.getLogger(Main.class);
//
//    public static void main(String[] args) {
//        OrderRepository orderRepository = new OrderRepositoryImpl();
//        Gson gson = new Gson();
//
//        port(4567);
//
//        //http://localhost:4567/order
//        post("/order", (request, response) -> {
//            response.type("application/json");
//            try {
//                Order order = gson.fromJson(request.body(), Order.class);
//                order.setCost();
//                orderRepository.addOrder(order);
//                return gson.toJson(new StandardResponse(StatusResponse.SUCCESS));
//            } catch (JsonSyntaxException e) {
//                response.status(400);
//                logger.error("Invalid JSON data", e);
//                return gson.toJson(new StandardResponse(StatusResponse.ERROR, "Invalid JSON data"));
//            }
//        }, gson::toJson);
//
//        get("/order", (request, response) -> {
//            response.type("application/json");
//            return gson.toJson(new StandardResponse(StatusResponse.SUCCESS,
//                    gson.toJsonTree(orderRepository.getAllOrders())));
//        });
//
//        get("/order/:id", (request, response) -> {
//            response.type("application/json");
//            try {
//                int orderId = Integer.parseInt(request.params(":id"));
//                Order order = orderRepository.getOrder(orderId);
//                if (order != null) {
//                    return gson.toJson(new StandardResponse(StatusResponse.SUCCESS, gson.toJsonTree(order)));
//                } else {
//                    response.status(404);
//                    logger.warn("Order not found: {}", orderId);
//                    return gson.toJson(new StandardResponse(StatusResponse.ERROR, "Order not found"));
//                }
//            } catch (NumberFormatException e) {
//                response.status(400);
//                logger.error("Invalid order ID", e);
//                return gson.toJson(new StandardResponse(StatusResponse.ERROR, "Invalid order ID"));
//            }
//        });
//    }
//}
//
//
