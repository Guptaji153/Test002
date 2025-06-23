package com.java.jsf.controller;

import java.util.List;

import com.java.jsf.dao.UsersDao;
import com.java.jsf.model.Users;

public class ControllerTMS {

	
	
	private UsersDao userDao;
	private Users users;
	
	private List<Users> usersList;
	
	 public List<Users> getUsersList() {
	        if (usersList == null) {
	            usersList = userDao.showUsers();
	        }
	        return usersList;
	    }
	
	public void setUsersList(List<Users> usersList) {
		this.usersList = usersList;
	}
	
	
	public UsersDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UsersDao userDao) {
		this.userDao = userDao;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	public List<Users> showUsers(){
		usersList = userDao.showUsers();
		return usersList;
	}
	
}
