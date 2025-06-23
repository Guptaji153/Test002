package com.java.crimeSystem.model;

import java.sql.Date;

public class Report {

	private int reportID;
	private int incidentId;
	private int reportingOfficer;
	private Date reportDate;
	private String reportDetails;
	private String status;
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Report(int reportID, int incidentId, int reportingOfficer, Date reportDate, String reportDetails,
			String status) {
		super();
		this.reportID = reportID;
		this.incidentId = incidentId;
		this.reportingOfficer = reportingOfficer;
		this.reportDate = reportDate;
		this.reportDetails = reportDetails;
		this.status = status;
	}
	public int getReportID() {
		return reportID;
	}
	public void setReportID(int reportID) {
		this.reportID = reportID;
	}
	public int getIncidentId() {
		return incidentId;
	}
	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}
	public int getReportingOfficer() {
		return reportingOfficer;
	}
	public void setReportingOfficer(int reportingOfficer) {
		this.reportingOfficer = reportingOfficer;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public String getReportDetails() {
		return reportDetails;
	}
	public void setReportDetails(String reportDetails) {
		this.reportDetails = reportDetails;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}


//ReportID INT AUTO_INCREMENT PRIMARY KEY,
//IncidentID INT,
//ReportingOfficer INT,
//ReportDate DATETIME,
//ReportDetails TEXT,
//Status ENUM('Draft', 'Finalized'),