package com.project.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.payment.entity.Payment;


@Repository
@Transactional(readOnly = true)
public interface PaymentRepository  extends JpaRepository<Payment, Long> {
}
