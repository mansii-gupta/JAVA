package in.mansii.banking;

import java.util.Scanner;

public class BankApp {
	

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int choice, amount;

		System.out.println("Welcome to all in one bank app\n");
		while(true) {
			
			System.out.println("Enter choice of bank");
			System.out.println("1. SBI \n2. ICICI \n");
			
			int type=sc.nextInt();
			switch (type){
				
			case 1:
				//SBI Account
				System.out.println("\n\nEnter your choice");
				System.out.println("1. Open New Account \n2. Deposit \n3. Withdraw \n4. Tansfer Money\n5. View Account \n6. Credit Interest\n7. Close Account ");
				
				choice=sc.nextInt();
				switch (choice) {
				
				case 1:
					//create account
					SBI_Bank.openAccount();
					break;
					
				case 2:
					//deposit money
					System.out.print("Enter amount: ");
					amount=sc.nextInt();
					SBI_Bank.depositMoney(amount);
					break;
					
				case 3:
					//withdraw money
					System.out.print("Enter amount: ");
					amount=sc.nextInt();
					SBI_Bank.withdrawMoney(amount);
					break;
					
					
				case 4:
					//transfer money
					SBI_Bank.tranferMoney();
					break;
					
				case 5:
					//view account
					SBI_Bank.viewInfo();
					break;
					
				case 6:
					//credit interest
					SBI_Bank.creditInterest();
				case 7:
					//close account
					SBI_Bank.closeAccount();
					break;
					
				default:
					System.err.println("Invalid Input\n\n");
				}
				
				break;
				
			case 2:
				//ICICI Account
				System.out.println("Enter your choice");
				System.out.println("1. Open New Account \n2. Deposit \n3. Withdraw \n4. Tansfer Money\n5. View Account \n6. Credit Interest\n7. Close Account  ");
				
				choice=sc.nextInt();
				switch (choice) {
				
				case 1:
					//create account
					ICICI_Bank.openAccount();
					break;
					
				case 2:
					//deposit money
					System.out.print("Enter amount: ");
					amount=sc.nextInt();
					ICICI_Bank.depositMoney(amount);
					break;
					
				case 3:
					//withdraw money
					System.out.print("Enter amount: ");
					amount=sc.nextInt();
					ICICI_Bank.withdrawMoney(amount);
					break;
				
				case 4:
					//transfer money
					ICICI_Bank.tranferMoney();
					break;
				
				case 5:
					//view account
					ICICI_Bank.viewInfo();
					break;
					
				case 6:
					//credit interest
					ICICI_Bank.creditInterest();
					break;
					
				case 7:
					//close account
					ICICI_Bank.closeAccount();
					break;

				default:
					System.err.println("Invalid Input\n\n");
					
				}
				break;
				
				
			default:
				System.err.println("Invalid Input\n\n");
			}
		}
	}
}
