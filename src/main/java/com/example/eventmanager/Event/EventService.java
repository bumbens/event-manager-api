package com.example.eventmanager.Event;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Event createEvent(Event event){
        event.setDate(LocalDate.now());
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id){
        eventRepository.deleteById(id);
    }

    public Event updateEvent(Long id, Event updatedEvent){ 
        Event event = eventRepository.findById(id).orElseThrow(() -> new NullPointerException());
        event.setName(updatedEvent.getName());
        event.setDate(updatedEvent.getDate());
        event.setDescription(updatedEvent.getDescription());
        event.setLocation(updatedEvent.getLocation());
        event.setPrice(updatedEvent.getPrice());
        return eventRepository.save(updatedEvent);
    }
}
