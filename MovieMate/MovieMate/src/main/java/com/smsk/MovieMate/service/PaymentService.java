package com.smsk.MovieMate.service;

import com.smsk.MovieMate.model.Payment;
import com.smsk.MovieMate.model.PaymentStatus;
import com.smsk.MovieMate.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public Payment processPayment(Payment payment) {
        // Simulate payment processing logic (integrate with payment gateway in real-world)
        payment.setPaymentDateTime(LocalDateTime.now());
        payment.setPaymentStatus(PaymentStatus.valueOf("SUCCESS"));
        return paymentRepository.save(payment);
    }
}
