package com.java.crimeSystem.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.java.crimeSystem.model.IncidentStatus;
import com.java.crimeSystem.model.Incidents;
import com.java.crimeSystem.model.Report;

public interface CrimeDao {

	boolean createIncident(Incidents incident) throws ClassNotFoundException, SQLException;
	
	
	boolean updateIncidentStatus(IncidentStatus status, int incidentId , String actionReport) throws ClassNotFoundException, SQLException;

	List<Incidents> getIncidentsInDateRange(Date startDate, Date endDate) throws ClassNotFoundException, SQLException;

	
	List generateIncidentReports(Incidents incident) throws SQLException, ClassNotFoundException;
	
	boolean assignOfficerAndAgencyToIncident(int incidentId, int officerId, int agencyId, String Action_Report) throws SQLException, ClassNotFoundException;

	
	
}
