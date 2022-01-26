package in.mansii.bankatm;

public class Bank {
	
	private String name;
	private int accNo;
	private String IFSC;
	private float interest;
	private int pin;
	private static float balance;
	
	public Bank(){
		
		this.name="Mansi";
		this.accNo=12345;
		this.IFSC="ABC456";
		this.interest=2.5f;
		this.pin=2345;
		Bank.balance=1000;
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAccount() {
		return this.accNo;
	}
	
	public float getBalance() {
		return this.balance;
	}
	
	public String getDetails() {
		
		String response="Name: "+getName()+"\nAccount Number: "+getAccount()+"\nIFSC Code: "+this.IFSC+"\nInterest Rate: "+this.interest;
		return response;	
	}
	
	public int getPin() {
		return this.pin;
	}
	
	public String generatePin(int newPin1, int newPin2) {
		String response;
		if(newPin1 == newPin2) {
			this.pin=newPin1;
			response="New Pin Generated!\nKindly Login Again.\n";
		}
		else
			response="PIN does not matches!";
		
		return response;
	}
	
	public String bankStatement() {
		
		String response="Bank Balance: "+Bank.balance;
		return response;
	}
	
	public String withdraw(int amount) {
		String response ;
		if(amount<0) {
			response="Enter Valid Amount";
		}
		else if(amount>Bank.balance) {
			response="Insufficient Bank Balance";
		}
		else {
			Bank.balance=Bank.balance-amount;
			response="Money Withdrawn!";
		}
		return response;
	}
	
	public String deposit(int amount) {
		String response ;
		if(amount<0) {
			response="Enter Valid Amount";
		}
		else {
			Bank.balance=Bank.balance+amount;
			response="Money Deposited!";
		}
		return response;
	}

	public boolean validatePin(int pin) {
		if(this.pin==pin) 
			return true;
		else
			return false;
	}

}
