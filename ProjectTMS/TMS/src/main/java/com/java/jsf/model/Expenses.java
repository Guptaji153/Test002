package com.java.jsf.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Expenses {

	private int id;
	private int groupId;
	private int paidByUser;
	private String description;
	private java.math.BigDecimal totalAmount;
	private Date expenseDate;
	private Timestamp createdAt;
	public int getId() {
		return id;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPaidByUser() {
		return paidByUser;
	}
	public void setPaidByUser(int paidByUser) {
		this.paidByUser = paidByUser;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public java.math.BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(java.math.BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getExpenseDate() {
		return expenseDate;
	}
	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Expenses [id=" + id + ", groupId=" + groupId + ", paidByUser=" + paidByUser + ", description="
				+ description + ", totalAmount=" + totalAmount + ", expenseDate=" + expenseDate + ", createdAt="
				+ createdAt + "]";
	}
	public Expenses() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Expenses(int id, int groupId, int paidByUser, String description, BigDecimal totalAmount, Date expenseDate,
			Timestamp createdAt) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.paidByUser = paidByUser;
		this.description = description;
		this.totalAmount = totalAmount;
		this.expenseDate = expenseDate;
		this.createdAt = createdAt;
	}
	
	

}
//id INT AUTO_INCREMENT PRIMARY KEY,
//group_id INT NOT NULL,
//paid_by_user_id INT NOT NULL,
//description VARCHAR(255) NOT NULL,
//total_amount DECIMAL(10,2) NOT NULL,
//expense_date DATE NOT NULL,
//created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//FOREIGN KEY (group_id) REFERENCES groupss(id),
//FOREIGN KEY (paid_by_user_id) REFERENCES users(id)