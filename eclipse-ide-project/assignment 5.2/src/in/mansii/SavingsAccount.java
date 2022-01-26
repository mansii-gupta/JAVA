package in.mansii;

public class SavingsAccount extends Bank {

	private float interest;
	private String type;

	public SavingsAccount(int accountNumber, String name, String password, float amount, float interest , String type) {
		
		super(accountNumber, name, password, amount);
		this.interest=interest;
		this.type=type;
	}
	
	public float getInterest() {
		return interest;
	}
	public void setInterest(float interest) {
		this.interest = interest;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type=type;
	}
	
	public String info() {
		
		String bankAccount= super.info();
		
		bankAccount="Account holder's details: "+bankAccount.replace("]", String.format(",%s]", type));
		
		return bankAccount;
		
		
	}
	
	
}
