
// find max element in a list
package com.java.collectionEx;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Enter the number of elements:-");
        int n = sc.nextInt();
        System.out.println("Enter the elements");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        int maxElement = findMaxElement(list);

        System.out.println("Maximum element in the list: " + maxElement);
	}
	
	
	public static int findMaxElement(ArrayList<Integer> list) {
        int max = list.get(0); 
        for (Integer element : list) {
            if (element > max) {
                max = element;  
            }
        }
        return max;
    }
}
