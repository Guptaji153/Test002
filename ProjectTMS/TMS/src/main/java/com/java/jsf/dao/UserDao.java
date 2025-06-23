package com.java.jsf.dao;


import java.util.List;

import com.java.jsf.model.User;

public interface UserDao {

	List<User> showUsers();
	String validate(User loginUser);
	String findUserById(int id);
}
