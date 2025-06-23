package com.java.hms.controller;

import java.util.List;

import com.java.hms.dao.DoctorDao;
import com.java.hms.model.Doctor;

public class DoctorController {

    private DoctorDao doctorDao;
    private Doctor doctor;

    public DoctorDao getDoctorDao() {
        return doctorDao;
    }

    public void setDoctorDao(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    // Only showing doctor list
    public List<Doctor> showDoctorList() {
        return doctorDao.showDoctorDao();
    }
}
