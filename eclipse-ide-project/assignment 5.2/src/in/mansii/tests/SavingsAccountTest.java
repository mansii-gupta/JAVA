package in.mansii.tests;

import in.mansii.SavingsAccount;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
	
	String name="Mansi";
	int accountNumber=123;
	float balance=5000.0f;
	String password="p@ss1";
	float interest=12.25f;
	String type="Savings Account";
	
	SavingsAccount account;
	
	@Before
	public void arrange() {
		account= new SavingsAccount(accountNumber, name, password, accountNumber, interest, type);
	}
	
	@Test
	public void accountHasBalance() {
//		CurrentAccount account =new CurrentAccount(accountNumber, name, password, balance, interest, type);
		
		assertEquals(balance, account.getBalance(),0);
	}
	
	@Test
	public void accountHasPropertyAccountType() {
//		CurrentAccount account =new CurrentAccount(accountNumber, name, password, balance, interest, type);
		
		assertEquals(type, account.getType());
	}

}
