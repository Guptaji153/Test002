package com.java.hms.model;

public class Doctor {

	private String doctorId;
	private String doctorName;
	private Specialization specialization;
	private String location;
	private String mobileNo;
	private IsStatus isStatus;
	
	
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public Specialization getSpecialization() {
		return specialization;
	}
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public IsStatus getIsStatus() {
		return isStatus;
	}
	public void setIsStatus(IsStatus isStatus) {
		this.isStatus = isStatus;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Doctor(String doctorId, String doctorName, Specialization specialization, String location, String mobileNo,
			IsStatus isStatus) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.location = location;
		this.mobileNo = mobileNo;
		this.isStatus = isStatus;
	}
	
	
	
}


//doctorId varchar(30),
//doctorName varchar(30),
//specialization ENUM('HEART','SKIN','GENERAL','KIDNEY'),
//location varchar(30),
//mobileNo varchar(20),
//isStatus ENUM('ACTIVE','INACTIVE')