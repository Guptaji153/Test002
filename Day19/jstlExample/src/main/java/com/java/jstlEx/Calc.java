package com.java.jstlEx;

public class Calc {

	private int firstNo;
	private int secondNo;
	private int result;
	
	public int sum() {
		return firstNo +secondNo;
	}
	
	public int sub() {
		return firstNo-secondNo;
	}
	
	public int mult() {
		return firstNo* secondNo;
	}

	public Calc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFirstNo() {
		return firstNo;
	}

	public void setFirstNo(int firstNo) {
		this.firstNo = firstNo;
	}

	public int getSecondNo() {
		return secondNo;
	}

	public void setSecondNo(int secondNo) {
		this.secondNo = secondNo;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	
}
