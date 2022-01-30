package in.mansii.banking;

public class Bank {

	
	private String name;
	private double rate;
	

	public Bank(String name, double rate) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.rate=rate;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public double getRate() {
		// TODO Auto-generated method stub
		return rate;
	}
	
	int accountCount=0;	
	int lastAccountNumber=0;
	BankAccount [] accounts=new BankAccount[100];


	public int openAccount(String name, String password, double amount) {
		// TODO Auto-generated method stub
		int accountNumber= ++lastAccountNumber;
		accountCount++;
		var account=new BankAccount(accountNumber, name,password,amount);
		accounts[accountNumber]=account;
		return accountNumber;
	}
	
	public void viewInfo() {
		for(int i=1;i<=lastAccountNumber;i++) {
			System.out.println(accounts[i].getName());
			System.out.println(accounts[i].getAccountNumber());
			System.out.println(accounts[i].getBalance()+"\n\n");
			
		}
	}
	
	
	public double closeAccount(int accountNumber, String password) {
		// TODO Auto-generated method stub
		var account=getAccount(accountNumber,password);
		if(account==null)
			return -1;
		
		accounts[accountNumber]=null;
		accountCount--;
		return account.getBalance();
	}

	public int getAccountCount() {
		// TODO Auto-generated method stub
		return accountCount;
	}

	public BankAccount getAccount(int accountNumber, String password) {
		// TODO Auto-generated method stub
		if(accountNumber<1 || accountNumber>lastAccountNumber )
				return null;
		
		var account=accounts[accountNumber];
		if(account==null)
			return null;
		
		if(!account.authenticate(password))
			return null;
		
		return account;
	}

	public int getAccountNumber() {
		return lastAccountNumber;
	}

	public boolean creditInterest(double interestRate) {
		// TODO Auto-generated method stub
		for(int i=1; i<=accountCount;i++) {
			double interest=0;
			if(accounts[i] != null) {
				interest = (accounts[i].getBalance()*interestRate/1200);
				if(accounts[i].deposit(interest) == false) 
					return false;
			}
		}
		return true;
	}
	
	public double getBalanceWithCredentials(int accountNumber, String password) {
		BankAccount account=getAccount(accountNumber, password);
		if(account== null)
			return -1;
		double balance=account.getBalance();
		return balance;
		
	}

	public boolean depositWithCredentials(int accountNumber, float amount) {
//		BankAccount account=accounts[accountNumber];
//		System.out.println("account invalid: "+accounts[accountNumber]);
		for(int i=1; i<=accountCount;i++) {
			if(accounts[i].getAccountNumber()==accountNumber)
			{
				if(accounts[i]==null || amount<0)
					return false;
				accounts[i].deposit(amount);
				return true;
			}
		}

		return false;
	}
	

	public boolean withdrawWithCredentials(int accountNumber, String password, double amount) {
		BankAccount account=getAccount(accountNumber, password);
		if(account== null || amount<0)
			return false;
		Response res=account.withdraw(amount, password);
		if(res.getCode().toString()=="SUCCESS")
			return true;
		return false;
	}
	

	public boolean transfer(int accountNumber, String password, int targetAccount , double amount) {
		// TODO Auto-generated method stub
		BankAccount account=getAccount(accountNumber, password);
		if (account== null)
			return false;
		for(int i=1; i<=accountCount;i++) {
			if(accounts[i].getAccountNumber()==targetAccount) {
				Response res=account.withdraw(amount, password);
				if(res.getCode().toString()=="SUCCESS") {
					accounts[i].deposit(amount);
					return true;
				}
			}
		}
		
		return false;
	}
	
	

}
