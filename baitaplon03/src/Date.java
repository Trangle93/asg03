// Fig. 8.7: Date.java 
// Date class declaration.

//import java.util.Scanner;

public class Date{
   private int month; // 1-12
   private int day;   // 1-31 based on month
   private int year;  // any year

   // constructor: call checkMonth to confirm proper value for month; 
   // call checkDay to confirm proper value for day
   
   public Date(){
	this(0, 0, 0);
   }
   
   public Date( int theMonth, int theDay, int theYear )
   {
      month = checkMonth( theMonth ); // validate month
      year = theYear; // could validate year
      day = checkDay( theDay ); // validate day

      System.out.printf( 
         "Date object constructor for date %s\n", this );
   } // end Date constructor
   
   private int checkYear(int testYear){
		if(testYear >= 0)
			return testYear;
		else{
			System.out.printf("invalid year (%d) set to 0.", testYear);
			return 0;
		}
   }

   // utility method to confirm proper month value
   private int checkMonth( int testMonth )
   {
      if ( testMonth > 0 && testMonth <= 12 ) // validate month
         return testMonth;
      else // month is invalid 
      { 
         System.out.printf( 
            "Invalid month (%d) set to 1.", testMonth );
         return 1; // maintain object in consistent state
      } // end else
   } // end method checkMonth

   // utility method to confirm proper day value based on month and year
   private int checkDay( int testDay )
   {
      int daysPerMonth[] = 
         { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
   
      // check if day in range for month
      if ( testDay > 0 && testDay <= daysPerMonth[ month ] )
         return testDay;
   
      // check for leap year
      if ( month == 2 && testDay == 29 && ( year % 400 == 0 || 
           ( year % 4 == 0 && year % 100 != 0 ) ) )
         return testDay;
   
      System.out.printf( "Invalid day (%d) set to 1.", testDay );
      return 1;  // maintain object in consistent state
   } // end method checkDay
   
   public void nextDay(){
		day = day + 1;
		if(month == 2 && day > 29 && ( year % 400 == 0 || 
           ( year % 4 == 0 && year % 100 != 0 ) ) ){
			day = day - 29;
			month = month + 1;
		}
		if(month == 2 && day > 28){
			day = day - 28;
			month = month + 1;
		}
		else if(day >= 31 && (month == 1|| month == 3|| month == 5|| month == 7|| month == 8||
				month == 10 || month == 12)){
			day = day - 31;
			month = month + 1;
		}
		else if(day >= 30 && (month == 2|| month == 4|| month == 6|| month == 9|| month == 11)){
			day = day - 30;
			month = month + 1;
		}
		if(month > 12){
				month = 1;
				year = year + 1;
			}
   }
   
   // return a String of the form month/day/year
   public String toString()
   { 
      return String.format( "%d/%d/%d", month, day, year ); 
   } // end method toString
	
} // end class Date
