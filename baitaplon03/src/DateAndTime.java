import java.util.Scanner;

public class DateAndTime{
	private static Time3 t;
	private static Date d;
	
	public DateAndTime(){
		d = new Date();
		t = new Time3();
	}
	
	public DateAndTime(Date newd, Time3 newt){
		d = newd;
		t = newt;
	}
	
	public void setDateAndTime(Date date, Time3 time){
		d = date;
		t = time;
	}
	
	public String toStandardString(){
		return (d.toString() + " " + t.toString());
	}
	
	public String toUniversalString(){
		return (d.toString() + " " + t.toUniversalString());
	}
	
	public static void main(String[] args){
		Time3 t1 = new Time3(23, 59, 59);
		Date d1 = new Date(12, 31, 1993);
		DateAndTime dt = new DateAndTime(d1, t1);
		t1.tick();
		dt.setDateAndTime(d1, t1);
		System.out.println("\n" + dt.toStandardString());
		System.out.println("\n" + dt.toUniversalString());
	}

static class Time3
{
   private int hour;   // 0 - 23
   private int minute; // 0 - 59
   private int second; // 0 - 59

   // Time2 no-argument constructor: initializes each instance variable 
   // to zero; ensures that Time2 objects start in a consistent state
   public Time3()
   {
      this( 0, 0, 0 ); // invoke Time2 constructor with three arguments
   } // end Time2 no-argument constructor

   // Time2 constructor: hour supplied, minute and second defaulted to 0
   public Time3( int h ) 
   { 
      this( h, 0, 0 ); // invoke Time2 constructor with three arguments
   } // end Time2 one-argument constructor

   // Time2 constructor: hour and minute supplied, second defaulted to 0
   public Time3( int h, int m ) 
   { 
      this( h, m, 0 ); // invoke Time2 constructor with three arguments
   } // end Time2 two-argument constructor 

   // Time2 constructor: hour, minute and second supplied
   public Time3( int h, int m, int s ) 
   { 
      setTime( h, m, s ); // invoke setTime to validate time
   } // end Time2 three-argument constructor 

   // Time2 constructor: another Time2 object supplied
   public Time3( Time3 time )
   {
      // invoke Time2 three-argument constructor
      this( time.getHour(), time.getMinute(), time.getSecond() );
   } // end Time2 constructor with a Time2 object argument

   // Set Methods
   // set a new time value using universal time; ensure that 
   // the data remains consistent by setting invalid values to zero
   public void setTime( int h, int m, int s )
   {
     setHour( h );   // set the hour
     setMinute( m ); // set the minute
     setSecond( s ); // set the second
   } // end method setTime

   // validate and set hour 
   public void setHour( int h ) 
   { 
      hour = ( ( h >= 0 && h < 24 ) ? h : 0 ); 
   } // end method setHour

   // validate and set minute 
   public void setMinute( int m ) 
   { 
      minute = ( ( m >= 0 && m < 60 ) ? m : 0 ); 
   } // end method setMinute

   // validate and set second 
   public void setSecond( int s ) 
   { 
      second = ( ( s >= 0 && s < 60 ) ? s : 0 ); 
   } // end method setSecond

   // Get Methods
   // get hour value
   public int getHour() 
   { 
      return hour; 
   } // end method getHour

   // get minute value
   public int getMinute() 
   { 
      return minute; 
   } // end method getMinute

   // get second value
   public int getSecond() 
   { 
      return second; 
   } // end method getSecond

   // convert to String in universal-time format (HH:MM:SS)
   public String toUniversalString()
   {
      return String.format( 
         "%02d:%02d:%02d", getHour(), getMinute(), getSecond() );
   } // end method toUniversalString

	// convert to String in standard-time format (H:MM:SS AM or PM)
	public String toString()
	{
		return String.format( "%d:%02d:%02d %s", 
			( (getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12 ),
			getMinute(), getSecond(), ( getHour() < 12 ? "AM" : "PM" ) );
	} // end method toString
	
	public void tick(){
		second = getSecond() + 1;
		if(second >= 60){
			minute = getMinute() + 1;
			second = getSecond() - 60;
			if(minute >= 60){
				incrementHour();
				minute = getMinute() - 60;
			}
		}
	}
	
	public void  incrementMinute(){
		minute = getMinute() + 1;
		if(minute >= 60){
			incrementHour();
			minute = getMinute() - 60;
		}
	}
	
	public void incrementHour(){
		hour = getHour() + 1;
		if(hour >= 24)
			d.nextDay();
	}
}
static class  Date{
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
      year = checkYear(theYear); // validate year
      day = checkDay( theDay ); // validate day

   } // end Date constructor
   
   public void setDate(int d, int m, int y){
		day = d;
		month = m;
		year = y;
   }
   
   public int getDay(){
	return day;
   }
   
   public int getMonth(){
		return month;
   }
   
   public int getYear(){
		return year;
   }
   
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
	
} // end class Time2
}
