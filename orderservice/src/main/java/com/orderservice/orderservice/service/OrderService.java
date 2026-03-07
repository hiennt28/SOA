package com.orderservice.orderservice.service;

import com.orderservice.orderservice.dto.OrderRequest;
import com.orderservice.orderservice.dto.ProductResponse;
import com.orderservice.orderservice.feign.ProductClient;
import com.orderservice.orderservice.feign.UserClient;
import com.orderservice.orderservice.model.Order;
import com.orderservice.orderservice.repository.OrderRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final UserClient userClient;

    private final ProductClient productClient;

    public OrderService(OrderRepository orderRepository, UserClient userClient, ProductClient productClient) {
        this.orderRepository = orderRepository;
        this.userClient = userClient;
        this.productClient = productClient;
    }

    public Order createOrder(OrderRequest request) {
        Object user = this.userClient.getUserById(request.getUserId());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        ProductResponse product = this.productClient.getProductById(request.getProductId());

        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        float totalPrice = product.getPrice() * request.getQuantity();

        Order order = new Order();
        order.setUserId(Long.valueOf(request.getUserId()));
        order.setProductId(Long.valueOf(request.getProductId()));
        order.setQuantity(request.getQuantity());
        order.setTotalPrice(totalPrice);

        return (Order) this.orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    public Order getOrderById(long id) {
        return (Order) this.orderRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
