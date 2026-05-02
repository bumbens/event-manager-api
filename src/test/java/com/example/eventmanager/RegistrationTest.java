package com.example.eventmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.eventmanager.Event.Event;
import com.example.eventmanager.Registration.NoRegException;
import com.example.eventmanager.Registration.Registration;
import com.example.eventmanager.Registration.RegistrationRepository;
import com.example.eventmanager.Registration.RegistrationService;
import com.example.eventmanager.User.User;

@ExtendWith(MockitoExtension.class)
public class RegistrationTest {
    @Mock
    private RegistrationRepository registrationRepository;

    @InjectMocks
    private RegistrationService registrationService;

    @Test
    public void testGetAllReservations(){
        when(registrationRepository.findAll()).thenReturn(List.of(
            new Registration(1L, 
                new User(1L, "John Doe", "john@doe.com"), 
                new Event(1L, "Test Event", "Just for testing", LocalDate.now().plusMonths(2), LocalDate.now().plusMonths(1), new BigDecimal(100.0), "Copenhagen"), 
            LocalDate.now(), PaymentStatus.NEW),
            new Registration(2L, 
                new User(2L, "John Smith", "john@smith.com"), 
                new Event(2L, "Another Test Event", "Same as before", LocalDate.now().plusMonths(3), LocalDate.now().plusMonths(2), new BigDecimal(200.0), "Aarhus"), 
            LocalDate.now(), PaymentStatus.PAYMENT_IN_PROGRESS)
        ));
        List<Registration> registrations = registrationService.getAllRegistrations();
        assertEquals(2, registrations.size());
    }

    @Test
    public void testGetJobById(){
        Registration testRegistration = new Registration(1L, 
                new User(1L, "John Doe", "john@doe.com"), 
                new Event(1L, "Test Event", "Just for testing", LocalDate.now().plusMonths(2), LocalDate.now().plusMonths(1), new BigDecimal(100.0), "Copenhagen"), 
            LocalDate.now(), PaymentStatus.NEW);
        when(registrationRepository.findById(1L)).thenReturn(Optional.of(testRegistration));
        Registration result = registrationService.findRegistrationById(1L);
        assertEquals(1L, result.getId());
    }

    @Test
    public void testGetJobById_NotFound(){
        when(registrationRepository.findById(999L)).thenReturn(Optional.empty());
        assertThrows(NoRegException.class, () -> registrationService.findRegistrationById(999L));
    }
}
