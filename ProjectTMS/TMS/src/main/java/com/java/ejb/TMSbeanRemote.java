package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;



@Remote
public interface TMSbeanRemote {

	List<User> showUsers();
	String addUser(com.java.ejb.User user) throws ClassNotFoundException, SQLException;
	
	//groups..........
	
		String addGroup(com.java.ejb.Group group) throws ClassNotFoundException, SQLException;
		
		// groupsMembers.........
		String addGroupsMember(com.java.ejb.GroupsMember member) throws ClassNotFoundException, SQLException;
		// Expenses........
		String addExpenses(com.java.ejb.Expenses expenses)throws ClassNotFoundException, SQLException;
}
