package com.smsk.MovieMate.repository;

import com.smsk.MovieMate.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Additional queries if needed
}
