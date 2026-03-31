package com.example.cravecart1.features.loyalty.repo;

import com.example.cravecart1.features.loyalty.entity.LoyaltyPoints;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoyaltyPointsRepository extends JpaRepository<LoyaltyPoints, Long> {
    Optional<LoyaltyPoints> findByUserId(Long userId);
}
