
public class Time2_2Test {
	public static void main(String[] args) {       
		Time2_2 t1 = new Time2_2( 2, 15, 59 );
		System.out.println( "t1: all arguments defaulted" );
		System.out.printf( "   %s\n", t1.toUniversalString() );
		System.out.printf( "   %s\n", t1.toString() );
		t1.tick();
		t1.CheckTime();
		System.out.printf( "new t1:", t1.toUniversalString() );
		System.out.printf( "   %s\n", t1.toString() );
		
		Time2_2 t2 = new Time2_2( 11, 59, 59 );
		System.out.println( "t2: all arguments defaulted" );
		System.out.printf( "   %s\n", t2.toUniversalString() );
		System.out.printf( "   %s\n", t2.toString() );
		t2.tick();
		t2.CheckTime();
		System.out.printf( "new t1:", t2.toUniversalString() );
		System.out.printf( "   %s\n", t2.toString() );
		
		Time2_2 t3 = new Time2_2( 13, 59, 30);
		System.out.println( "t3: all arguments defaulted" );
		System.out.printf( "   %s\n", t3.toUniversalString() );
		System.out.printf( "   %s\n", t3.toString() );
		t3.incrementMinute();
		t3.CheckTime();
		System.out.printf( "new t1:", t3.toUniversalString() );
		System.out.printf( "   %s\n", t3.toString() );
		
	}

}
