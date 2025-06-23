package com.java.jsf.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Groups implements Serializable {

	private static final long serialVersionUID = 1L;
	    private int id;
	    private String name;
	    private LocalDateTime createdAt;

	    private List<GroupMembers> members;
	    private List<Expenses> expenses;
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
		public LocalDateTime getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}
		public List<GroupMembers> getMembers() {
			return members;
		}
		public void setMembers(List<GroupMembers> members) {
			this.members = members;
		}
		public List<Expenses> getExpenses() {
			return expenses;
		}
		public void setExpenses(List<Expenses> expenses) {
			this.expenses = expenses;
		}
		public Groups() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Groups(int id, String name, LocalDateTime createdAt, List<GroupMembers> members,
				List<Expenses> expenses) {
			super();
			this.id = id;
			this.name = name;
			this.createdAt = createdAt;
			this.members = members;
			this.expenses = expenses;
		}
	    
	    
}

//id INT AUTO_INCREMENT PRIMARY KEY,
//name VARCHAR(100) NOT NULL,
//created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
