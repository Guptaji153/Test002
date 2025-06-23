package com.java.jsf.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.jsf.model.Users;
import com.java.jsf.util.SessionHelper;

public class UsersDaoImpl implements UsersDao {

	  SessionFactory sessionFactory;
	    Session session;
	
//	@Override
//	public List<Users> showUsers() {
//		// TODO Auto-generated method stub
//		sessionFactory = SessionHelper.getConnection();
//		session = sessionFactory.openSession();
//		Query q = session.getNamedQuery("showUsers");
//		return q.list();
//	}
	    
	    
	    @Override
	    public List<Users> showUsers() {
	        sessionFactory = SessionHelper.getConnection();
	        session = sessionFactory.openSession();
	        List<Users> users = null;

	        try {
	            Query q = session.getNamedQuery("showUsers");
	            users = q.list();

	            // Initialize collections here to avoid lazy loading issues outside session
	            for (Users u : users) {
	                if (u.getGroupMemberships() != null) {
	                    u.getGroupMemberships().size();  // force initialization
	                }
	                if (u.getPaidExpenses() != null) {
	                    u.getPaidExpenses().size();
	                }
	                if (u.getSplits() != null) {
	                    u.getSplits().size();
	                }
	            }
	        } finally {
	            if (session != null) {
	                session.close();
	            }
	        }
	        return users;
	    }


}
