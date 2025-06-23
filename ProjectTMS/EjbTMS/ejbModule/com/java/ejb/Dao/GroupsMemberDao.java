package com.java.ejb.Dao;

import java.sql.SQLException;



public interface GroupsMemberDao {

	String addGroupsMember(com.java.ejb.GroupsMember member) throws ClassNotFoundException, SQLException;
}
