
public class SavingsAccountTest {

	public static void main(String[] args) 
	{
		SavingsAccount saver1 = new SavingsAccount();
		SavingsAccount saver2 = new SavingsAccount();
		SavingsAccount.modifyInterestRate(4);
		saver1.setSavingsBalance(2000.00);
		saver2.setSavingsBalance(3000.00);
		
		System.out.printf( "SavingsBalance of saver1 :$%.2f\n" , saver1.getSavingsBalance() );
		System.out.printf( "SavingsBalance of saver2 :$%.2f\n" , saver2.getSavingsBalance() );
		System.out.print( "annualInterestRate is " +  SavingsAccount.getAnnualInterestRate() + "%\n");
		
		System.out.print( "\nSaver1:\n" );
		saver1.calculateMonthlyInterest();
		System.out.printf( "New SavingsBalance of saver1 :$%.2f\n" , saver1.getSavingsBalance() );
		
		System.out.print( "\nSaver2:\n" );
		saver2.calculateMonthlyInterest();
		System.out.printf( "New SavingsBalance of saver2 :$%.2f\n" , saver2.getSavingsBalance() );
		
		SavingsAccount.modifyInterestRate(5);
		System.out.print( "\nnew annualInterestRate is " +  SavingsAccount.getAnnualInterestRate() + "%\n");
		
	
		System.out.print( "\nSaver1:\n" );
		saver1.calculateMonthlyInterest();
		System.out.printf( "New SavingsBalance of saver1 :$%.2f\n" , saver1.getSavingsBalance() );
		
		System.out.print( "\nSaver2:\n" );
		saver2.calculateMonthlyInterest();
		System.out.printf( "New SavingsBalance of saver2 :$%.2f\n" , saver2.getSavingsBalance() );
		
	}

}
