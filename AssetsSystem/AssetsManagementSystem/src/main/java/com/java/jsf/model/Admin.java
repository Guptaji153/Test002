package com.java.jsf.model;

import java.sql.Timestamp;

public class Admin {

	private int id;
	private String name;
	private String password;
	private String email;
	private Timestamp createdAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", createdAt="
				+ createdAt + "]";
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int id, String name, String password, String email, Timestamp createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.createdAt = createdAt;
	}
	
	
}
//id INT AUTO_INCREMENT PRIMARY KEY,
//name VARCHAR(100) NOT NULL,
// password VARCHAR(40) NOT NULL UNIQUE,
//email VARCHAR(100) NOT NULL UNIQUE,
//
//created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP