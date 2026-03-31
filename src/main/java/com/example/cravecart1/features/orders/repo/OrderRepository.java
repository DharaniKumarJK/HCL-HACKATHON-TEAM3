package com.example.cravecart1.features.orders.repo;

import com.example.cravecart1.features.orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
