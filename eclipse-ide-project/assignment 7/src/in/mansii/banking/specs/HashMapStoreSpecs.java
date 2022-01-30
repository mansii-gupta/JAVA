package in.mansii.banking.specs;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import in.mansii.banking.HashMapStore;
import in.mansii.banking.OverdraftAccount;
import in.mansii.banking.SavingsAccount;
import in.mansii.banking.exceptions.InvalidAccountException;
import in.mansii.banking.BankAccount;
import in.mansii.banking.CurrentAccount;

public class HashMapStoreSpecs {

	BankAccount account=null;
	HashMapStore accountList;
	
	final int accountNumber=3;
	final String name="Mansi";
	final String correctPassword="p@ss";
	final double initialBalance=50000;


	
	@Before
	public void arrange() throws Exception{
		
		accountList=new HashMapStore();
		
		account=new SavingsAccount(0,name,correctPassword,initialBalance);
		accountList.addAccount(0, account);
		account=new CurrentAccount(1,name,correctPassword,initialBalance);
		accountList.addAccount(1, account);
		account=new OverdraftAccount(2,name,correctPassword,initialBalance);
		accountList.addAccount(2, account);
	}
	
	@Test
	public void addsAccountToArrayList() {
		accountList.addAccount(accountNumber, account);
	}
	
	
	@Test
	public void returnsAccountWithAccountNumber() {
		accountList.getAccount(1);
	}

	
	@Test(expected = InvalidAccountException.class)	
	public void failsToReturnAccountWithIncorrectAccountNumber() {
		accountList.getAccount(10);
	}
	
	
	@Test
	public void removesAccountFromArrayList() {
		accountList.addAccount(accountNumber, account);
		accountList.removeAccount(accountNumber);
	}
	
	
	
	@Test(expected = InvalidAccountException.class)
	public void failsToRemoveAccountIfAccountIsAlreadyRemoved() {
		accountList.addAccount(accountNumber, account);
		accountList.removeAccount(accountNumber);
		accountList.removeAccount(accountNumber);
	}
	
	
	@Test(expected = InvalidAccountException.class)
	public void FailsToRemoveAccountIfInvalidAccountNumberIsGiven() {
		accountList.removeAccount(accountNumber);
	}

	
	@Test
	public void getAllActiveAccountList() {
		accountList.getAllActiveAccounts();
	}

	
	@Test
	public void getNumberOfActiveAccounts() {
		accountList.getAccountCount();
	}




	
}
