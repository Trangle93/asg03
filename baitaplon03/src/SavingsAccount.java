
public class SavingsAccount
{
	private static double annualInterestRate;
	private double savingsBalance;
	
	public double getSavingsBalance()
	{
		return savingsBalance;
	}
	
	public void setSavingsBalance( double x )
	{
		savingsBalance = x;
	}
	
	public static double getAnnualInterestRate()
	{
		return annualInterestRate;
	}
	public void calculateMonthlyInterest()
	{
		double monthlyInterestRate;
		monthlyInterestRate = (annualInterestRate/100 * savingsBalance)/12;
		System.out.printf( "InterestRate of a month:$%.2f\n" , monthlyInterestRate );
		savingsBalance += monthlyInterestRate;
	}
	
	public static void modifyInterestRate( double x)
	{
		annualInterestRate = x;
	}

}
