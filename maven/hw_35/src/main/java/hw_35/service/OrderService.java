package hw_35.service;

import hw_35.dto.OrderDto;
import hw_35.entity.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(Integer id);
    List<Order> getAllOrders();
    Integer addOrder(OrderDto products);
    Order updateOrder(Order order);
    void deleteOrder(Integer id);
}
