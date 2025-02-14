import java.util.Arrays;

public class OddsNEnds {
	
	private static int[] temp;
	
	public static void main(String[] args) {
		System.out.println("a\nb\nc\n");
		System.out.println("There should be an empty line here ^^");
		System.out.println("I'm a moose");
		System.out.println("You\'re a moose too"); // Dont need to escape single quotes in a string
		char myQuote = '\'';
		System.out.println(0x00);
		System.out.println(0xFF);
		// Octal literals
		System.out.println(000);
		System.out.println(077);
		System.out.println(00.77); // Octal literals dont work for floating point numbers
		System.out.println(0b1000);
//		System.out.println(0b1002); // Unuseful error message.
		//System.out.println(088); // Doesn't work, expecting digits to be 0 to 7
		final int MY_AGE = 23;
//		MY_AGE++; // Can't change a final variable.
//		System.out.println(MY_AGE);
		double thing1 = -5.5;
		// cast truncates toward 0
		int thing2 = (int) thing1;
		System.out.println(thing2);
		final int DAYS_PER_WEEK = 7;
		double[] maxTemps = new double[DAYS_PER_WEEK];
		int thing3 = 2;
//		int thing4 = ++thing3++; // The postfix happens first, which returns a value. The prefix ++ is expecting a variable not a value, so it gets messed up.
//		System.out.println(thing4);
		String[] stuNames;
		stuNames = new String[10];
		stuNames[0] = "Andrew";
		System.out.println(stuNames);
		System.out.println(stuNames.toString());
		System.out.println(stuNames[0]);
		final int WEEKS_PER_YEAR = 52;
		double[][] minTemps = new double[DAYS_PER_WEEK][WEEKS_PER_YEAR];
		String thing5 = "hi " + 4;
		System.out.println(thing5);
		String thing6 = 1.000000001 + 2 + " hi";
		System.out.println(thing6);
		int[] freq = new int[4];
		freq[0] = 10;
		freq[1] = 11;
		freq[2] = 12;
		freq[3] = 13;
		System.out.println("here we go");
		System.out.println(freq[0]);
		System.out.println(freq['\0']);
		
		System.out.println('\61');
		System.out.println('\141');
		System.out.println('\377');
		System.out.println('\377');
		temp = new int[8];
		doStuff(); // returns a value and does nothing
		doArrayStuff(); // assigns to temp[0], it knows temp was initialized earlier.
		int length2 = new double[4].length;
//		int number = doMoreArrayStuff({3, 4, 5}); // bracket notation is only for initialization
		char[] someChars;
//		someChars = {'a', 'b','c'}; // can only be used in initializers
		int[] coolInts = {freq[2], 5};
		int[] unCoolInts = {5, freq[2]};
		int[] someInts = {5, freq[2]}; // values can be provided at runtime, it appears
		System.out.println(coolInts.equals(unCoolInts));
		System.out.println(someInts.equals(unCoolInts)); // Different objects, same values, returns false
		System.out.println(Arrays.equals(someInts, unCoolInts)); // Different objects, same values, returns true
	}

	private static int doMoreArrayStuff(int[] is) {
		return 0;
	}

	private static void doArrayStuff() {
			temp[0] = 8;
	}

	private static int doStuff() {
		return 5;
	}
}