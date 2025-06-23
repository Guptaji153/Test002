package com.java.jsf.dao;

import com.java.jsf.model.Admin;

public interface AdminDao {

	String addAdmin(Admin admin);
	//String validateAdmin(Admin loginAdmin);
	String authenticate(Admin admin);
	
}
