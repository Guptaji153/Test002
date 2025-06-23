package com.java.jsf.dao;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.java.jsf.model.Admin;
import com.java.jsf.util.EncryptPassword;
import com.java.jsf.util.SessionHelper;

public class AdminDaoImpl implements AdminDao{
	SessionFactory sessionFactory;
	Session session;
	@Override
	public String addAdmin(Admin admin) {
		boolean isValid = true;
		  FacesContext context = FacesContext.getCurrentInstance();
		 
		  if (admin.getName().length() < 5 || admin.getName().length() > 12) {
			  context.addMessage("userForm:name", new FacesMessage(FacesMessage.SEVERITY_ERROR,
	                    "User Name Invalid", "User Name Must be 5 to 12 chars..."));
	            context.validationFailed(); 
	            isValid = false;
	            
		  }
		  if(admin.getPassword().length() <8 || admin.getPassword().length() >12) {
			  context.addMessage("password", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					  "Password is not valid", "Password Must Be Between 8 to 12 character"));
			  context.validationFailed();
			  isValid = false;
		  }
		
		  if (isValid==false) {
			  return null;
		  }
		    admin.setPassword(EncryptPassword.getCode(admin.getPassword()));

		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(admin);
		trans.commit();
		return "Menu.jsp?faces-redirect=true";
	}

	@Override
	public String authenticate(Admin adminInput) {
	    Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	    Session session = null;
	    try {
	        SessionFactory sf = SessionHelper.getConnection();
	        session = sf.openSession();

	        // Encrypt password before querying
	       // String encryptedPassword = EncryptPassword.getCode(adminInput.getPassword());
	        String encryptedPassword = EncryptPassword.getCode(adminInput.getPassword());

	        Query query = session.getNamedQuery("authenticateAdmin");
	        query.setParameter("adminName", adminInput.getName());
	        query.setParameter("password", encryptedPassword);

	        Admin adminFound = (Admin) query.uniqueResult();

	        if (adminFound != null) {
	            // Store logged in admin details in session
	            sessionMap.put("loggedInAdminId", adminFound.getName());
	            sessionMap.put("loggedInAdmin", adminFound);

	            // You could add role check if Admin has roles, or directly redirect:
	            return "AdminDashboard.jsf?faces-redirect=true";
	        } else {
	            // Store error message in session for display in the view
	            sessionMap.put("error", "Invalid Credentials. Please try again.");
	            return "adminLogin.jsf?faces-redirect=true";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        sessionMap.put("error", "Internal error occurred. Please contact support.");
	        return "Login.jsf?faces-redirect=true";
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}




}
