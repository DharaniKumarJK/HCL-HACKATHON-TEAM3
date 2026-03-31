package com.example.cravecart1.features.coupons.repo;

import com.example.cravecart1.features.coupons.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
