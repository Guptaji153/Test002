package com.java.test1;
public class Main {
	  public static void main(String[] args) {
	        Exceptions e = new Exceptions();
	        e.m1(); 
	    }
	
}
class Exceptions {
	
	 try {
		 public void m1() {
			 System.out.println(10/0);
		 }
	 }
	 finally {
		 System.out.println("inside finally");
	 }
	
}


