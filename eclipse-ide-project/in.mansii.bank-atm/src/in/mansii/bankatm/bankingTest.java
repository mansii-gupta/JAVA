package in.mansii.bankatm;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class bankingTest {
	
	Bank user=new Bank();
	Scanner sc=new Scanner(System.in);
	@Test
	public void withdrawalTest() {
		System.out.print("Amount Withdrawn: ");
		int amount=sc.nextInt();
		String response=user.withdraw(amount);
		if(amount<0) {
			assertEquals("Enter Valid Amount",response);
		}
		else if(amount> user.getBalance()) {
			assertEquals("Insufficient Bank Balance", response);
			
		}
		else {
			assertEquals("Money Withdrawn!", response);
		}
	}
	
	@Test
	public void depositTest() {
		System.out.print("Amount Deposited: ");
		int amount=sc.nextInt();
		String response=user.deposit(amount);
		if(amount<0) {
			assertEquals("Enter Valid Amount",response);
		}
		else {
			assertEquals("Money Deposited!", response);
		}
	}
}
