package com.example.eventmanager.Registration;

import java.time.LocalDate;

import com.example.eventmanager.PaymentStatus;
import com.example.eventmanager.Event.Event;
import com.example.eventmanager.User.User;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Event event;
    private LocalDate createdAt;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    public Registration() {
    }

    public Registration(Long id, User user, Event event, LocalDate createdAt, PaymentStatus paymentStatus) {
        this.id = id;
        this.user = user;
        this.event = event;
        this.createdAt = createdAt;
        this.paymentStatus = paymentStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    
}


