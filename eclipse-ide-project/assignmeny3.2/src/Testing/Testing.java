package Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import in.mansii.banking.BankAccount;
import in.mansii.banking.Response;

class Testing {
	
	BankAccount user=new BankAccount(123, "Mansi", "qwerty", 1000.0f, 10.0f);
	Scanner sc= new Scanner(System.in);
	
	@Test
	public void withdrawalTest() {
		System.out.print("Amount to be withdrawn: ");
		int amount=sc.nextInt();
		Response response=user.withdraw(amount, "qwerty");
		if(amount<0) {
			assertEquals("INVALID_AMOUNT",response.getCode().toString());
		}
		else if(amount> 1000.0f) {
			assertEquals("INSUFFICIENT_FUNDS", response.getCode().toString());
			
		}
		else {
			assertEquals("SUCCESS", response.getCode().toString());
		}
	}
	
	@Test
	public void depositTest() {
		System.out.print("Amount to be deposited: ");
		int amount=sc.nextInt();
		Response response=user.deposit(amount);
		if(amount<0) {
			assertEquals("INVALID_AMOUNTt",response.getCode().toString());
		}
		else {
			assertEquals("SUCCESS", response.getCode().toString());
		}
	}

}
