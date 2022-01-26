package in.mansii.tests;


import static org.junit.Assert.assertEquals;
//import static in.mansii.utils.testing.CustomAssert.assertContainsSubstring;


import org.junit.Before;
import org.junit.Test;

import in.mansii.CurrentAccount;

class CurrentAccountTest {
	
	String name="Mansi";
	int accountNumber=123;
	float balance=5000.0f;
	String password="p@ss1";
	float interest=12.25f;
	String type="Current Account";
	
	CurrentAccount account;
//	CurrentAccount account =new CurrentAccount(accountNumber, name, password, balance, interest, type);
	
	
	@Before
	public void arrange() {
		account=new CurrentAccount(accountNumber, name, password, balance, interest, type);
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
	
	
	public void bankShouldWithdraw() {
		
	}
	
	
	

}
