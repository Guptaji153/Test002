package com.java.ejb.models;

public class Users {

	private int userId;
	private String name;
	private String email;
	private LocalDateTime createdAt;
	
	
	private List<GroupMember> groupMemberships;
    private List<Expense> paidExpenses;
    private List<ExpenseSplit> splits;
}


//id INT AUTO_INCREMENT PRIMARY KEY,
//name VARCHAR(100) NOT NULL,
//email VARCHAR(100) NOT NULL UNIQUE,