package com.java.jsf.model;



public class Asset {

	private int id;
	private String name;
	private String description;
	private int quantity;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Asset() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Asset(int id, String name, String description, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
	}
	
	
}
//id INT AUTO_INCREMENT PRIMARY KEY,
//name VARCHAR(100) NOT NULL,
// description text,
// quantity int not null