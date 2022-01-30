package in.mansii.banking;

public class Bank {

	
	private String name;
	private float rate;
	

	public Bank(String name, float rate) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.rate=rate;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public float getRate() {
		// TODO Auto-generated method stub
		return rate;
	}
	
	int accountCount=0;	
	int lastAccountNumber=0;
	BankAccount [] accounts=new BankAccount[100];


	public int openAccount(String name, String password, float amount) {
		// TODO Auto-generated method stub
		int accountNumber= ++lastAccountNumber;
		accountCount++;
		var account=new BankAccount(accountNumber, name,password,amount);
		accounts[accountNumber]=account;
		return accountNumber;
	}
	
	
//	public float closeAccount(int accountNumber, String password) {
//		// TODO Auto-generated method stub
//		var account=getAccount(accountNumber,password);
//		if(account==null)
//			return -1;
//		
//		accounts[accountNumber]=null;
//		accountCount--;
////		return account.getBalance();
//	}

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

	public boolean deposit(int accountNumber, float amount) {
		// TODO Auto-generated method stub
		return false;
	}

	public Response withdraw(int accountNumber, float amount, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response transfer(int accountNumber, int amount, String password, int targetAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	

}














