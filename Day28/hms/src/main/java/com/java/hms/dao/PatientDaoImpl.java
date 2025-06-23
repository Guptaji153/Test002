package com.java.hms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import com.java.hms.model.Patient;
import java.util.List;
import com.java.hms.util.SessionHelper;

public class PatientDaoImpl implements PatientDao {

    private SessionFactory sessionFactory;

    public PatientDaoImpl() {
        sessionFactory = SessionHelper.getConnection();
    }

    @Override
    public Patient searchPatientById(String patientId) {
        Session session = sessionFactory.openSession();
      //  Query query = session.createQuery("FROM Patient WHERE patientId = :patientId");
        Query query = session.createQuery("FROM Patient p JOIN FETCH p.doctor WHERE p.patientId = :patientId");

        query.setParameter("patientId", patientId);
        Patient patient = (Patient) query.uniqueResult();
        session.close();
        return patient;
    }

    @Override
    public List<Patient> searchPatientByDoctorId(String doctorId) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Patient WHERE doctor.doctorId = :doctorId");
        query.setParameter("doctorId", doctorId);
        List<Patient> patientList = query.list();
        session.close();
        return patientList;
    }
}
