package com.java.ejb.Dao;

import java.sql.SQLException;

import com.java.ejb.Group;

public interface GroupDao {

	String addGroup(Group group) throws ClassNotFoundException, SQLException;
}
