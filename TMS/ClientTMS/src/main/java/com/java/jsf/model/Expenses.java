package com.java.jsf.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Expenses implements Serializable {


	private static final long serialVersionUID = 1L;
	private int id;
	private Groups group;
	private Users payer;
	private String description;
	private BigDecimal  totalAmount;
    private LocalDate expenseDate;
    private LocalDateTime createdAt;
    
    private List<ExpenseSplit> splits;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Groups getGroup() {
		return group;
	}

	public void setGroup(Groups group) {
		this.group = group;
	}

	public Users getPayer() {
		return payer;
	}

	public void setPayer(Users payer) {
		this.payer = payer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal  getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal  totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(LocalDate expenseDate) {
		this.expenseDate = expenseDate;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<ExpenseSplit> getSplits() {
		return splits;
	}

	public void setSplits(List<ExpenseSplit> splits) {
		this.splits = splits;
	}

	public Expenses(int id, Groups group, Users payer, String description, BigDecimal  totalAmount, LocalDate expenseDate,
			LocalDateTime createdAt, List<ExpenseSplit> splits) {
		super();
		this.id = id;
		this.group = group;
		this.payer = payer;
		this.description = description;
		this.totalAmount = totalAmount;
		this.expenseDate = expenseDate;
		this.createdAt = createdAt;
		this.splits = splits;
	}

	public Expenses() {
		super();
		// TODO Auto-generated constructor stub
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