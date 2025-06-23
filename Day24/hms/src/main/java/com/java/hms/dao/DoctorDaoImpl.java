package com.java.hms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.hms.model.Doctor;
import com.java.hms.util.SessionHelper;

public class DoctorDaoImpl implements DoctorDao {

	SessionFactory sessionFactory;
	Session session;
	
	
	@Override
	public List<Doctor> showDoctorDao() {
	    sessionFactory = SessionHelper.getConnection();
	    session = sessionFactory.openSession();
	    Query query = session.getNamedQuery("showDoctors");
	    List<Doctor> doctorList = query.list();
	    return doctorList;
	}


}
