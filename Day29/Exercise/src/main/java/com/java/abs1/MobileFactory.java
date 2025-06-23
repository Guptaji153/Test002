package com.java.abs1;

public class MobileFactory implements AbstractFactory{

	@Override
	public Mobile getName(String name) {
		// TODO Auto-generated method stub
		if(name.equals("Iphone")) {
			return new IPhone();
		}
		if(name.equals("Samsung")) {
			return new Samsung();
		}
		if(name.equals("Oneplus")) {
			return new OnePlus();
		}
		return null;
	}

	@Override
	public Mobile getModel(String model) {
		// TODO Auto-generated method stub
		
		if(model.equals("Nord")) {
			//System.out.println(new OnePlus());
			return new OnePlus();
		}
		return null;
		
		
	}

}
