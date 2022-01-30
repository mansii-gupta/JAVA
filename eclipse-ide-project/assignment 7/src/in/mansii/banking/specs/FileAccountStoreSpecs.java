package in.mansii.banking.specs;


import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import in.mansii.banking.BankAccount;
import in.mansii.banking.FileAccountStore;
import in.mansii.banking.SavingsAccount;

public class FileAccountStoreSpecs {
	
	FileAccountStore file;
	BankAccount account=null;
	
	final int accountNumber=1;
	final String name="Mansi";
	final String correctPassword="p@ss";
	final double initialBalance=50000;


	@Before
	public void setUp() throws Exception {
		file=new FileAccountStore();
		account=new SavingsAccount(accountNumber,name,correctPassword,initialBalance);
		
	}

	@Test
	public void createFileIsSuccessfull() {
		file.createFile();
		
	}

	@Test
	public void addAccountDetailsToFile() {
		file.createFile();
		file.addAccountDetails(account);
	}
	
	@Test
	public void showAllAccountsAddedToFile() throws IOException {
		file.showInfo();
	}
	
}
