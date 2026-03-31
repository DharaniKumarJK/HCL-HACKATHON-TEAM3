package com.example.cravecart1.features.orders.service;

import com.example.cravecart1.features.orders.dto.OrderItemRequest;
import com.example.cravecart1.features.orders.dto.OrderRequest;
import com.example.cravecart1.features.orders.entity.Order;
import com.example.cravecart1.features.orders.entity.OrderItem;
import com.example.cravecart1.features.orders.entity.OrderStatus;
import com.example.cravecart1.features.orders.repo.OrderRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(OrderRequest request) {
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setStatus(OrderStatus.PENDING);
        order.setItems(toItems(order, request.getItems()));
        order.setTotalAmount(calculateTotal(order.getItems()));
        return orderRepository.save(order);
    }

    public List<Order> listOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    }

    public Order updateOrder(Long id, OrderRequest request) {
        Order order = getOrder(id);
        order.setUserId(request.getUserId());
        order.getItems().clear();
        order.getItems().addAll(toItems(order, request.getItems()));
        order.setTotalAmount(calculateTotal(order.getItems()));
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        Order order = getOrder(id);
        orderRepository.delete(order);
    }

    private List<OrderItem> toItems(Order order, List<OrderItemRequest> items) {
        List<OrderItem> orderItems = new ArrayList<>();
        if (items == null) {
            return orderItems;
        }
        for (OrderItemRequest itemRequest : items) {
            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProductId(itemRequest.getProductId());
            item.setQuantity(itemRequest.getQuantity());
            item.setPrice(itemRequest.getPrice());
            orderItems.add(item);
        }
        return orderItems;
    }

    private BigDecimal calculateTotal(List<OrderItem> items) {
        return items.stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
