package com.java.collectionEx;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise3 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        ArrayList<Integer> list = new ArrayList<>();

	        System.out.println("enter the number of elements:");
	        int n = sc.nextInt();
	        System.out.println("enter the elements:");
	        for (int i = 0; i < n; i++) {
	            list.add(sc.nextInt());
	        }

	        int sum = sum(list);

	        System.out.println("Sum of the elements: " + sum);
	}
	
	
	public static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer element : list) {
            sum += element;
        }
        return sum;
    }
}
