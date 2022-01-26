package in.mansii.banking;

import java.util.Scanner;

public class SBI_Bank {
	
	static BankAccount SBI = null;
	static float interest=12.0f;

	public static boolean isAccount(int accountNumber)
	{
		if(SBI.authenticateAccount(accountNumber)) {
			return true;
		}
		else 
			return false;
	}
	
	public static void openAccount() {
		Scanner sc= new Scanner(System.in);
		String name,password;
		System.out.print("Name: ");
		name=sc.next();
		System.out.print("Password: ");
		password=sc.next();
		
		SBI= new BankAccount(123,name,password,0.00f,interest);
		System.out.println("\nCongratulations, Your Bank Account is Created\n");
		System.out.println("Kindly note:");
		System.out.println("Account Number= 123");
		System.out.println("Initial Balance= 0.00rs\n\n");
		return;
	}
	

	public static void depositMoney(int amount) {
		if(SBI== null) {
			System.err.println("You don't have a SBI bank account\n\n");
			return;
		}
		Scanner sc= new Scanner(System.in);
		
		Response res= SBI.deposit(amount);
		if(res.getMessage()==null) {
			System.out.println("Money Deposited in SBI\n");
		}
		else {
			System.err.println(res.getMessage()+"\n\n");
		}
		return;
	}
	
	
	public static void withdrawMoney(int amount) {
		if(SBI== null) {
			System.err.println("You don't have a SBI bank account\n\n");
			return;
		}
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter your SBI password: ");
		String password=sc.next();
		Response res1= SBI.withdraw(amount,password);
		if(res1.getMessage()==null) {
			System.out.println("Money Withdrawn from SBI\n");
		}
		else {
			System.err.println(res1.getMessage()+"\n\n");
		}
		return;
	}
	
	public static void creditInterest() {
		if(SBI== null) {
			System.err.println("You don't have a SBI bank account\n\n");
			return;
		}
		SBI.creditInterest();
		System.out.println("Interest Credited\n");
		return;
	}
	
	public static void tranferMoney() {
		if(SBI== null) {
			System.err.println("You don't have a SBI bank account\n\n");
			return;
		}
		Scanner sc= new Scanner(System.in);
		System.out.print("ICICI Account Number: ");
		int accountNumber=sc.nextInt();
		if(ICICI_Bank.isAccount(accountNumber)) {
			
			System.out.print("Enter amount to be deposited: ");
			int amount=sc.nextInt();
			SBI_Bank.withdrawMoney(amount);
			ICICI_Bank.depositMoney(amount);
		}
		else
			System.err.println("You don't have a ICICI bank account\n\n");
		return;
	}
	
	
	public static void viewInfo() {
		if(SBI== null) {
			System.err.println("You don't have a SBI bank account\n\n");
			return;
		}
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter your password: ");
		String password=sc.next();
		SBI.viewInfo(password);
		return;
	}
	
	public static void closeAccount() {
		if(SBI== null) {
			System.err.println("You don't have a SBI bank account\n\n");
			return;
		}
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter your password: ");
		String password=sc.next();
		if(SBI.authenticate(password)) {
			SBI=null;
			System.out.println("Account Closed\n\n");
		}
		else {
			System.err.println("Invalid Credentials\n\n");
		}
		return;
	}
	
	
	
}
