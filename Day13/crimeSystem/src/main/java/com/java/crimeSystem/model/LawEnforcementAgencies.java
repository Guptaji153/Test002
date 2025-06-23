package com.java.crimeSystem.model;



public class LawEnforcementAgencies {

	
	private int agencyID;
	private String agencyName;
	private String Jurisdiction;
	private String address;
	private String phoneNumber;
	public int getAgencyID() {
		return agencyID;
	}
	public void setAgencyID(int agencyID) {
		this.agencyID = agencyID;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getJurisdiction() {
		return Jurisdiction;
	}
	public void setJurisdiction(String jurisdiction) {
		Jurisdiction = jurisdiction;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LawEnforcementAgencies() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LawEnforcementAgencies(int agencyID, String agencyName, String jurisdiction, String address,
			String phoneNumber) {
		super();
		this.agencyID = agencyID;
		this.agencyName = agencyName;
		Jurisdiction = jurisdiction;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "LawEnforcementAgencies [agencyID=" + agencyID + ", agencyName=" + agencyName + ", Jurisdiction="
				+ Jurisdiction + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	
}


//
//CREATE TABLE LawEnforcementAgencies (
//	    AgencyID INT AUTO_INCREMENT PRIMARY KEY,
//	    AgencyName VARCHAR(100),
//	    Jurisdiction VARCHAR(100),
//	    Address VARCHAR(255),
//	    PhoneNumber VARCHAR(20)
//	);