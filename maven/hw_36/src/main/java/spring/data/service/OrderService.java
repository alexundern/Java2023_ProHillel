package spring.data.service;

import spring.data.dto.OrderDto;
import spring.data.dto.OrderResponse;
import spring.data.entity.Order;

import java.util.List;


public interface OrderService {

    Long addOrder(OrderDto orderDto);

    OrderResponse getOrderById(Long id);

    Order updateOrder(Order order);

    List<Order> getAllOrders();

    void deleteOrderById(Long id);

}
