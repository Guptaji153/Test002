package com.java.cms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.cms.model.Restaurant;
import com.java.cms.util.SessionHelper;



public class RestaurantDaoImpl implements RestaurantDao {

	
	SessionFactory sessionFactory;
	Session session;
	
	
	@Override
	public List<Restaurant> showRestaurant() {
		// TODO Auto-generated method stub
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
		Query query = session.getNamedQuery("showRestaurant");
		List<Restaurant> restList = query.list();
		return restList;
		
	}

	
	
	

}
