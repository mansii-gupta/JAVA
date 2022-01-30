package in.mansii.bankatm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Scanner;

import org.junit.Test;

public class withdrawTest {

	Bank user=new Bank();
	Scanner sc=new Scanner(System.in);
	
	
	
	@Test
	public void test1() {
		System.out.println("Amount Withdrawn: ");
		int amount=sc.nextInt();
		String response=user.withdraw(amount);
		assertEquals("Enter Valid Amount",response);
	}
	
	@Test
	public void test2() {
		System.out.println("Amount Withdrawn: ");
		int amount=sc.nextInt();
		String response=user.withdraw(amount);
		assertEquals("Insufficient Bank Balance", response);
	}
	
	@Test
	public void test3() {
		System.out.println("Amount Withdrawn: ");
		int amount=sc.nextInt();
		String response=user.withdraw(amount);
		assertEquals("Money Withdrawn!", response);
	}

}
