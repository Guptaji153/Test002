package com.java.jsf.model;

import java.util.Date;

public class SettlementResult {
    
    private int id;
    private int groupId;
    private double totalCollected;
    private double totalExpenses;
    private int memberCount;
    private double balancePerPerson;
    private double adminRefundAmount;
    private int adminId;
    private Date settlementDate;

   
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public double getTotalCollected() {
        return totalCollected;
    }
    public void setTotalCollected(double totalCollected) {
        this.totalCollected = totalCollected;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }
    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public int getMemberCount() {
        return memberCount;
    }
    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public double getBalancePerPerson() {
        return balancePerPerson;
    }
    public void setBalancePerPerson(double balancePerPerson) {
        this.balancePerPerson = balancePerPerson;
    }

    public double getAdminRefundAmount() {
        return adminRefundAmount;
    }
    public void setAdminRefundAmount(double adminRefundAmount) {
        this.adminRefundAmount = adminRefundAmount;
    }

    public int getAdminId() {
        return adminId;
    }
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }
    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }
	public SettlementResult(int id, int groupId, double totalCollected, double totalExpenses, int memberCount,
			double balancePerPerson, double adminRefundAmount, int adminId, Date settlementDate) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.totalCollected = totalCollected;
		this.totalExpenses = totalExpenses;
		this.memberCount = memberCount;
		this.balancePerPerson = balancePerPerson;
		this.adminRefundAmount = adminRefundAmount;
		this.adminId = adminId;
		this.settlementDate = settlementDate;
	}
	public SettlementResult() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
