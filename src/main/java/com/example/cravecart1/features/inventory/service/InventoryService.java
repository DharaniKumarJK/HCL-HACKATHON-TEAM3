package com.example.cravecart1.features.inventory.service;

import com.example.cravecart1.features.inventory.dto.InventoryRequest;
import com.example.cravecart1.features.inventory.entity.Inventory;
import com.example.cravecart1.features.inventory.repo.InventoryRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory createInventory(InventoryRequest request) {
        Inventory inventory = new Inventory();
        inventory.setProductId(request.getProductId());
        inventory.setStockQuantity(request.getStockQuantity());
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> listInventory() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventory(Long id) {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventory not found"));
    }

    public Inventory updateInventory(Long id, InventoryRequest request) {
        Inventory inventory = getInventory(id);
        inventory.setProductId(request.getProductId());
        inventory.setStockQuantity(request.getStockQuantity());
        return inventoryRepository.save(inventory);
    }

    public void deleteInventory(Long id) {
        Inventory inventory = getInventory(id);
        inventoryRepository.delete(inventory);
    }
}
