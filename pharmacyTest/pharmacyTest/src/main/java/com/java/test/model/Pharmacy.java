package com.java.test.model;

import java.sql.Timestamp;

public class Pharmacy {

	private String pharmacyId;
	private Timestamp createdAt;
	private String pharmacyName;
	private String contactNo;
	private String email;
	private String password;
	private String state;
	private String city;
	private String licenseNo;
	private String status;
	private String ownerName;
	private String gstNo;
	private String pinCode;
	private String addressLine1;
	public String getPharmacyId() {
		return pharmacyId;
	}
	public void setPharmacyId(String pharmacyId) {
		this.pharmacyId = pharmacyId;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public String getPharmacyName() {
		return pharmacyName;
	}
	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	@Override
	public String toString() {
		return "Pharmacy [pharmacyId=" + pharmacyId + ", createdAt=" + createdAt + ", pharmacyName=" + pharmacyName
				+ ", contactNo=" + contactNo + ", email=" + email + ", password=" + password + ", state=" + state
				+ ", city=" + city + ", licenseNo=" + licenseNo + ", status=" + status + ", ownerName=" + ownerName
				+ ", gstNo=" + gstNo + ", pinCode=" + pinCode + ", addressLine1=" + addressLine1 + "]";
	}
	public Pharmacy(String pharmacyId, Timestamp createdAt, String pharmacyName, String contactNo, String email,
			String password, String state, String city, String licenseNo, String status, String ownerName, String gstNo,
			String pinCode, String addressLine1) {
		super();
		this.pharmacyId = pharmacyId;
		this.createdAt = createdAt;
		this.pharmacyName = pharmacyName;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
		this.state = state;
		this.city = city;
		this.licenseNo = licenseNo;
		this.status = status;
		this.ownerName = ownerName;
		this.gstNo = gstNo;
		this.pinCode = pinCode;
		this.addressLine1 = addressLine1;
	}
	public Pharmacy() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}
