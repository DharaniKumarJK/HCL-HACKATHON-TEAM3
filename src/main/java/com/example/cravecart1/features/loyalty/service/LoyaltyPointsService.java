package com.example.cravecart1.features.loyalty.service;

import com.example.cravecart1.features.loyalty.dto.LoyaltyPointsRequest;
import com.example.cravecart1.features.loyalty.entity.LoyaltyPoints;
import com.example.cravecart1.features.loyalty.repo.LoyaltyPointsRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LoyaltyPointsService {

    private final LoyaltyPointsRepository loyaltyPointsRepository;

    public LoyaltyPointsService(LoyaltyPointsRepository loyaltyPointsRepository) {
        this.loyaltyPointsRepository = loyaltyPointsRepository;
    }

    public LoyaltyPoints createLoyaltyPoints(LoyaltyPointsRequest request) {
        LoyaltyPoints loyaltyPoints = new LoyaltyPoints();
        loyaltyPoints.setUserId(request.getUserId());
        loyaltyPoints.setPoints(request.getPoints());
        return loyaltyPointsRepository.save(loyaltyPoints);
    }

    public List<LoyaltyPoints> listLoyaltyPoints() {
        return loyaltyPointsRepository.findAll();
    }

    public LoyaltyPoints getLoyaltyPoints(Long id) {
        return loyaltyPointsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loyalty points not found"));
    }

    public LoyaltyPoints updateLoyaltyPoints(Long id, LoyaltyPointsRequest request) {
        LoyaltyPoints loyaltyPoints = getLoyaltyPoints(id);
        loyaltyPoints.setUserId(request.getUserId());
        loyaltyPoints.setPoints(request.getPoints());
        return loyaltyPointsRepository.save(loyaltyPoints);
    }

    public void deleteLoyaltyPoints(Long id) {
        LoyaltyPoints loyaltyPoints = getLoyaltyPoints(id);
        loyaltyPointsRepository.delete(loyaltyPoints);
    }
}
