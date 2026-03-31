package com.example.cravecart1.features.payments.service;

import com.example.cravecart1.features.payments.dto.PaymentRequest;
import com.example.cravecart1.features.payments.entity.Payment;
import com.example.cravecart1.features.payments.repo.PaymentRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(PaymentRequest request) {
        Payment payment = new Payment();
        payment.setOrderId(request.getOrderId());
        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setPaymentStatus(request.getPaymentStatus());
        payment.setTransactionId(request.getTransactionId());
        payment.setPaidAt(request.getPaidAt());
        return paymentRepository.save(payment);
    }

    public List<Payment> listPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPayment(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment not found"));
    }

    public Payment updatePayment(Long id, PaymentRequest request) {
        Payment payment = getPayment(id);
        payment.setOrderId(request.getOrderId());
        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setPaymentStatus(request.getPaymentStatus());
        payment.setTransactionId(request.getTransactionId());
        payment.setPaidAt(request.getPaidAt());
        return paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        Payment payment = getPayment(id);
        paymentRepository.delete(payment);
    }
}
