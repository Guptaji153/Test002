package com.java.lms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.lms.model.History;
import com.java.lms.model.LeaveDetails;
import com.java.lms.model.LeaveStatus;
import com.java.lms.model.LeaveType;
import com.java.lms.util.ConnectionHelper;

public class LeaveDAOImpl implements LeaveDetailsDAO {

	Connection connection;
	PreparedStatement pst;
	
	public int dateDiff(Date startDate, Date endDate) {
		long ms = endDate.getTime() - startDate.getTime();
		int diff = (int)(ms/(1000 * 60 * 60 * 24));
		diff++;
		return diff;
	}
	
	@Override
	public String applyLeave(LeaveDetails leaveDetails) throws ClassNotFoundException, SQLException {
		System.out.println(leaveDetails);
		connection = ConnectionHelper.getConnection();
		int diff = dateDiff(leaveDetails.getLeaveStartDate(), leaveDetails.getLeaveEndDate());
		leaveDetails.setNoOfDays(diff);
		String cmd = "Insert into LeaveDetails(EmpId,LeaveStartDate,LeaveEndDate,"
				+ "noOfDays,leaveType,leaveReason) values(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, leaveDetails.getEmpId());
		pst.setDate(2, leaveDetails.getLeaveStartDate());
		pst.setDate(3, leaveDetails.getLeaveEndDate());
		pst.setInt(4, leaveDetails.getNoOfDays());
		pst.setString(5, leaveDetails.getLeaveType().toString());
		pst.setString(6, leaveDetails.getLeaveReason());
		pst.executeUpdate();
		cmd = "Update Employee set LeaveAvail = LeaveAvail - ? Where EmpId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, diff);
		pst.setInt(2, leaveDetails.getEmpId());
		pst.executeUpdate();
		return "Leave Applied...";
	}

	@Override
	public List<History> showLeaveHistory(int empId) throws ClassNotFoundException, SQLException {
	    List<History> leaveHistoryList = new ArrayList();
	    connection = ConnectionHelper.getConnection();
	    
	    String sql = "SELECT * FROM LEAVE_HISTORY WHERE EMP_ID = ?";
	    pst = connection.prepareStatement(sql);
	    pst.setInt(1, empId);
	    ResultSet rs = pst.executeQuery();
	    
	    while (rs.next()) {
	        History history = new History();
	        history.setLeaveId(rs.getInt("LEAVE_ID"));
	        history.setNoOfDays(rs.getInt("LEAVE_NO_OF_DAYS"));
	        history.setManagerComent(rs.getString("LEAVE_MNGR_COMMENTS"));
	        history.setEmpId(rs.getInt("EMP_ID"));
	        history.setStartDate(rs.getDate("LEAVE_START_DATE"));
	        history.setEndDate(rs.getDate("LEAVE_END_DATE"));
	        history.setReason(rs.getString("LEAVE_REASON"));

	        history.setLeaveType(LeaveType.valueOf(rs.getString("LEAVE_TYPE")));
	        history.setLeaveStatus(LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")));

	        leaveHistoryList.add(history);
	    }
	    
	    return leaveHistoryList;
	}

}