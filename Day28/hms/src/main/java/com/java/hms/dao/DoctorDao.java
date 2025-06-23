package com.java.hms.dao;

import java.util.List;
import com.java.hms.model.Doctor;
import com.java.hms.model.IsStatus;
import com.java.hms.model.Specialization;

public interface DoctorDao {

    // Fetch all doctors
    List<Doctor> showDoctorDao();

    // Search a doctor by ID
  //  String searchDoctorDao(String doctorId);
    
    Doctor searchDoctorDao(String doctorId);

    // Add a new doctor
    String addDoctorDao(Doctor doctor);

    // Get doctors by specialization (category)
    List<Doctor> getDoctorsBySpecialization(Specialization specialization);

    List<IsStatus> getStatuses();
}


