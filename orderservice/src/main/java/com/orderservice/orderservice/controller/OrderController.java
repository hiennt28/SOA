package com.orderservice.orderservice.controller;

import com.orderservice.orderservice.dto.OrderRequest;
import com.orderservice.orderservice.model.Order;
import com.orderservice.orderservice.service.OrderService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createOrder")
    public Order createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping("/getAllOrder")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/getOrder/{id}")
    public Order getOrder(@PathVariable int id) {
        return orderService.getOrderById(id);
    }
}