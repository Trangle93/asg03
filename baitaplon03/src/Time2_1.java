import java.util.Scanner;
	public class Time2_1
	{
	  private static final int Hour = 0;
	private static final int Minute = 0;
	// private int hour;   // 0 - 23
	  // private int minute; // 0 - 59
	   private int second; // 0 - 59
	   //public static void main(String[] ages){

	   // Time2 no-argument constructor: initializes each instance variable 
	   // to zero; ensures that Time2 objects start in a consistent state
	   public Time2_1()
	   {
	      this( 0, 0, 0 ); // invoke Time2 constructor with three arguments
	   } // end Time2 no-argument constructor

	   // Time2 constructor: hour supplied, minute and second defaulted to 0
	   public Time2_1( int h ) 
	   { 
	      this( h, 0, 0 ); // invoke Time2 constructor with three arguments
	   } // end Time2 one-argument constructor

	   // Time2 constructor: hour and minute supplied, second defaulted to 0
	   public Time2_1( int h, int m ) 
	   { 
	      this( h, m, 0 ); // invoke Time2 constructor with three arguments
	   } // end Time2 two-argument constructor 

	   // Time2 constructor: hour, minute and second supplied
	   public Time2_1( int h, int m, int s ) 
	   { 
	      setTime( h, m, s ); // invoke setTime to validate time
	   } // end Time2 three-argument constructor 

	   // Time2 constructor: another Time2 object supplied
	   public Time2_1( Time2 time )
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
	     int hour = ( ( h >= 0 && h < 24 ) ? h : 0 );
	     second=(hour*3600)  +  (getMinute()*60) + getSecond();
	   } // end method setHour

	   // validate and set minute 
	   public void setMinute( int m ) 
	   { 
	      int minute = ( ( m >= 0 && m < 60 ) ? m : 0 );
		second=( getHour() * 3600 ) + ( getMinute() * 60 ) + getSecond();
	   } // end method setMinute

	   // validate and set second 
	   public void setSecond( int s ) 
	   { 
	       int second = ( ( s >= 0 && s < 60 ) ? s : 0 );
	       second=getHour()*3600 + getMinute()*60 + getSecond();
	   } // end method setSecond

	   // Get Methods
	   // get hour value
	   public int getHour() 
	   { 
	      return (second/3600); 
	   } // end method getHour

	   // get minute value
	   public int getMinute() 
	   { 
	      return ((second%3600)/60); 
	   } // end method getMinute

	   // get second value
	   public int getSecond() 
	   { 
	      return ((second%3600)%60); 
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
	   } 
	} 
	

	

