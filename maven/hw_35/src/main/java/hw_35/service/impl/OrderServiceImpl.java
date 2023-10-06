package hw_35.service.impl;

import hw_35.dto.OrderDto;
import hw_35.entity.Order;
import hw_35.entity.Product;
import hw_35.exception.OrderNotFoundException;
import hw_35.exception.ProductNotFoundException;
import hw_35.repository.OrderRepository;
import hw_35.repository.ProductRepository;
import hw_35.service.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public Order getOrderById(Integer id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> {
                            return new OrderNotFoundException("ORDER_NOT_FOUND");
                        }
                );
        order.setCost(calcOrderCost(order.getProducts()));
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Integer addOrder(OrderDto orderDto) {
        List<Product> products = getProductsList(orderDto.getProducts());
        Order order = new Order()
                .setDate(new Timestamp(System.currentTimeMillis()))
                .setName(orderDto.getName())
                .setProducts(products);
        order.setCost(calcOrderCost(products));
        return orderRepository.save(order).getId();
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException("ORDER_NOT_FOUND");
        }
        orderRepository.deleteById(id);
    }

    private Double calcOrderCost(List<Product> products) {
        return products.stream().mapToDouble(Product::getCost).sum();
    }

    private List<Product> getProductsList(List<Integer> listProducts) {
        List<Product> products = productRepository.findAllById(listProducts);
        List<Integer> getAllProductList = products.stream().map(Product::getId).toList();
        listProducts.removeAll(getAllProductList);
        if (!listProducts.isEmpty()) {
            throw new ProductNotFoundException("Could not found products with id: " + listProducts);
        }
        return products;
    }
}
