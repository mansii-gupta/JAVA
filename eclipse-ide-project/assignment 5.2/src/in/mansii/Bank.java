package in.mansii;

public class Bank {

	private String name;
	private int accountNumber;
	private float balance;
	private String password;
	
	public Bank(int accountNumber, String name, String password, float amount) {
		
		this.accountNumber=accountNumber;
		this.name=name;
		this.password=password;
		this.balance=amount;
				
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public float getBalance() {
		return balance;
	}
	
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String info() {
		
		return String.format("%s, %d, %f, ", name, accountNumber, balance);
	}
	
	
}
