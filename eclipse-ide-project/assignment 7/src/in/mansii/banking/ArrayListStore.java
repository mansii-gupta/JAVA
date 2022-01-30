package in.mansii.banking;

import java.util.ArrayList;
import in.mansii.banking.exceptions.InvalidAccountException;

public class ArrayListStore {

	private ArrayList <BankAccount> accounts=new ArrayList<BankAccount>();
	
	
	public void addAccount(int accountNumber,BankAccount account) {

		accounts.add(accountNumber, account);
	}
	
	
	public BankAccount getAccount(int accountNumber) {
		
		if(accountNumber<0 || accountNumber>=accounts.size() || accounts.get(accountNumber)==null)
			throw new InvalidAccountException(accountNumber);

		return accounts.get(accountNumber);		
	}
	
	
	public void removeAccount(int accountNumber) {
		
		if(accountNumber<0 || accountNumber>=accounts.size() || accounts.get(accountNumber)==null)
			throw new InvalidAccountException(accountNumber);

		accounts.remove(accountNumber);
	}
	
	
	public ArrayList<BankAccount> getAllActiveAccounts() {
		
		ArrayList <BankAccount> activeAccounts= new ArrayList<BankAccount>();
		for(int i=0; i<accounts.size();i++) {
			if(accounts.get(i)!=null)
				activeAccounts.add(accounts.get(i));
		}
		return activeAccounts;
	}
	
	
	public int getAccountCount() {
		return accounts.size();
	}
}
