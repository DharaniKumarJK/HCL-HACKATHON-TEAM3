package com.example.cravecart1.features.coupons.service;

import com.example.cravecart1.features.coupons.dto.CouponRequest;
import com.example.cravecart1.features.coupons.entity.Coupon;
import com.example.cravecart1.features.coupons.repo.CouponRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CouponService {

    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon createCoupon(CouponRequest request) {
        Coupon coupon = new Coupon();
        coupon.setCode(request.getCode());
        coupon.setDiscountPercentage(request.getDiscountPercentage());
        coupon.setValidFrom(request.getValidFrom());
        coupon.setValidTo(request.getValidTo());
        coupon.setActive(request.getIsActive());
        return couponRepository.save(coupon);
    }

    public List<Coupon> listCoupons() {
        return couponRepository.findAll();
    }

    public Coupon getCoupon(Long id) {
        return couponRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Coupon not found"));
    }

    public Coupon updateCoupon(Long id, CouponRequest request) {
        Coupon coupon = getCoupon(id);
        coupon.setCode(request.getCode());
        coupon.setDiscountPercentage(request.getDiscountPercentage());
        coupon.setValidFrom(request.getValidFrom());
        coupon.setValidTo(request.getValidTo());
        coupon.setActive(request.getIsActive());
        return couponRepository.save(coupon);
    }

    public void deleteCoupon(Long id) {
        Coupon coupon = getCoupon(id);
        couponRepository.delete(coupon);
    }
}
