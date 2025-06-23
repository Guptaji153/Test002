package com.java.cms.model;

public class Restaurant {

	private String restaurantName;
	private String city;
	private double rating;
	private Flag flag;
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public Flag getFlag() {
		return flag;
	}
	public void setFlag(Flag flag) {
		this.flag = flag;
	}
	public Restaurant(String restaurantName, String city, double rating, Flag flag) {
		super();
		this.restaurantName = restaurantName;
		this.city = city;
		this.rating = rating;
		this.flag = flag;
	}
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
