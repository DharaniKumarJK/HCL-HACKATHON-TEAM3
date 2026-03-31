package com.example.cravecart1.features.carts.dto;

import jakarta.validation.constraints.NotNull;
import java.util.List;

public class CartRequest {

    @NotNull
    private Long userId;

    private List<CartItemRequest> items;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<CartItemRequest> getItems() {
        return items;
    }

    public void setItems(List<CartItemRequest> items) {
        this.items = items;
    }
}
