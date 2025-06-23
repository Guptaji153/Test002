package com.java.ejb;

import javax.ejb.Remote;

@Remote
public interface CalculationRemote {

	int add(int x, int y);
	int sub(int x, int y );
	int mul(int x, int y);
}
