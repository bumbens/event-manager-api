package com.example.eventmanager.Registration;

public class RegistrationRequest {
    private Long userId;
    private Long eventId;


    public RegistrationRequest(Long userId, Long eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }

    public RegistrationRequest() {

    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getEventId() {
        return eventId;
    }
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    
}
