package com.example.eventmanager.Event;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDate date;

    private LocalDate paymentDeadline;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private String location;

    public Event() {
    }

    public Event(Long id, String name, String description, LocalDate date, LocalDate paymentDeadline, BigDecimal price, String location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.paymentDeadline = paymentDeadline;
        this.price = price;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getPaymentDeadline(){
        return paymentDeadline;
    }

    public void setPaymentDeadline(LocalDate paymentDeadline){
        this.paymentDeadline = paymentDeadline;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
}
