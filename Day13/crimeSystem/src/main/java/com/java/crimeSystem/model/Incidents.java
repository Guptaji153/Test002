package com.java.crimeSystem.model;

import java.sql.Date;

public class Incidents {

	  private int incidentID;
	    private String incidentType;
	    private Date incidentDate;
	    private double latitude;
	    private double longitude;
	    private String description;
	    private IncidentStatus status ;
	    private int agencyID;
	    private int officerID;
	    private String Action_Report;
	    
	    // geters and seters 
		public int getIncidentID() {
			return incidentID;
		}
		public void setIncidentID(int incidentID) {
			this.incidentID = incidentID;
		}
		public String getIncidentType() {
			return incidentType;
		}
		public String getAction_Report() {
			return Action_Report;
		}
		public void setAction_Report(String action_Report) {
			Action_Report = action_Report;
		}
		public void setIncidentType(String incidentType) {
			this.incidentType = incidentType;
		}
		public Date getIncidentDate() {
		    return incidentDate;
		}
		public void setIncidentDate(Date incidentDate) {
		    this.incidentDate = incidentDate;
		}
		public double getLatitude() {
			return latitude;
		}
		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}
		public double getLongitude() {
			return longitude;
		}
		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public IncidentStatus getStatus() {
			return status;
		}
		public void setStatus(IncidentStatus status) {
			this.status = status;
		}
		public int getAgencyID() {
			return agencyID;
		}
		public void setAgencyID(int agencyID) {
			this.agencyID = agencyID;
		}
		public int getOfficerID() {
			return officerID;
		}
		public void setOfficerID(int officerID) {
			this.officerID = officerID;
		}
		
		
		
		public Incidents() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Incidents(int incidentID, String incidentType, Date incidentDate, double latitude, double longitude,
				String description, IncidentStatus status, int agencyID, int officerID, String Action_Report) {
			super();
			this.incidentID = incidentID;
			this.incidentType = incidentType;
			this.incidentDate = incidentDate;
			this.latitude = latitude;
			this.longitude = longitude;
			this.description = description;
			this.status = status;
			this.agencyID = agencyID;
			this.officerID = officerID;
			this.Action_Report= Action_Report;
		}
		
		
		
	    
	    
	    
	
}

//
//CREATE TABLE Incidents (
//	    IncidentID INT AUTO_INCREMENT PRIMARY KEY,
//	    IncidentType VARCHAR(50),
//	    IncidentDate DATETIME,
//	    Latitude DECIMAL(9,6),
//	    Longitude DECIMAL(9,6),
//	    Description TEXT,
//	    Status ENUM('Open', 'Closed', 'Under Investigation'),
//	    AgencyID INT,
//	    OfficerID INT,
//	    FOREIGN KEY (AgencyID) REFERENCES LawEnforcementAgencies(AgencyID),
//	    FOREIGN KEY (OfficerID) REFERENCES Officers(OfficerID)
//	);