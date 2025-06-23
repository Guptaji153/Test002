package com.java.crimeSystem.exception;

public class IncidentNumberNotFoundException extends Exception {

    public IncidentNumberNotFoundException() {
        super("Incident Number not found in the database.");
    }

    public IncidentNumberNotFoundException(String message) {
        super(message);
    }
}
