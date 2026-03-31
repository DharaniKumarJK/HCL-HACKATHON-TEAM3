package com.example.cravecart1.features.inventory.repo;

import com.example.cravecart1.features.inventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
