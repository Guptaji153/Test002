package com.java.ejb.Dao;

import java.sql.SQLException;

import com.java.ejb.Expenses;


public interface ExpensesDao {

	String addExpenses(Expenses expenses) throws ClassNotFoundException, SQLException;
}
