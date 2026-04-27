package com.example.eventmanager.Registration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eventmanager.PaymentStatus;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByPaymentStatusIn(List<PaymentStatus> status);
}
