package com.java.ejb;


import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Calculation
 */
@Stateless
@Remote(CalculationRemote.class)
public class Calculation implements CalculationRemote {

    /**
     * Default constructor. 
     */
    public Calculation() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int add(int x, int y) {
		// TODO Auto-generated method stub
		return x+y;
	}

	@Override
	public int sub(int x, int y) {
		// TODO Auto-generated method stub
		return x-y;
	}

	@Override
	public int mul(int x, int y) {
		// TODO Auto-generated method stub
		return x*y;
	}

}
