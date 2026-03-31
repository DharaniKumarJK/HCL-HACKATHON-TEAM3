package com.example.cravecart1.features.products.repo;

import com.example.cravecart1.features.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
