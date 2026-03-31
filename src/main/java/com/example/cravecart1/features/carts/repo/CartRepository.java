package com.example.cravecart1.features.carts.repo;

import com.example.cravecart1.features.carts.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
