package com.example.cravecart1.features.inventory.dto;

import jakarta.validation.constraints.NotNull;

public class InventoryRequest {

    @NotNull
    private Long productId;

    @NotNull
    private Integer stockQuantity;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
