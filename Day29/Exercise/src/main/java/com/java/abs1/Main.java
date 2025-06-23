package com.java.abs1;

public class Main {

	public static void main(String[] args) {
		String name = "Oneplus";
		String mmodel = "Nord";
		AbstractFactory obj = new MobileFactory();
		Mobile mname = obj.getName(name);
		
		Mobile model = obj.getModel(mmodel);
		
		System.out.println(mname.getClass().getSimpleName());
		System.out.println(mname.name());
		
		
		System.out.println();
	}
}
