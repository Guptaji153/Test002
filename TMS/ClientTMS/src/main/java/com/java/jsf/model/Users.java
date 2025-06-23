package com.java.jsf.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Users implements Serializable{

	private static final long serialVersionUID = 1L;
	
	    private int id;
	    private String name;
	    private String email;
	    private LocalDateTime createdAt;

	    private List<GroupMembers> groupMemberships;
	    private List<Expenses> paidExpenses;
	    private List<ExpenseSplit> splits;
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public LocalDateTime getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}
		public List<GroupMembers> getGroupMemberships() {
			return groupMemberships;
		}
		public void setGroupMemberships(List<GroupMembers> groupMemberships) {
			this.groupMemberships = groupMemberships;
		}
		public List<Expenses> getPaidExpenses() {
			return paidExpenses;
		}
		public void setPaidExpenses(List<Expenses> paidExpenses) {
			this.paidExpenses = paidExpenses;
		}
		public List<ExpenseSplit> getSplits() {
			return splits;
		}
		public void setSplits(List<ExpenseSplit> splits) {
			this.splits = splits;
		}
		public Users(int id, String name, String email, LocalDateTime createdAt, List<GroupMembers> groupMemberships,
				List<Expenses> paidExpenses, List<ExpenseSplit> splits) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.createdAt = createdAt;
			this.groupMemberships = groupMemberships;
			this.paidExpenses = paidExpenses;
			this.splits = splits;
		}
		public Users() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Users [id=" + id + ", name=" + name + ", email=" + email + ", createdAt=" + createdAt
					+ ", groupMemberships=" + groupMemberships + ", paidExpenses=" + paidExpenses + ", splits=" + splits
					+ "]";
		}
	    
	    
	    
}
