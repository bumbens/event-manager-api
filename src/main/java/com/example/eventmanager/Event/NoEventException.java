package com.example.eventmanager.Event;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoEventException extends RuntimeException{
    public NoEventException(Long id){
    super("No event found with id: " + id);
    }
}
