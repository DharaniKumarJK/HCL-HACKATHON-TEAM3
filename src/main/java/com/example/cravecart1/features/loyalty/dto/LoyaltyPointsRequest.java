package com.example.cravecart1.features.loyalty.dto;

import jakarta.validation.constraints.NotNull;

public class LoyaltyPointsRequest {

    @NotNull
    private Long userId;

    @NotNull
    private Integer points;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
