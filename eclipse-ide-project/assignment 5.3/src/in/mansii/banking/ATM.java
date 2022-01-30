package in.mansii.banking;

import java.util.Scanner;

public class ATM {

	Bank bank; //associated parent bank.
	int accountNumber;
	private String password;
	Scanner sc=new Scanner(System.in);
	

	public ATM(Bank bank) {
		super();
		this.bank = bank;
	}
	
	public void start() {
		System.out.println("Enter Account Number");
		accountNumber=sc.nextInt();
		System.out.println("Enter Password");
		password=sc.next();
		//A secret menu
		if(accountNumber==-1 && password=="NIMDA")
			adminMenu();
		else
			mainMenu();
	}
	
	
	
	private void adminMenu() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("1. open account 2. credit interest 3. view all accounts 0. exit ?");
			int choice=sc.nextInt();
			switch(choice) {
				case 0:
					return ;
					
				case 1: 
					openAccount();
					break;
				
				case 2:
					creditInterest();
					break;
				
				case 3:
					viewAccount();
					break;
					
				default:
					showError("invalid choice. retry");
			}
		}
	}

	private void viewAccount() {
		// TODO Auto-generated method stub
		bank.viewInfo();
	}

	private void creditInterest() {
		// TODO Auto-generated method stub
		boolean result=bank.creditInterest(12);
		if(result== true)
			System.out.println("Interest Credited");
		else
			System.err.println("Failed !");
		
	}

	private void openAccount() {
		// TODO Auto-generated method stub
		System.out.println("Enter Name:");
		String name=sc.next();
		System.out.println("Enter Password:");
		String password=sc.next();
		System.out.println("Enter Amount:");
		double amount=sc.nextDouble();
		
		accountNumber= bank.openAccount(name, password, amount);
		System.out.println("Your Account Number is: "+ accountNumber);
	}

	private void mainMenu() {
		
		while(true) {
			System.out.println("1. deposit 2. withdraw 3. check balance 4. transfer 5. close account 0. exit ?");
			var choice=sc.nextInt();
			switch(choice) {
			case 1:
				doDeposit();
				break;
			case 2:
				doWithdraw();
				break;
				
			case 3:
				doCheckBlance();
				break;
				
			case 4:
				doTransfer();
				break;
				
			case 5:
				doCloseAccount();
				break;
				
			case 0:
				return ;
				
			default:
				showError("invalid choice. retry");
			
			}
		}
	}

	private void showError(String string) {
		// TODO Auto-generated method stub
		System.err.println(string);
	}

	private void doCloseAccount() {
		// TODO Auto-generated method stub
		
	}

	private void doTransfer() {
		// TODO Auto-generated method stub
		System.out.println("amount?");
		double amount=sc.nextDouble();
		System.out.println("target account?");
		int targetAccount=sc.nextInt();
		boolean response= bank.transfer(accountNumber, password, targetAccount , amount);
		if(response== true) {
			showInfo("Amount Transferred Successfully");
		} else {
			showError("Transaction Failed");
		}
		
	}

	private void doCheckBlance() {
		// TODO Auto-generated method stub
		BankAccount account=bank.getAccount(accountNumber,password);
		if(account==null){
			System.err.println("Invalid Credentials");
			return;
		}
		double balance=account.getBalance();
		showInfo("Your Balance:"+balance);
		
	}

	private void doWithdraw() {
		// TODO Auto-generated method stub
		System.out.println("Amount to withdraw?");
		double amount=sc.nextDouble();
		boolean result= bank.withdrawWithCredentials(accountNumber , password , amount);
		if(result==true)
			dispenseCash(amount);
		else
			showError("Transaction Failed");
		
	}

	private void dispenseCash(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Please collect your cash : "+amount);
	}

	private void doDeposit() {
		// TODO Auto-generated method stub
		System.out.println("Deposit Amount?");
		float amount=sc.nextFloat() ;
		if(amount%100!=0) {
			showError("Invalid Denomination");
			return ;
		}
		
		if(bank.depositWithCredentials(accountNumber, amount))
			showInfo("Amount deposited");
		else
			showInfo("Deposit failed");
		
		
	}

	private void showInfo(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}
	
	public static void main(String args[]) {
		
		Scanner sc=new Scanner(System.in);
		ATM atm = new ATM(new Bank("Mansi", 12));
		System.out.println("Enter Secret Code for Admin");
		System.out.println("Press any key for User");
		String code=sc.nextLine();
		if(code.equals("nimda"))
			atm.adminMenu();
		else
			atm.mainMenu();
		
			
	}
	
	
}