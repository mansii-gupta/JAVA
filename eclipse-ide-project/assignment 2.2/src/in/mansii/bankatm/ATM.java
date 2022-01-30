package in.mansii.bankatm;
import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Bank user=new Bank();
		while(true) {
			
				System.out.println("\n\nPlease insert your card ");
				System.out.println("Enter your 4-digit pin");
				
			int pin=sc.nextInt();
			if(user.validatePin(pin)) {
				
				System.out.println("\nEnter Choice\n\n");
				
				System.out.println("1. View Account\t\t2. Change ATM PIN\n3. Bank Statement\t4. Withdraw \n5. Deposit\t\t6. Cancel Transaction\n");
				
				int choice=sc.nextInt();
				
				switch(choice) {
				
					case 1: System.out.println(user.getDetails());							    
					        break;
						
					case 2: System.out.println("Enter current pin");
					        int temp=sc.nextInt();
					        
					        if(user.validatePin(temp)) {
					        	
					        	System.out.println("Enter new pin");
					        	int newPin1=sc.nextInt();
					        	System.out.println("Re-enter pin");
					        	int newPin2=sc.nextInt();
					        	System.out.println(user.generatePin(newPin1, newPin2));
					        }
					        else {
					        	System.out.println("Incorrect PIN ");
					        }
					        break;
					        
					case 3:	System.out.println(user.bankStatement());	
							break;
							
					case 4: System.out.print("Enter Amount: ");
							int amount=sc.nextInt();
							System.out.println(user.withdraw(amount));	
							break;
							
					case 5: System.out.print("Enter Amount: ");
							int amountt=sc.nextInt();
							System.out.println(user.deposit(amountt));	
							break;
							
					case 6: System.out.println("Cancelled");
							break;
					
					default: System.out.println("Invalid Entry");
							break;
		    	}
			}
            else{
                System.out.println("Incorrect Pin");
            }
		}
		
	}
}
