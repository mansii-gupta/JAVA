package in.mansii.bankdetails;

import java.lang.String;
import java.util.Scanner;


public class BankAccount {
	
	private String name;
	private int accNo= 0;
	private float interest;
	private String password;
	private static float balance;
	
	public float getBalance() {
		return(this.balance);
	}
	
	public void setBalance(float balance) {
		this.balance=balance;
	}
	
	public void setDetails() {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter your Bank Account Details");
		
		System.out.print("Name: ");
		String name=sc.nextLine();
		
		System.out.print("Account Number: ");
		int accNo=sc.nextInt();
		
		System.out.print("Password: ");
		String password=sc.next();
		
		if(password.length()<8) {
			System.out.println("Password length should be more than 8 characters");
			System.out.print("Enter your password again: ");
			password=sc.next();
		}
		
		System.out.println("Accout Created Successfully");
		
		this.name=name;
		this.accNo=accNo;
		this.interest=2.5f;
		this.password=password;
		this.balance=0.0f;
	}
	
	public void getDetails() {
		
		Operations operations=new Operations();
		
		if(this.accNo==0) {
			System.out.println("No Account Available");
			return;
		}
		
		Scanner sc= new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter Account Number");
			int accNo=sc.nextInt();
			if(this.accNo!=accNo) {
				System.out.println("Incorrect Account Number");
			}
			else {
				break;
			}
		}
		
		while(true) {
			System.out.println("Enter Password");
			String password=sc.next();
			if(!this.password.equals(password)) {
				System.out.println("Incorrect Password");
			}
			else {
				break;
			}
		}
		
		
		
		System.out.println("\nHere Are Your Details\n");
		
		System.out.println("Name: "+this.name);
		System.out.println("Account Number:"+ this.accNo);
		System.out.println("Interest Rate: "+this.interest);
		System.out.println("Balance :"+this.balance);
		
		operations.performOperations();
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		BankAccount account= new BankAccount();
		
		
		while(true) {
			System.out.println("1: Open new Account \n2: Existing Account\n3. Exit");
			int choice=sc.nextInt();
		
			switch(choice) {
		
			case 1: account.setDetails();
					break;
				
			case 2: account.getDetails();
					break;
				
			case 3: return;
		
			default: System.out.println("Invalid Choice");
			}
		}
		
	}

}
