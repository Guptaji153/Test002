package com.java.ejb.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.java.ejb.Group;
import com.java.ejb.connection.ConnectionHelper;

public class GroupDaoImpl implements GroupDao {

	Connection connection;
	PreparedStatement pst;
	
	@Override
	public String addGroup(Group group) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		connection = ConnectionHelper.getConnection();
		String cmd = "INSERT INTO groupss(name, user_id) values(?, ?)";
		PreparedStatement pst = connection.prepareStatement(cmd);
		pst.setString(1, group.getName());
		pst.setInt(2, group.getUser().getId());
		pst.executeUpdate();
		
		return "Group record inserted......";
		
		//String cm = "INSERT INTO users(role) values(admin)";
	}

}
