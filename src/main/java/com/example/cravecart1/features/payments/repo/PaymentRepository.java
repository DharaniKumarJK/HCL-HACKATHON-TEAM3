package com.example.cravecart1.features.payments.repo;

import com.example.cravecart1.features.payments.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
