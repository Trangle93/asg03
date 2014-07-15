public class Time2_3
{
   private int hour;   // 0 - 23
   private int minute; // 0 - 59
   private int second; // 0 - 59

   // Time2_imp no-argument constructor: initializes each instance variable 
   // to zero; ensures that Time2_imp objects start in a consistent state
   public Time2_3()
   {
      this( 0, 0, 0 ); // invoke Time2_imp constructor with three arguments
   } // end Time2_imp no-argument constructor

   // Time2_imp constructor: hour supplied, minute and second defaulted to 0
   public Time2_3( int h ) 
   { 	  
      this( h, 0, 0 ); // invoke Time2_imp constructor with three arguments
   } // end Time2_imp one-argument constructor

   // Time2_imp constructor: hour and minute supplied, second defaulted to 0
   public Time2_3( int h, int m ) 
   { 
      this( h, m, 0 ); // invoke Time2_imp constructor with three arguments
   } // end Time2_imp two-argument constructor 

   // Time2_imp constructor: hour, minute and second supplied
   public Time2_3( int h, int m, int s ) 
   { 
      setTime( h, m, s ); // invoke setTime to validate time
   } // end Time2_imp three-argument constructor 

   // Time2_imp constructor: another Time2_imp object supplied
   public Time2_3( Time2_3 time )
   {
      // invoke Time2_imp three-argument constructor
      this( time.getHour(), time.getMinute(), time.getSecond() );
   } // end Time2_imp constructor with a Time2_imp object argument

   // Set Methods
   // set a new time value using universal time; ensure that 
   // the data remains consistent by setting invalid values to zero
   public boolean setTime( int h, int m, int s )
   {
      
	  if (setHour( h ) == true && setMinute( m ) == true && setSecond( s )==true) return true; 
	  else {
		System.out.printf("Something wrong at input - the variable wrong will be set to 0\n");
		return false;
		}
   } 

   // validate and set hour 
   public boolean setHour( int h ) 
   { 
    if ( h >= 0 && h < 24 ) {
		hour = h;
		return true;
		}
	else {
		System.err.printf("Valid hour");
		return false;
	} // end method setHour
	}

   // validate and set minute 
   public boolean setMinute( int m ) 
   { 
    if ( m >= 0 && m < 60 ) {
		minute =m;
		return true;
	} else {
		System.err.printf("Valid minute");
		return false;
		}
   } // end method setMinute

   // validate and set second 
   public boolean setSecond( int s ) 
   { 
     if ( s >= 0 && s < 60 ) {
		second  = s;
		return true;
	} else {
		System.err.printf("Valid second");
		return false;
		}
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
   
   ///////////////////// TEST!

} // end class Time2_imp
