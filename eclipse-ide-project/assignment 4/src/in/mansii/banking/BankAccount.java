package in.mansii.banking;

import in.mansii.utils.Encrypt;

public class BankAccount {
	
	private String name;
	private int accountNumber;
	private float interest;
	private float balance;
	private String password;
	
	public BankAccount(int accountNumber, String name, String password, float amount) {
		
		this.accountNumber=accountNumber;
		this.name=name;
		setPassword(password);
		balance=amount;
				
	}
	
	private void setPassword(String password) {
		
		this.password =Encrypt.instance.encrypt( password,10);
	}
	
	public boolean authenticate(String password) {
		
		return Encrypt.instance.match(this.password, password, 10);
	}
	
	public boolean authenticateAccount(int accountNumber) {
		if(this.accountNumber==accountNumber)
			return true;
		else
			return false;
	}
	
	public Response withdraw(int amount,String password) {
		
		if(!this.authenticate(password))
			return new Response(ResponseStatus.INVALID_CREDENTIALS,"Invalid Credentials");
		if(amount<0)
			return new Response(ResponseStatus.INVALID_AMOUNT,"Enter Positive Amount");
		if(amount>balance)
			return new Response(ResponseStatus.INSUFFICIENT_FUNDS,"Insufficient Funds");
		
		balance=balance-amount;
		return new Response(ResponseStatus.SUCCESS,null);
	}

	public Response deposit(int amount) {
		
		if(amount<0)
			return new Response(ResponseStatus.INVALID_AMOUNT,"Enter Positive Amount");
		
		balance=balance+amount;
		return new Response(ResponseStatus.SUCCESS,null);			
	}
	
	public void creditInterest() {
		//credits one month interest to the account
		balance+= (balance*interest/1200);
	}
	
	public boolean changePassword(String oldPassword, String newPassword) {
		if(this.authenticate(oldPassword)) {
			setPassword(newPassword);
			return true;
		} 
		else {
			return false;
		}
	}
	
	public void viewInfo(String password) {
		if(!this.authenticate(password)) {
			System.out.println("Invalid Credentials");
			return;
		}
		System.out.println("\nName: "+name);
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Interest Rate: "+interest);
		System.out.println("Bank Balance: "+balance+"\n");
	}

}
