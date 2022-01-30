package in.mansii.banking;

import in.mansii.banking.exceptions.InsufficientBalanceException;
import in.mansii.banking.exceptions.InvalidAmountException;
import in.mansii.banking.exceptions.InvalidCredentialsException;
import in.mansii.utils.encryption.Encrypt;

public abstract class BankAccount {
	
	
	protected abstract double getMaxWithdrawableAmount();
	
	private String name; //account holder name
	private int accountNumber;
	
	protected double balance;
	private String password;
	
	
	
	public BankAccount(int accountNumber, String name,String password, double amount) {
		this.accountNumber=accountNumber;
		this.name=name;
		//this.password=password;
		setPassword(password);
		balance=amount;  //this keyword is option here
		
				
	}
	
	public void deposit(double deposit) {
		
		validateAmount(deposit);
		balance+=deposit;
				
	}
	
	private void validateAmount(double amount) {
		if(amount<=0)
			throw new InvalidAmountException(accountNumber,amount,"Amount must be positive value");
		
		if(amount%100 !=0 )
			throw new InvalidAmountException(accountNumber,amount,"Amount must be a multiple of 100");
	}
	
	public void withdraw(double amount,String password) {
		
		authenticate(password);
		validateAmount(amount);

		if(amount>getMaxWithdrawableAmount())
			throw new InsufficientBalanceException(accountNumber, amount-getMaxWithdrawableAmount(),"Insufficient Balance");
		
		
		
		balance-=amount;
		//mission success. no news is good news
	}
	
		
	 

	public void creditInterest(double interestRate) {
		//credits one month interest to the account
		balance+= (balance*interestRate/1200);
	}
	
	
	public String getName() {return name;}	
	public void setName(String name) {this.name=name;}
	
	public int getAccountNumber() {return accountNumber;}

	// can't change the bank account
	//public void setAccountNumber(int accountNumber) {this.accountNumber=accountNumber; }
	
	

	public double getBalance() {
		return balance;
	}

//  You can't change the balance directly
//	public void setBalance(double balance) {
//		this.balance = balance;
//	}


//  You shouldn't allow get password
//  Perhaps get password may not make any sense	
//	public String getPassword() {
//		return password;
//	}
//
	private void setPassword(String password) {
		this.password =Encrypt.instance.encrypt( password,10);
		
	}
	
	public void authenticate(String password) {
		
		if(!Encrypt.instance.match(this.password, password, 10))
			throw new InvalidCredentialsException(accountNumber);		
		
	}
	
	
	public void changePassword(String oldPassword, String newPassword) {
		authenticate(oldPassword);
		//if you reach here old password was correct
		setPassword(newPassword);
		 
	}
	
	
	

	public String info() {
		//System.out.println(accountNumber+"\t"+name+"\t"+balance);
		return String.format("%d\t%s\t%f\n",accountNumber,name,balance);
	}

	//package scope
	//Bank can change it. But client can't
	void setAccountNumber(int accountNumber) {
		// TODO Auto-generated method stub
		this.accountNumber=accountNumber;
		
	}
	
	

}
