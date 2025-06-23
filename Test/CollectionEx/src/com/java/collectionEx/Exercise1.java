
// swaping any two elements of a ArrayList

package com.java.collectionEx;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise1 {

	public static void main(String[] args) {
		ArrayList<String> s1 = new ArrayList<String>();
		
		s1.add("Red");
        s1.add("Green");
        s1.add("Black");
        s1.add("White");
        s1.add("Pink");
        
        System.out.println("Array list before Swap:");
        System.out.println(s1);
        
        Collections.swap(s1, 0, 2);
        System.out.println("Array list after swap:");
        System.out.println(s1);
	}
}
