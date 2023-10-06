package spring.data.service.impl;

import spring.data.dto.OrderDto;
import spring.data.dto.OrderResponse;
import spring.data.dto.ProductDto;
import spring.data.entity.Order;
import spring.data.entity.OrderState;
import spring.data.entity.Product;
import spring.data.exceptions.OrderNotFoundException;
import spring.data.repository.OrderRepository;
import spring.data.repository.ProductRepository;
import spring.data.service.OrderService;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final ProductRepository productRepository;

    @Override
    public Long addOrder(OrderDto orderDto) {
        List<Long> productIds = orderDto.getProducts();
        List<Product> products = productRepository.findAllById(productIds);

        double totalCost = products.stream().mapToDouble(Product::getCost).sum();

        Order order = new Order()
                .setDate(Timestamp.from(Instant.now()))
                .setCost(totalCost)
                .setOrderState(OrderState.PENDING);

        order.setProducts(products);

        return repository.save(order).getId();
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("ORDER_NOT_FOUND"));

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setName(order.getProductName());

        List<ProductDto> productDtos = order.getProducts().stream()
                .map(product -> new ProductDto()
                        .setName(product.getName())
                        .setPrice(product.getCost()))
                .collect(Collectors.toList());

        orderResponse.setProducts(productDtos);

        return orderResponse;
    }

    @Override
    public Order updateOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    @Override
    public void deleteOrderById(Long id) {
        repository.deleteById(id);
    }
}
