package com.java.ejb.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.java.ejb.connection.ConnectionHelper;

public class GroupsMemberDaoImpl implements GroupsMemberDao{

	Connection connection;
	PreparedStatement pst;
	
//	@Override
//	public String addGroupsMember(com.java.ejb.GroupsMember member) throws ClassNotFoundException, SQLException {
//		connection = ConnectionHelper.getConnection();
//	    String cmd = "INSERT INTO group_members (group_id, user_id, is_admin) VALUES (?, ?, ?)";
//	    pst = connection.prepareStatement(cmd);
//	    pst.setInt(1, member.getGroup().getId());
//	    pst.setInt(2, member.getUser().getId());
//	    pst.setBoolean(3, member.isIsAdmin());
//	    pst.executeUpdate();
//	    
//	    return "Group member inserted successfully.";
//	}
	
	@Override
	public String addGroupsMember(com.java.ejb.GroupsMember member) throws ClassNotFoundException, SQLException {
	    connection = ConnectionHelper.getConnection();
	    String cmd = "INSERT INTO group_members (group_id, user_id, joined_at, is_admin) VALUES (?, ?, ?, ?)";
	    pst = connection.prepareStatement(cmd);
	    pst.setInt(1, member.getGroup().getId());
	    pst.setInt(2, member.getUser().getId());
	    pst.setTimestamp(3, member.getJoinedAt());
	    pst.setBoolean(4, member.isIsAdmin());
	    pst.executeUpdate();
	    
	    return "Group member inserted successfully.";
	}


}
