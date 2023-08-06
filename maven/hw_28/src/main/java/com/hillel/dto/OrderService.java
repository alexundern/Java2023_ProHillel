package com.hillel.dto;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import com.hillel.response.StandardResponse;
import com.hillel.response.StatusResponse;

import com.google.gson.Gson;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderService {
    private static final List<Order> orderList = new ArrayList<>();

    public static void main(String[] args) {

        //get all orders
        get("/order", (request, response) -> {
            response.type("application/json");
            return new Gson().toJsonTree(orderList);
        });

        // get order by id
        get("/order/:uuid", (request, response) -> {
            response.type("application/json");
            UUID uuid = UUID.fromString(request.params(":uuid"));
            return new Gson().toJsonTree(orderList.stream()
                    .filter(o -> o.getUuid().equals(uuid))
                    .findFirst().get());
        });

        // create order
        post("/order", (request, response)  -> {
            response.type("application/json");

            // receive product from UI
            Product product = new Gson().fromJson(request.body(), Product.class);
            product.setUUID(UUID.randomUUID());

            // we don't have order yet -> we create order and put product inside
            Order order = new Order();
            order.setUuid(UUID.randomUUID());
            order.setCreateAt(new Timestamp(System.currentTimeMillis()));
            order.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            // add product
            order.getProducts().add(product);
            // calculate total cost
            order.setCost(order.getProducts().stream().mapToDouble(Product::getCost).sum());

            orderList.add(order);

//            return new Gson().
//                    toJson(new StandardResponse(StatusResponse.SUCCESS,
//                            new Gson().toJsonTree(order)));
                        return new Gson().toJsonTree(order);
        });

        // update order
        put("/order/:uuid", (request, response)  -> {
            response.type("application/json");

            response.type("application/json");
            UUID uuid = UUID.fromString(request.params(":uuid"));
            Order order = orderList.stream()
                    .filter(o -> o.getUuid().equals(uuid))
                    .findFirst().get();

            order.setUpdateAt(new Timestamp(System.currentTimeMillis()));

            Product product = new Gson().fromJson(request.body(), Product.class);
            product.setUUID(UUID.randomUUID());
            order.getProducts().add(product);
            order.setCost(order.getProducts().stream().mapToDouble(Product::getCost).sum());

//            return new Gson().
//                    toJson(new StandardResponse(StatusResponse.SUCCESS,
//                            new Gson().toJsonTree(order)));
            return new Gson().toJsonTree(order);
        });
    }
}
