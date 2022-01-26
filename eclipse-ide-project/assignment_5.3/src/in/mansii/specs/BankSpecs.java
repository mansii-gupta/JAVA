package in.mansii.specs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import in.mansii.banking.Bank;
import in.mansii.banking.BankAccount;
import in.mansii.banking.OverdraftAccount;
import in.mansii.banking.Response;

public class BankSpecs {

	final String bankName = "ICICI";
	final double rate = 12;
	final String correctPassword = "p@ss";
	final double initialBalance = 50000;
	int _accountNumber, acc1,acc2;
	int existingAccount1, existingAccount2;
	int initialTotalAccounts;
	Bank bank;
	

	@Before
	public void arrange() {
		// ARRANGE
		bank = new Bank(bankName, rate);
		existingAccount1 = bank.openAccount("Name1", correctPassword, initialBalance);
		existingAccount2 = bank.openAccount("Name", correctPassword, initialBalance);
		String name = "Mansi";
		_accountNumber = bank.openAccount(name, "password1", 50000.0);
		
		acc1=bank.openAccount("User1", "password1", 50000.0);
		acc2=bank.openAccount("User2", "password2", 50000.0);
		initialTotalAccounts = bank.getAccountCount();
	}

	@Test
	public void bankShouldHaveAName() {

		// ACT
		Bank bank = new Bank(bankName, 10);

		// ASSERT
		assertEquals(bankName, bank.getName());

	}

	@Test
	public void bankShouldHaveAInterestRAte() {

		// ACT
		Bank bank = new Bank("Some Name", rate);

		// ASSERT
		assertEquals(rate, bank.getRate(), 0);

	}

	@Test
	public void openAccountShouldTakeNamePasswordAndBalanceAndReturnAccountNumber() {

		// ACT
		int accountNumber1 = bank.openAccount("Mansi", "mypassword", 1000.0);

		// ASSERT
		assertTrue(accountNumber1 > 0);
	}

	@Test
	public void openAccountShouldReturnUniqueAccountNumber() {

		// ACT
		var accountNumber1 = bank.openAccount("User1", "mypassword1", 1000.0);
		var accountNumber2 = bank.openAccount("User2", "mypassword2", 2000.0);

		// ASSERT
		assertNotEquals(accountNumber1, accountNumber2);
	}

	@Test
	public void openAccountShouldIncreaseTotalAccountCountInTheBank() {

		// ACT
		var accountNumber1 = bank.openAccount("User1", "mypassword1", 1000.0);

		// ASSERT
		assertEquals(initialTotalAccounts + 1, bank.getAccountCount());
	}

	@Test
	public void closeAccountShouldFailFromInvalidAccountNumber() {

		// ACT
		var result = bank.closeAccount(initialTotalAccounts + 1, "any-password");

		assertEquals(-1, result, 0);

	}

	@Test
	public void closeAccountShouldFailFromInvalidAccountPassword() {
		// ACT
		var result = bank.closeAccount(existingAccount1, "wrong-password");

		assertEquals(-1, result, 0);

	}

	@Test
	public void closeAccountShouldCloseTheAccountWithRightCredentials() {
		// ACT
		var result = bank.closeAccount(existingAccount1, correctPassword);

		// ASSERT
		assertNotEquals(-1, result, 0);
	}

	
	@Test
	public void closeAccountShouldReturnBalanceOnSuccessfulClosure() {

		// ACT
		var result = bank.closeAccount(existingAccount1, correctPassword);
		// ASSERT
		assertEquals(initialBalance, result, 0.01);

	}

	@Test
	public void closeAccountShouldReduceTheAccountCountInTheBank() {
		// ACT
		var result = bank.closeAccount(existingAccount1, correctPassword);

		// ASSERT
		assertEquals(initialTotalAccounts - 1, bank.getAccountCount());
	}

	@Test
	public void closeShouldFailForAlreadyClosedAccount() {

		// ARRANGE
		bank.closeAccount(existingAccount1, correctPassword);
		// Now existingAccount1 is closed. It can't be closed again

		// ACT
		var result = bank.closeAccount(existingAccount1, correctPassword);

		// ASSERT
		assertEquals(-1, result, 0);

	}

	@Test
	public void weShouldNotBeAbleToGetClosedAccount() {
		// ARRANGE
		String name = "Mansi";
		var accountNumber = bank.openAccount(name, "password1", 50000.0);
		bank.closeAccount(accountNumber, "password1");

		// ACT
		var account = bank.getAccount(accountNumber, "password1");

		// ASSERT
		assertEquals(null, account);

	}

	@Test
	public void creditInterstShouldCreditInterstToAllAccounts() {
		// ARRANGE
		double interestRate=10;
		
		//ACT
		boolean result=bank.creditInterest(interestRate);
		
		//ASSERT
		assertEquals(true, result);
	}


	@Test
	public void getBalanceShouldReturnBalanceForCorrectAccountAndPassword() {
		
		//ACT
		double balance= bank.getBalanceWithCredentials(_accountNumber, "password1");
		
		//ASSERT
		assertEquals(balance, 50000.0, 0);
	}

	
	@Test
	public void getBalanceShouldFailForInvalidAccountNumber() {
		//ARRANGE
		int incorrectAccNo=123;
		
		//ACT
		double balance= bank.getBalanceWithCredentials(incorrectAccNo, "password1");
				
		//ASSERT
		assertNotEquals(balance, 50000.0);
	}

	@Test
	public void getBalanceShouldFailForInvalidPassword() {
				
		//ACT
		double balance= bank.getBalanceWithCredentials(_accountNumber, "password");
				
		//ASSERT
		assertNotEquals(balance, 50000.0);

	}

