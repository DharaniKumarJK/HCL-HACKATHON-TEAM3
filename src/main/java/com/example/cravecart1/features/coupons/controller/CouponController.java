package com.example.cravecart1.features.coupons.controller;

import com.example.cravecart1.features.coupons.dto.CouponRequest;
import com.example.cravecart1.features.coupons.entity.Coupon;
import com.example.cravecart1.features.coupons.service.CouponService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Coupon createCoupon(@Valid @RequestBody CouponRequest request) {
        return couponService.createCoupon(request);
    }

    @GetMapping
    public List<Coupon> listCoupons() {
        return couponService.listCoupons();
    }

    @GetMapping("/{id}")
    public Coupon getCoupon(@PathVariable Long id) {
        return couponService.getCoupon(id);
    }

    @PutMapping("/{id}")
    public Coupon updateCoupon(@PathVariable Long id, @Valid @RequestBody CouponRequest request) {
        return couponService.updateCoupon(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoupon(@PathVariable Long id) {
        couponService.deleteCoupon(id);
    }
}
