package com.java.crimeSystem.exception;

public class IncidentNotFoundException extends Exception {
    
   
    public IncidentNotFoundException() {
        super("No incidents found for the specified criteria.");
    }
    
    
    public IncidentNotFoundException(String message) {
        super(message);
    }
}
