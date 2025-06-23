package com.java.jsf.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.jsf.model.InsureanceCompany;
import com.java.jsf.util.SessionHelper;


public class InsureanceCompanyDaoImpl implements InsureanceCompanyDao{
	SessionFactory sessionFactory;
	Session session;
	@Override
	public List<InsureanceCompany> showInsureanceCompany() {
		sessionFactory = SessionHelper.getConnection();
        session = sessionFactory.openSession();
        Query query = session.getNamedQuery("showInsureanceCompany");
        List<InsureanceCompany> userList = query.list();
        session.close();
        return userList;
	}

}
