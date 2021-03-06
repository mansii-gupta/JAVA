package in.mansii.bankdetails;

import java.util.Scanner;

public class Operations {
	
	public static void deposit() {
		Scanner sc= new Scanner(System.in);
		BankAccount account= new BankAccount();
		System.out.println("Enter amount to be deposited");
		float amount=sc.nextFloat();
		if(amount<=0.0f) {
			System.out.println("Invalid");
			return;
		}
		float balance=account.getBalance();
		balance=balance+amount;
		account.setBalance(balance);
		System.out.println("Money Deposited Successfully");
		
		System.out.println("New Balance"+ balance);
	
		
	}
	
	public static void withdraw() {
		Scanner sc= new Scanner(System.in);
		BankAccount account= new BankAccount();
		System.out.println("Enter amount to be withdrawn");
		float amount=sc.nextFloat();
		if(amount<=0) {
			System.out.println("Invalid");
			return;
		}
		float balance=account.getBalance();
		if(balance==0.0f) {
			System.out.println("Balance = 0.00rs");
			return;
		}
		if(amount>balance) {
			System.out.println("Insufficient Balance");
			return;
		}
		
		balance=balance-amount;
		account.setBalance(balance);
		System.out.println("Money Withdrawn Successfully");
		
		System.out.println("New Balance"+ balance);
		
		
	}
	
	public void performOperations() {
		Scanner sc= new Scanner(System.in);
		
		while(true) {
			System.out.println("\nEnter your choice");
			System.out.println("1. Deposit \n2. Withdrawl \n3. Exit");
			int choice=sc.nextInt();
			switch(choice) {
		
			case 1: deposit();
					break;
			
			case 2: withdraw();
					break;
			
			case 3: return;
			
			default: System.out.println("Invalid Choice");
			}
		}
	}

}
