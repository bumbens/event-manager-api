package com.example.eventmanager.Registration;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eventmanager.PaymentStatus;
import com.example.eventmanager.Event.Event;
import com.example.eventmanager.Event.EventRepository;
import com.example.eventmanager.Event.NoEventException;
import com.example.eventmanager.User.NoUserException;
import com.example.eventmanager.User.User;
import com.example.eventmanager.User.UserRepository;

@Service
public class RegistrationService {
    
    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;


    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }

    public Registration addNewRegistration(Long userId, Long eventId){
        User user = userRepository.findById(userId).orElseThrow(() -> new NoUserException(userId));
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new NoEventException(eventId));
        Registration registration = new Registration(null, user, event, LocalDate.now(), PaymentStatus.NEW);
        return registrationRepository.save(registration);
    }

    public Registration findRegistrationById(Long regId){
        Registration registration = registrationRepository.findById(regId).orElseThrow(() -> new NoRegException(regId));
        return registration;
    }

    public Registration updateRegistration(Long id, Registration updateRegistration){
        Registration registration = registrationRepository.findById(id).orElseThrow(() -> new NoRegException(id));

        registration.setUser(updateRegistration.getUser());
        registration.setPaymentStatus(updateRegistration.getPaymentStatus());

        return registrationRepository.save(registration);
    }
}
