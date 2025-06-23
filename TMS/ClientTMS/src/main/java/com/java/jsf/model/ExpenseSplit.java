package com.java.jsf.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ExpenseSplit implements Serializable {

	private int id;
    private Expenses expense;
    private Users user;
    private BigDecimal  amountOwed;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Expenses getExpense() {
		return expense;
	}
	public void setExpense(Expenses expense) {
		this.expense = expense;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public BigDecimal  getAmountOwed() {
		return amountOwed;
	}
	public void setAmountOwed(BigDecimal  amountOwed) {
		this.amountOwed = amountOwed;
	}
	public ExpenseSplit(int id, Expenses expense, Users user, BigDecimal  amountOwed) {
		super();
		this.id = id;
		this.expense = expense;
		this.user = user;
		this.amountOwed = amountOwed;
	}
	public ExpenseSplit() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}


//id INT AUTO_INCREMENT PRIMARY KEY,
//expense_id INT NOT NULL,
//user_id INT NOT NULL,
//amount_owed DECIMAL(10,2) NOT NULL,