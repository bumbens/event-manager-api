package com.example.eventmanager.Registration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoRegException extends RuntimeException {
    public NoRegException(Long id) {
        super("Registration not found with id: " + id);
    }
}
