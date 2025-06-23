package com.java.hms.dao;

import java.util.List;
import com.java.hms.model.Patient;

public interface PatientDao {
//    Patient getPatientById(String patientId);
//    List<Patient> getPatientsByDoctorId(String doctorId);
	
	// Method to search for a patient by their ID
    Patient searchPatientById(String patientId);

    // Method to search for patients by their assigned doctor's ID
    List<Patient> searchPatientByDoctorId(String doctorId);
}
