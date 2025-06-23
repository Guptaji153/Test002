package com.java.abs1;

public class OnePlus implements Mobile {

	@Override
	public String name() {
		//System.out.println("Name is OnePlus...");
		return "Name is OnePlus...";
	}

	@Override
	public void model() {
		System.out.println("Model Nord...");
	}

	@Override
	public void price() {
		System.out.println("Price 30000Rs/-");
	}

}