//Removing any duplicate element(integer) from Arraylist 

package com.java.collectionEx;

import java.util.ArrayList;

public class Exercise2 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(2);
		
		System.out.println("with duplicate"+list);
		
		ArrayList<Integer> newlist = duplicateRemove(list);
		System.out.println("after removing duplicate"+newlist);
	}
	
	
	public static ArrayList<Integer> duplicateRemove(ArrayList<Integer> list){
		
		// new arraylist to store unique 
		ArrayList<Integer> list1 = new ArrayList<>();
		
		for(int i = 0; i<list.size(); i++) {
			Integer it = list.get(i);
			if(!list1.contains(it)) {
				list1.add(it);
			}
		}
		return list1;
		
	}
}
