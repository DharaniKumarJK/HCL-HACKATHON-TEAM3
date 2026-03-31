package com.example.cravecart1.features.categories.repo;

import com.example.cravecart1.features.categories.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
