package in.mansii;

public class OverdraftAccount extends Bank {

	private float interest;
	private String type="Overdraft Account";
	
	public OverdraftAccount(int accountNumber, String name, String password, float amount, float interest) {
		super(accountNumber, name, password, amount);
		this.interest=interest;
	}
	
	public float getInterest() {
		return interest;
	}
	public void setInterest(float interest) {
		this.interest = interest;
	}
	
	public String info() {
		
		String bankAccount= super.info();
		
		bankAccount="Account holder's details: "+bankAccount.replace("]", String.format(",%s]", type));
		
		return bankAccount;
		
		
	}

}
