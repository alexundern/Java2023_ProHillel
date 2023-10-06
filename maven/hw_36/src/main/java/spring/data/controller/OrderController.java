package spring.data.controller;

import spring.data.dto.OrderDto;
import spring.data.dto.OrderResponse;
import spring.data.entity.Order;
import spring.data.service.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService service;

    @PostMapping("/add")
    public ResponseEntity<Long> addNewOrder(@RequestBody OrderDto orderDto) {
        log.info("Run method add new order");
        Long orderId = service.addOrder(orderDto);
        return new ResponseEntity<>(orderId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
        log.info("Run method get order by id");
        OrderResponse orderResponse = service.getOrderById(id);
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        log.info("Run method get all orders");
        List<Order> orders = service.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping
    public Order updateOrder(@RequestBody Order order){
        log.info("Run method update order");
        return service.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        log.info("Run method delete order by id");
        service.deleteOrderById(id);
        return ResponseEntity.noContent().build();
    }
}
