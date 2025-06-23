package com.java.jsf.dao;

import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;


import com.java.jsf.model.User;
import com.java.jsf.util.EncryptPassword;
import com.java.jsf.util.SessionHelper;

public class UserDaoImpl implements UserDao {

	SessionFactory sessionFactory;
	Session session;
	@Override
	public List<User> showUsers() {
        sessionFactory = SessionHelper.getConnection();
        session = sessionFactory.openSession();
        Query query = session.getNamedQuery("showUsers");
        List<User> userList = query.list();
        session.close();
        return userList;
	}
	@Override
	public String addUser(User user) {
		 boolean isValid = true;
		  FacesContext context = FacesContext.getCurrentInstance();
		 
		  if (user.getName().length() < 5 || user.getName().length() > 12) {
			  context.addMessage("userForm:name", new FacesMessage(FacesMessage.SEVERITY_ERROR,
	                    "User Name Invalid", "User Name Must be 5 to 12 chars..."));
	            context.validationFailed(); 
	            isValid = false;
	            
		  }
		  if(user.getPassword().length() <8 || user.getPassword().length() >12) {
			  context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					  "Password is not valid", "Password Must Be Between 8 to 12 character"));
			  context.validationFailed();
			  isValid = false;
		  }
		
		  if (isValid==false) {
			  return null;
		  }
		  user.setPassword(EncryptPassword.getCode(user.getPassword()));
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(user);
		trans.commit();
		return "userLogin.jsf?faces-redirect=true";
	}
	
	@Override
	public String authenticate(User user) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	    Session session = null;
	    try {
	        SessionFactory sf = SessionHelper.getConnection();
	        session = sf.openSession();

	        // Encrypt password before querying
	       // String encryptedPassword = EncryptPassword.getCode(userInput.getPassword());
	        String encryptedPassword = EncryptPassword.getCode(user.getPassword());

	        Query query = session.getNamedQuery("authenticateUser");
	        query.setParameter("userName", user.getName());
	        query.setParameter("password", encryptedPassword);

	        User userFound = (User) query.uniqueResult();

	        if (userFound != null) {
	            // Store logged in user details in session
	            sessionMap.put("loggedInUserId", userFound.getName());
	            sessionMap.put("loggedInUser", userFound);

	            // You could add role check if User has roles, or directly redirect:
	            return "UserDashboard.jsf?faces-redirect=true";
	        } else {
	            // Store error message in session for display in the view
	            sessionMap.put("error", "Invalid Credentials. Please try again.");
	            return "userLogin.jsf?faces-redirect=true";
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
