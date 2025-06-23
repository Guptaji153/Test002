package com.java.crimeSystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;

import com.java.crimeSystem.exception.IncidentNotFoundException;
import com.java.crimeSystem.model.IncidentStatus;
import com.java.crimeSystem.model.Incidents;
import com.java.crimeSystem.model.Report;
import com.java.crimeSystem.util.ConnectionHelper;



public class CrimeDaoImp implements CrimeDao {

	 Connection connection;
	    PreparedStatement psmt;
	
	@Override
	public boolean createIncident(Incidents incident) throws ClassNotFoundException, SQLException {
	   
	    boolean result = false;

	   
	    String query = "INSERT INTO Incidents ( IncidentType, IncidentDate, Latitude, Longitude, Description, Status) " +
	                   "VALUES (?, ?, ?, ?, ?, 'open')";

	    connection = ConnectionHelper.getConnection();
	    psmt = connection.prepareStatement(query);
	    
	   // psmt.setInt(1, incident.getIncidentID());
	    psmt.setString(1, incident.getIncidentType());
	    psmt.setDate(2, incident.getIncidentDate()); 
	    psmt.setDouble(3, incident.getLatitude());
	    psmt.setDouble(4, incident.getLongitude());
	    psmt.setString(5, incident.getDescription());
	//    psmt.setString(7, incident.getStatus().name().replace("_", " "));
//	    psmt.setInt(8, incident.getAgencyID());
//	    psmt.setInt(9, incident.getOfficerID());

	    int rows = psmt.executeUpdate();
	    result = rows > 0;

	    return result;
	}

	@Override
	public boolean updateIncidentStatus(IncidentStatus status, int incidentId ,String actionReport) throws ClassNotFoundException, SQLException {
	    connection = ConnectionHelper.getConnection();  
	    String query = "update Incidents set Status = ? , Action_Report = ? WHERE IncidentID = ?";
	    psmt = connection.prepareStatement(query);
// setting status
	    psmt.setString(1, status.name().replace("_", " "));  
	    psmt.setString(2, "Action_Report");
	    psmt.setInt(3, incidentId);  

	    int rows = psmt.executeUpdate();  
	    return rows > 0;  
	}


	@Override
	public List<Incidents> getIncidentsInDateRange(Date startDate,Date endDate) throws ClassNotFoundException, SQLException {
	    connection = ConnectionHelper.getConnection();
	    String query = "select * from Incidents where IncidentDate between ? and ?";
	    psmt = connection.prepareStatement(query);

	   
	    psmt.setDate(1, startDate);
	    psmt.setDate(2, endDate);

	    ResultSet rs = psmt.executeQuery();

	    List<Incidents> incidentsList = new ArrayList<>();

	    while (rs.next()) {
	        Incidents incident = new Incidents();
	        incident.setIncidentID(rs.getInt("IncidentID"));
	        incident.setIncidentType(rs.getString("IncidentType"));
	        incident.setIncidentDate(rs.getDate("IncidentDate"));
	        incident.setLatitude(rs.getDouble("Latitude"));
	        incident.setLongitude(rs.getDouble("Longitude"));
	        incident.setDescription(rs.getString("Description"));

	        // Handle enum conversion gracefully
	        String statusStr = rs.getString("Status");
	        try {
	          
	            IncidentStatus status = IncidentStatus.valueOf(statusStr.replace(" ", "_").toUpperCase());
	            incident.setStatus(status);
	        } catch (IllegalArgumentException e) {
	           
	            incident.setStatus(IncidentStatus.OPEN); 
	            System.err.println("Error converting status value from DB: " + statusStr);
	        }

	        incident.setAgencyID(rs.getInt("AgencyID"));
	        incident.setOfficerID(rs.getInt("OfficerID"));
	        incidentsList.add(incident);
	    }

	    return incidentsList;
	}


	
	


	
	@Override
	public List<Report> generateIncidentReports(Incidents incident) throws SQLException, ClassNotFoundException {
		// Creating a empty list to hold all reports
	    List<Report> reports = new ArrayList<>(); 
	    String query = "SELECT * FROM Reports WHERE IncidentID = ? AND ReportingOfficer = ?";

	   
	     connection = ConnectionHelper.getConnection(); 
	          psmt = connection.prepareStatement(query) ;
	         
	        psmt.setInt(1, incident.getIncidentID());
	        psmt.setInt(2, incident.getOfficerID());

	        ResultSet rs = psmt.executeQuery();  
	            
	            while (rs.next()) {
	                int reportID = rs.getInt("ReportID");
	                int incidentID = rs.getInt("IncidentID");
	                int reportingOfficer = rs.getInt("ReportingOfficer");
	                java.sql.Date reportDate = rs.getDate("ReportDate");
	                String reportDetails = rs.getString("ReportDetails");
	                String status = rs.getString("Status");

	                // Adding a new report to the list
	                reports.add(new Report(reportID, incidentID, reportingOfficer, reportDate, reportDetails, status));
	            }
	        
	    

	   
	    return reports;
	}

	
	
	@Override
	public boolean assignOfficerAndAgencyToIncident(int incidentId, int officerId, int agencyId, String Action_Report) throws SQLException, ClassNotFoundException {
	    
	    connection = ConnectionHelper.getConnection();
	    String query = "UPDATE Incidents SET OfficerID = ?, AgencyID = ?,Action_Report = ?, Status = 'Under Investigation' WHERE IncidentID = ?";

	 
	   
	    psmt = connection.prepareStatement(query);
	    psmt.setInt(1, officerId);
	    psmt.setInt(2, agencyId);
	    psmt.setString(3, Action_Report);
	    psmt.setInt(4, incidentId);

	    // Execute the update query
	    int rowsUpdated = psmt.executeUpdate();

	    return rowsUpdated > 0; 
	}

	
}

	
	

	

	
	
	  

