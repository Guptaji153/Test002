package com.java.crimeSystem.model;

public class Evidence {

	private int evidenceId;
	private String locationFound;
	private String description;
	private int incidentID;
	public int getEvidenceId() {
		return evidenceId;
	}
	public void setEvidenceId(int evidenceId) {
		this.evidenceId = evidenceId;
	}
	public String getLocationFound() {
		return locationFound;
	}
	public void setLocationFound(String locationFound) {
		this.locationFound = locationFound;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIncidentID() {
		return incidentID;
	}
	public void setIncidentID(int incidentID) {
		this.incidentID = incidentID;
	}
	public Evidence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Evidence(int evidenceId, String locationFound, String description, int incidentID) {
		super();
		this.evidenceId = evidenceId;
		this.locationFound = locationFound;
		this.description = description;
		this.incidentID = incidentID;
	}
	
	
	
	
	
}


//EvidenceID INT AUTO_INCREMENT PRIMARY KEY,
//Description TEXT,
//LocationFound VARCHAR(255),
//IncidentID INT,