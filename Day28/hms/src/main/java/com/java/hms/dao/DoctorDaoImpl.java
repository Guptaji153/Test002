package com.java.hms.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.java.hms.model.Doctor;
import com.java.hms.model.IsStatus;
import com.java.hms.model.Specialization;
import com.java.hms.util.SessionHelper;

public class DoctorDaoImpl implements DoctorDao {

    SessionFactory sessionFactory;
    Session session;

    private Specialization localCategory;

    public Specialization getLocalCategory() {
        return localCategory;
    }

    public void setLocalCategory(Specialization localCategory) {
        this.localCategory = localCategory;
    }

    public void doctorCategoryChanged(ValueChangeEvent e) {
        this.localCategory = Specialization.valueOf(e.getNewValue().toString());
    }

    public List<Specialization> getSpecializations() {
        return Arrays.asList(Specialization.values());
    }

    @Override
    public List<Doctor> showDoctorDao() {
        sessionFactory = SessionHelper.getConnection();
        session = sessionFactory.openSession();
        Query query = session.getNamedQuery("showDoctors");
        return query.list();
    }

    @Override
    public Doctor searchDoctorDao(String doctorId) {
        sessionFactory = SessionHelper.getConnection();
        session = sessionFactory.openSession();

        Query query = session.getNamedQuery("searchDoctor");
        query.setParameter("doctorId", doctorId);
        Doctor doctor = (Doctor) query.uniqueResult();

        session.close();
        return doctor;
    }


    @Override
    public String addDoctorDao(Doctor doctor) {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean isValid = true;

        if (doctor.getDoctorId() == null || doctor.getDoctorId().trim().isEmpty()) {
            context.addMessage("doctorId", new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Doctor ID Required", "Please provide a valid Doctor ID."));
            isValid = false;
        }

        if (doctor.getDoctorName() == null || doctor.getDoctorName().length() < 3) {
            context.addMessage("doctorName", new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Invalid Name", "Doctor name must be at least 3 characters."));
            isValid = false;
        }

        if (doctor.getMobileNo() == null || !doctor.getMobileNo().matches("\\d{10}")) {
            context.addMessage("mobileNo", new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Invalid Mobile", "Mobile number must be 10 digits."));
            isValid = false;
        }

        if (!isValid) {
            context.validationFailed();
            return null;
        }

        sessionFactory = SessionHelper.getConnection();
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(doctor);
        transaction.commit();
        session.close();

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Success", "Doctor Record Added Successfully"));

        return "AddDoctor.jsp?faces-redirect=true";
    }

    // Method to return the list of doctor statuses as IsStatus enum values
    public List<IsStatus> getStatuses() {
        return Arrays.asList(IsStatus.values()); // Return enum values
    }

    // Convert a string (e.g. "Active", "Inactive") to an IsStatus enum
    public IsStatus convertToIsStatus(String statusString) {
        if (statusString != null) {
            for (IsStatus status : IsStatus.values()) {
                if (status.name().equalsIgnoreCase(statusString)) {
                    return status;
                }
            }
        }
        return IsStatus.INACTIVE;  // Default to INACTIVE if invalid
    }

    public List<Doctor> getDoctorsBySpecialization(Specialization specialization) {
        Session session = SessionHelper.getConnection().openSession();
        Criteria cr = session.createCriteria(Doctor.class);
        cr.add(Restrictions.eq("specialization", specialization));
        return cr.list();
    }
}
