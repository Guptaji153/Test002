package com.java.hms.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

import com.java.hms.dao.DoctorDao;
import com.java.hms.dao.PatientDao;
import com.java.hms.model.Doctor;
import com.java.hms.model.Patient;
import com.java.hms.model.IsStatus;
import com.java.hms.model.Specialization;

public class DoctorController {

    private boolean searchPerformed = false;

    public boolean isSearchPerformed() {
        return searchPerformed;
    }

    public void setSearchPerformed(boolean searchPerformed) {
        this.searchPerformed = searchPerformed;
    }

    private DoctorDao doctorDao;
    private PatientDao patientDao;
    private Doctor doctor;
    private Patient patient;

    private List<Doctor> doctorList;
    private List<Patient> patientList;

    private List<IsStatus> statuses;

    // Getters and Setters
    public DoctorDao getDoctorDao() {
        return doctorDao;
    }

    public void setDoctorDao(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    public PatientDao getPatientDao() {
        return patientDao;
    }

    public void setPatientDao(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // Show list of doctors
    public List<Doctor> showDoctorList() {
        if (doctorList == null) {
            doctorList = doctorDao.showDoctorDao();
        }
        return doctorList;
    }

    // Search doctor by ID
    public String searchDoctor(String doctorId) {
        Doctor doctor = doctorDao.searchDoctorDao(doctorId);
        FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getSessionMap()
                    .put("doctorFound", doctor);

        return "SearchDoctor?faces-redirect=true";
    }

    // Add new doctor
    public String addDoctor() {
        try {
            if (doctor != null) {
                doctorDao.addDoctorDao(doctor);
                doctor = new Doctor();  // Reset the doctor object after successful addition
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Doctor added successfully!"));
                return "DoctorList?faces-redirect=true";  // Redirect to doctor list after adding
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error adding doctor", e.getMessage()));
        }
        return "error?faces-redirect=true";  // Redirect to error page if doctor is null
    }

    // Show doctors by specialization
    public List<Doctor> showDoctorsBySpecialization(Specialization specialization) {
        return doctorDao.getDoctorsBySpecialization(specialization);
    }

    // Fetch statuses of doctors (ACTIVE, INACTIVE)
    public List<IsStatus> getStatuses() {
        if (statuses == null) {
            statuses = doctorDao.getStatuses();
        }
        return statuses;
    }

    // Method to search patients by doctor ID
    public void searchPatientsByDoctorId() {
        if (doctor != null && doctor.getDoctorId() != null && !doctor.getDoctorId().isEmpty()) {
            // Search for patients based on the doctor's ID
            patientList = patientDao.searchPatientByDoctorId(doctor.getDoctorId());
            searchPerformed = true;
            
            // Check if no patients found
            if (patientList == null || patientList.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No patients found for the given Doctor ID."));
            }
        } else {
            // Show error message if Doctor ID is not provided
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Please enter a Doctor ID."));
            patientList = null;  // Clear patient list
            searchPerformed = true;
        }
    }

    // Getter for patient list
    public List<Patient> getPatientList() {
        return patientList;
    }

    // Setter for patient list
    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
}
