package com.java.hms.model;

import java.sql.Date;

public class Patient {

    private String patientId;
    private String patientName;
    private Doctor doctor;  
    private Date dateOfBirth;

    // Getter and Setter for patientId
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    // Getter and Setter for patientName
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    // Getter and Setter for doctor (instead of doctorId)
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    // Getter and Setter for dateOfBirth
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Constructor
    public Patient(String patientId, String patientName, Doctor doctor, Date dateOfBirth) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctor = doctor;
        this.dateOfBirth = dateOfBirth;
    }

    // Default Constructor
    public Patient() {
        super();
    }
}
