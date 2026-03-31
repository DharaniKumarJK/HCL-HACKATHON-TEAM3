package com.example.cravecart1.features.orders.dto;

import jakarta.validation.constraints.NotNull;
import java.util.List;

public class OrderRequest {

    @NotNull
    private Long userId;

    private List<OrderItemRequest> items;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }
}
