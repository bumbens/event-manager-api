package com.example.eventmanager.Registration.Payment;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.eventmanager.PaymentStatus;
import com.example.eventmanager.Registration.Registration;
import com.example.eventmanager.Registration.RegistrationRepository;

@Component
public class PaymentChecker {
    
    @Autowired
    private RegistrationRepository registrationRepository;

    @Scheduled(fixedDelay = 5000)
    public void updatePaymentStatus(){
        List<Registration> registrations = registrationRepository.findByPaymentStatusIn(List.of(
            PaymentStatus.NEW,
            PaymentStatus.PAYMENT_IN_PROGRESS
        ));
        for (Registration registration : registrations) {
            if (registration.getEvent().getPaymentDeadline() != null && 
                registration.getEvent().getPaymentDeadline().isBefore(LocalDate.now())) {
                    registration.setPaymentStatus(PaymentStatus.FAILED);
                    registrationRepository.save(registration);
                }
            
        }
        
    } 
}
