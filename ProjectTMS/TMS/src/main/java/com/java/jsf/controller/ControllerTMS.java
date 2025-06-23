package com.java.jsf.controller;

import java.sql.SQLException;
import java.util.List;

import javax.faces.context.FacesContext;

import com.java.ejb.TMSejbImpl;
import com.java.jsf.dao.ExpensesDao;
import com.java.jsf.dao.GroupDao;
import com.java.jsf.dao.GroupsMemberDao;
import com.java.jsf.dao.SettlementService;
import com.java.jsf.dao.UserDao;
import com.java.jsf.model.Expenses;
import com.java.jsf.model.Group;
import com.java.jsf.model.GroupsMember;
import com.java.jsf.model.SettlementResult;
import com.java.jsf.model.User;
import com.java.jsf.util.SessionHelper;

public class ControllerTMS {
// user...............
	private UserDao userDao;
	private User user;
	
		public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	// group...............
	private GroupDao groupDao;
	private Group group;
	
	public GroupDao getGroupDao() {
		return groupDao;
	}
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	
	//  groupsMember.............
	
	private GroupsMemberDao groupsMemberDao;
	private GroupsMember groupsMember;
	
	private List<GroupsMember> showGroupMemberList;
	


	public List<GroupsMember> getShowGroupMemberList() {
		return showGroupMemberList;
	}
	public void setShowGroupMemberList(List<GroupsMember> showGroupMemberList) {
		this.showGroupMemberList = showGroupMemberList;
	}
	public GroupsMemberDao getGroupsMemberDao() {
		return groupsMemberDao;
	}
	public void setGroupsMemberDao(GroupsMemberDao groupsMemberDao) {
		this.groupsMemberDao = groupsMemberDao;
	}
	public GroupsMember getGroupsMember() {
		return groupsMember;
	}
	public void setGroupsMember(GroupsMember groupsMember) {
		this.groupsMember = groupsMember;
	}
	
	// Expenses.............
	private ExpensesDao expensesDao;
	private Expenses expenses;
	


	public ExpensesDao getExpensesDao() {
		return expensesDao;
	}
	public void setExpensesDao(ExpensesDao expensesDao) {
		this.expensesDao = expensesDao;
	}
	public Expenses getExpenses() {
		return expenses;
	}
	public void setExpenses(Expenses expenses) {
		this.expenses = expenses;
	}

// server......................

	private com.java.ejb.User ejbUser;
	
	
	
	private TMSejbImpl  tmsEjbImpl;
	
	public com.java.ejb.User getEjbUser() {
		return ejbUser;
	}
	public void setEjbUser(com.java.ejb.User ejbUser) {
		this.ejbUser = ejbUser;
	}
	public TMSejbImpl getTmsEjbImpl() {
		return tmsEjbImpl;
	}
	public void setTmsEjbImpl(TMSejbImpl tmsEjbImpl) {
		this.tmsEjbImpl = tmsEjbImpl;
	}
	//.......... server group .........
	private com.java.ejb.Group ejbGroup;
	
//	public com.java.ejb.Group getEjbGroup() {
//		return ejbGroup;
//	}
	public com.java.ejb.Group getEjbGroup() {
	    if (ejbGroup == null) {
	        ejbGroup = new com.java.ejb.Group();
	    }
	    if (ejbGroup.getUser() == null) {
	        ejbGroup.setUser(new com.java.ejb.User());
	    }
	    return ejbGroup;
	}

	public void setEjbGroup(com.java.ejb.Group ejbGroup) {
		this.ejbGroup = ejbGroup;
	}
	
	//GroupsMember......
	
	private com.java.ejb.GroupsMember ejbGroupsMember;
	

	public com.java.ejb.GroupsMember getEjbGroupsMember() {
		return ejbGroupsMember;
	}
	public void setEjbGroupsMember(com.java.ejb.GroupsMember ejbGroupsMember) {
		this.ejbGroupsMember = ejbGroupsMember;
	}
	
	//Expenses...........
	private com.java.ejb.Expenses ejbExpenses;
	public com.java.ejb.Expenses getEjbExpenses() {
		return ejbExpenses;
	}
	public void setEjbExpenses(com.java.ejb.Expenses ejbExpenses) {
		this.ejbExpenses = ejbExpenses;
	}
//show lists...................

	




	// user show list to store data.................
	private List<User> userList;
	
	
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	// group list which store group data................
	
	private List<Group> groupList;
	

	public List<Group> getGroupList() {
		return groupList;
	}
	public void setGroupList(List<Group> groupList) {
		this.groupList = groupList;
	}
// Expenses list to store ....
	private List<Expenses> ExpensesList;
	
	
	public List<Expenses> getExpensesList() {
		return ExpensesList;
	}
	public void setExpensesList(List<Expenses> expensesList) {
		ExpensesList = expensesList;
	}
// methods...................

		// user validation ......
		public String validate(User user) {
		return userDao.validate(user);
	}
		
	//show users....
	public List<User> showUser(){
		userList = userDao.showUsers();
		return userList;
	}
	
	public List<User> getAllUsers() {
	    return userDao.showUsers();
	}

	
	// add users....
	
	public String addUserEjb(com.java.ejb.User user) throws ClassNotFoundException, SQLException {
		return tmsEjbImpl.addUserValid(user);
	}
	
	// show groups...
	public List<Group> showGroup(){
		groupList = groupDao.showGroup();
		return groupList;
	}
	// show Expenses.....
	public List<Expenses> showExpenses(){
		ExpensesList = expensesDao.showExpenses();
		return ExpensesList;
	}
	
	public String searchEmploy(int empno) {
		return userDao.findUserById(empno);
	}
	//show GroupsMember.....
	public String loadGroupsMember() {
		showGroupMemberList = groupsMemberDao.showGroupsMember();
		return null;
	}
	// add groups......
	public String addGroupEjb(Group group) throws ClassNotFoundException, SQLException {
		return tmsEjbImpl.addGroupEjb(ejbGroup);
	}
	
	//add GroupsMember EJB.......
	public String addUsersMemberEjb(com.java.ejb.GroupsMember member) throws ClassNotFoundException, SQLException {
		return tmsEjbImpl.addGroupsMember(member);
	}
	
	//add Expenses..........
	public String addExpensesEjb(com.java.ejb.Expenses expenses) throws ClassNotFoundException, SQLException {
		return tmsEjbImpl.addExpenses(expenses);
	}
	//...............................
	private SettlementService settlementService;
	
	

	private SettlementResult settlementResult;
	
	
	public SettlementResult getSettlementResult() {
		return settlementResult;
	}
	public void setSettlementResult(SettlementResult settlementResult) {
		this.settlementResult = settlementResult;
	}
	public SettlementService getSettlementService() {
	    if (settlementService == null) {
	        settlementService = new SettlementService(SessionHelper.getConnection());
	    }
	    return settlementService;
	}
	public void setSettlementService(SettlementService settlementService) {
		this.settlementService = settlementService;
	}
	

	public String doSettlement(int groupId) {
	    try {
	        SettlementResult result = getSettlementService().settlement(groupId);
	        this.settlementResult = result;
	        return "settlementSummary";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}



}
