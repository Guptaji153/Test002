package com.java.crimeSystem.model;
import java.util.Date;
public class Suspects {

	    private int suspectID;
	    private String firstName;
	    private String lastName;
	    private Date dateOfBirth;
	    private String gender;
	    private String address;
	    private String phoneNumber;

	    // Default constructor
	    public Suspects() {}

	    // Parameterized constructor
	    public Suspects(int suspectID, String firstName, String lastName, Date dateOfBirth, String gender, String address, String phoneNumber) {
	        this.suspectID = suspectID;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.dateOfBirth = dateOfBirth;
	        this.gender = gender;
	        this.address = address;
	        this.phoneNumber = phoneNumber;
	    }

	    // Getters and Setters
	    public int getSuspectID() {
	        return suspectID;
	    }

	    public void setSuspectID(int suspectID) {
	        this.suspectID = suspectID;
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

	    public Date getDateOfBirth() {
	        return dateOfBirth;
	    }

	    public void setDateOfBirth(Date dateOfBirth) {
	        this.dateOfBirth = dateOfBirth;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
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
	

	
}
