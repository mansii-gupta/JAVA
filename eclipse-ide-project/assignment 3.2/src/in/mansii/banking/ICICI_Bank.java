package in.mansii.banking;

import java.util.Scanner;

public class ICICI_Bank {

	static BankAccount ICICI=null;
	static float interest=13.0f;
	
	public static boolean isAccount(int accountNumber)
	{
		if(ICICI.authenticateAccount(accountNumber)) {
			return true;
		}
		else 
			return false;
	}
	
	public static void openAccount() {
		Scanner sc= new Scanner(System.in);
		System.out.print("Name: ");
		String name=sc.next();
		System.out.print("Password: ");
		String password=sc.next();
		
		ICICI= new BankAccount(124,name,password,0.00f,interest);
		System.out.println("\nCongratulations, Your Bank Account is Created\n");
		System.out.println("Kindly note:");
		System.out.println("Account Number= 124");
		System.out.println("Initial Balance= 0.00rs\n\n");
		return;
	}
	
	public static void creditInterest() {
		if(ICICI== null) {
			System.err.println("You don't have an ICICI bank account\n\n");
			return;
		}
		ICICI.creditInterest();
		System.out.println("Interest Credited\n");
		return;
	}
	
	
	public static void depositMoney(int amount) {
		if(ICICI== null) {
			System.err.println("You don't have an ICICI bank account\n\n");
			return;
		}
		Scanner sc= new Scanner(System.in);
		Response res= ICICI.deposit(amount);
		if(res.getMessage()==null) {
			System.out.println("Money Deposited in ICICI\n");
		}
		else {
			System.err.println(res.getMessage()+"\n\n");
		}
		return;
	}
	
	public static void withdrawMoney(int amount) {
		if(ICICI== null) {
			System.err.println("You don't have an ICICI bank account\n\n");
			return;
		}
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter your password: ");
		String password=sc.next();
		Response res1= ICICI.withdraw(amount,password);
		if(res1.getMessage()==null) {
			System.out.println("Money Withdrawn\n");
		}
		else {
			System.err.println(res1.getMessage()+"\n\n");
		}
		return;
	}
	
	
	public static void tranferMoney() {
		if(ICICI== null) {
			System.err.println("You don't have an ICICI bank account\n\n");
			return;
		}
		Scanner sc= new Scanner(System.in);
		System.out.print("SBI Account Number: ");
		int accountNumber=sc.nextInt();
		if(SBI_Bank.isAccount(accountNumber)) {
			
			System.out.print("Enter amount to be deposited: ");
			int amount=sc.nextInt();
			SBI_Bank.depositMoney(amount);
			ICICI_Bank.withdrawMoney(amount);
		}
		else
			System.err.println("You don't have a SBI bank account\n\n");
		return;
	}
	
	public static void viewInfo() {
		if(ICICI== null) {
			System.err.println("You don't have an ICICI bank account\n\n");
			return;
		}
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter your password: ");
		String password=sc.next();
		ICICI.viewInfo(password);
		return;
	}
	
	public static void closeAccount() {
		if(ICICI== null) {
			System.err.println("You don't have an ICICI bank account\n\n");
			return;
		}
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter your password: ");
		String password=sc.next();
		if(ICICI.authenticate(password)) {
			ICICI=null;
			System.out.println("Account Closed\n\n");
		}
		else {
			System.err.println("Invalid Credentials\n\n");
		}
		return;
	}
	
	
}
