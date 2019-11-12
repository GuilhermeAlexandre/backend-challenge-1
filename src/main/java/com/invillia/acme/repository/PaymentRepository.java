package com.invillia.acme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.invillia.acme.model.Payment;

@Service
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
