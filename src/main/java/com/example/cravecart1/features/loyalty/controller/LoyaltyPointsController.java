package com.example.cravecart1.features.loyalty.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.cravecart1.features.loyalty.dto.LoyaltyPointsRequest;
import com.example.cravecart1.features.loyalty.entity.LoyaltyPoints;
import com.example.cravecart1.features.loyalty.service.LoyaltyPointsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/loyalty-points")
@PreAuthorize("hasRole('ADMIN')")
public class LoyaltyPointsController {

    private final LoyaltyPointsService loyaltyPointsService;

    public LoyaltyPointsController(LoyaltyPointsService loyaltyPointsService) {
        this.loyaltyPointsService = loyaltyPointsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoyaltyPoints createLoyaltyPoints(@Valid @RequestBody LoyaltyPointsRequest request) {
        return loyaltyPointsService.createLoyaltyPoints(request);
    }

    @GetMapping
    public List<LoyaltyPoints> listLoyaltyPoints() {
        return loyaltyPointsService.listLoyaltyPoints();
    }

    @GetMapping("/{id}")
    public LoyaltyPoints getLoyaltyPoints(@PathVariable Long id) {
        return loyaltyPointsService.getLoyaltyPoints(id);
    }

    @PutMapping("/{id}")
    public LoyaltyPoints updateLoyaltyPoints(@PathVariable Long id, @Valid @RequestBody LoyaltyPointsRequest request) {
        return loyaltyPointsService.updateLoyaltyPoints(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLoyaltyPoints(@PathVariable Long id) {
        loyaltyPointsService.deleteLoyaltyPoints(id);
    }
}
