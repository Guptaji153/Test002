package com.java.collectionEx;

import java.util.Scanner;

public class BankMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the account number");
        String accountNumber = scanner.nextLine();
        System.out.println("Enter the account holder's name");
        String accountHolderName = scanner.nextLine();
        
        System.out.println("Enter the initial balance");
        double balance = scanner.nextDouble();
        
        BankAccount account1 = new BankAccount(accountNumber, accountHolderName, balance);
        
        account1.deposit(500);  
        account1.withdraw(200); 
        account1.withdraw(100); 
        
        System.out.println(account1);
	}
}