	@Test
	public void depositShouldFailForInvalidAccountNumber() {
		//ARRANGE
		int incorrectAccNo=123;
		float amount=2000;
				
		//ACT
		boolean result= bank.depositWithCredentials(incorrectAccNo, amount);
						
		//ASSERT
		assertFalse(result);
	}


	@Test
	public void depositShouldFailForInvalidAmount() {
		//ARRANGE
		float amount= -900;
		
		//ACT
		boolean result= bank.depositWithCredentials(_accountNumber, amount);
						
		//ASSERT
		assertFalse(result);

	}

	@Test
	public void depositShouldCreditBalanceOnSuccess() {
		//ARRANGE
		float amount= 2000;
		
		//ACT
		boolean result= bank.depositWithCredentials(_accountNumber, amount);
						
		//ASSERT
		assertTrue(result);

	}

	@Test
	public void withdrawShouldFailForInvalidAccountNumber() {
		//ARRANGE
		int incorrectAccNo=123;
		float amount=2000;
				
		//ACT
		boolean result= bank.withdrawWithCredentials(incorrectAccNo, "password1", amount);
						
		//ASSERT
		assertFalse(result);
	}

	@Test
	public void withdrawShouldFailForInvalidPassword() {
		//ARRANGE
		float amount=2000;
				
		//ACT
		boolean result= bank.withdrawWithCredentials(_accountNumber, "password", amount);
						
		//ASSERT
		assertFalse(result);

	}

	@Test
	public void withdrawShouldFailForInvalidAmount() {
		//ARRANGE
		float amount=-2000;
				
		//ACT
		boolean result= bank.withdrawWithCredentials(_accountNumber, "password1", amount);
						
		//ASSERT
		assertFalse(result);
	}

	
	@Test
	public void withdrawShouldFailForOverDraft() {
		//ARRANGE
		OverdraftAccount odAccount= new OverdraftAccount(123, "Mansi", "password1", 5000.0);
		double amount=50000;
		
		//ACT
		Response res=odAccount.withdraw(amount, "password1");
		
		//ASSERT
		assertNotEquals("SUCCESS", res.getCode().toString() );
	}

	
	@Test
	public void withdrawShouldReduceBalanceByAmountOnSuccess() {
		//ARRANGE
		double amount=10000;
		double expectedResult=40000;
		
		//ACT
		boolean temp= bank.withdrawWithCredentials(_accountNumber, "password1", amount);
		assertTrue(temp);
		double result = bank.getBalanceWithCredentials(_accountNumber, "password1");
		
		//ASSERT
		assertEquals(result, expectedResult, 0.01);
		
	}


	@Test
	public void transferShouldPassForValidSourceAccountNumber() {
		//ARRANGE
		 double amount=10000;
		 
		 //ACT
		 boolean result= bank.transfer(acc1,"password1",acc2,amount);
		 
		 //ASSERT
		 assertTrue(result);
	}
	
	
	@Test
	public void transferShouldFailForInvalidSourceAccountNumber() {
		//ARRANGE
		 int acc1=123;
		 double amount=10000;
		 
		 //ACT
		 boolean result= bank.transfer(acc1,"password1",acc2,amount);
		 
		 //ASSERT
		 assertFalse(result);
		
	}


	
	@Test
	public void transferShouldFailForInvalidPassword() {
		//ARRANGE
		 double amount=10000;
		 
		 //ACT
		 boolean result= bank.transfer(acc1,"password",acc2,amount);
		 
		 //ASSERT
		 assertFalse(result);
	}


	@Test
	public void transferShouldFailForInvalidAmount() {
		//ARRANGE
		 double amount=-10;
		 
		 //ACT
		 boolean result= bank.transfer(acc1,"password1",acc2,amount);
		 
		 //ASSERT
		 assertFalse(result);
	}

	@Test
	public void transferShouldFailForOverDraft() {
		//ARRANGE
		OverdraftAccount odAccount= new OverdraftAccount(123, "Mansi", "password1", 500.0);
		double amount=5000;
		
		//ACT
		 boolean result= odAccount.transfer(123,"password1",acc2,amount);
		 
		//ASSERT
		 assertFalse(result);

	}

	
	@Test
	public void transferShouldReduceBalanceInSourceAccountOnSuccess() {
		//ARRANGE
		 double amount=10000;
		 double expectedBalance=40000;
		 
		 //ACT
		 boolean result= bank.transfer(acc1,"password1",acc2,amount);
		 assertTrue(result);
		 BankAccount account1=bank.getAccount(acc1, "password1");
		 double actualBalance=account1.getBalance();	
		 
		 //ASSERT
		 assertEquals(expectedBalance, actualBalance, 0.01);
	}

	
	@Test
	public void transferShouldFailForInvalidTargetAccountNumber() {
		//ARRANGE
		 int acc2=123;
		 double amount=10000;
		 
		 //ACT
		 boolean result= bank.transfer(acc1,"password1",acc2,amount);
		 
		 //ASSERT
		 assertFalse(result);
	
	}

	@Test
	public void transferShouldAddBalanceInTargetOnSuccess() {
		//ARRANGE
		 double amount=10000;
		 double expectedBalance=60000;
		 
		 //ACT
		 boolean result= bank.transfer(acc1,"password1",acc2,amount);
		 assertTrue(result);
		 BankAccount account2=bank.getAccount(acc2, "password2");
		 double actualBalance=account2.getBalance();
		 
		 //ASSERT
		 assertEquals(expectedBalance, actualBalance, 0.01);

	}

}