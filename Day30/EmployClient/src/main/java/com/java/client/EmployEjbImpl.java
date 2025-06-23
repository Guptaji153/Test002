package com.java.client;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;



public class EmployEjbImpl {

	public List<Employ> showEmployEjb()throws NamingException, ClassNotFoundException, SQLException{
		
		EmployJdbcBeanRemote remote = RemoteHelper.lookupRemoteStatelessEmploy();
		return remote.showEmployEjb();
		
	}
}
