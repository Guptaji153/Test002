package com.java.crimeSystem.model;



public class Officers {
    private int officerID;
    private String firstName;
    private String lastName;
    private String badgeNumber;
    private int ranko;  // You might want to change this field to a Rank Enum
    private String address;
    private String phoneNumber;
    private int agencyID;

    // Default constructor
    public Officers() {}

    // Parameterized constructor
    public Officers(int officerID, String firstName, String lastName, String badgeNumber, int ranko, String address, String phoneNumber, int agencyID) {
        this.officerID = officerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.badgeNumber = badgeNumber;
        this.ranko = ranko;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.agencyID = agencyID;
    }

    // Getters and Setters
    public int getOfficerID() {
        return officerID;
    }

    public void setOfficerID(int officerID) {
        this.officerID = officerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public int getRanko() {
        return ranko;
    }

    public void setRanko(int ranko) {
        this.ranko = ranko;
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

    public int getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(int agencyID) {
        this.agencyID = agencyID;
    }
}

//CREATE TABLE Officers (
//	    OfficerID INT AUTO_INCREMENT PRIMARY KEY,
//	    FirstName VARCHAR(30),
//	    LastName VARCHAR(30),
//	    BadgeNumber VARCHAR(20) UNIQUE,
//	    Ranko INT,
//	    Address VARCHAR(255),
//	    PhoneNumber VARCHAR(20),
//	    AgencyID INT,
//	    FOREIGN KEY (AgencyID) REFERENCES LawEnforcementAgencies(AgencyID)
//	);