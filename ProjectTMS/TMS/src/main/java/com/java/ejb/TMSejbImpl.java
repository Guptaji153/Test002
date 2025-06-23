package com.java.ejb;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;

public class TMSejbImpl {
	

	static TMSbeanRemote remote;
	static {
		try {
			remote = RemoteHelper.lookupRemoteStatelessEmploy();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	public String addUserValid(com.java.ejb.User user) throws ClassNotFoundException, SQLException {
	    boolean isValid = true;
	    FacesContext context = FacesContext.getCurrentInstance();

	    if (user.getName() == null || user.getName().length() < 5 || user.getName().length() > 15) {
	        context.addMessage("name", new FacesMessage(FacesMessage.SEVERITY_ERROR,
	                "User Name Invalid!", "Name must be between 5 and 15 characters."));
	        context.validationFailed();
	        isValid = false;
	    }

	    if (!isValid) {
	        return null; // stay on the same page and show errors
	    }

	    remote.addUser(user);
	    return "ShowUser.jsf?faces-redirect=true";
	}

	
//	public String addUserEjb(User user) throws ClassNotFoundException, SQLException {
//		remote.addUser(user);
//		return "ShowUser.jsf?faces-redirect=true";
//	}
	
public String addGroupEjb(com.java.ejb.Group group) throws ClassNotFoundException, SQLException {
	remote.addGroup(group);
	//return "showGroups.jsf?-faces-redirect=true";
	return "showGroups.jsf?faces-redirect=true";

}

	public String addGroupsMember(com.java.ejb.GroupsMember member)throws ClassNotFoundException, SQLException {
		remote.addGroupsMember(member);
		
		
		return "ShowGroupsUsers.jsf?-faces-redirect=true";
	}

	//expenses.............
	public String addExpenses(com.java.ejb.Expenses expenses) throws ClassNotFoundException, SQLException {
		remote.addExpenses(expenses);
		return "expensesList.jsf?-faces-redirect=true";
	}
	


}
