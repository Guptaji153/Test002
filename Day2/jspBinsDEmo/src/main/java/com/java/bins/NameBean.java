package com.java.bins;

public class NameBean {

	private String firstName;
	private String lastName;
	
	
	
	
	
	
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


	public String showFullName() {
		return firstName +" "+ lastName;
	}
}
