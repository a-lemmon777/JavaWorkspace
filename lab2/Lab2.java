// Aaron Lemmon and Jack R

import java.util.Random;

public class Lab2 {
	public static void main(String[] args) {
		
		// testing for countChar
		System.out.println("Testing for countChar:");
		System.out.println(countChar("Just testing", 't') == 3);
		System.out.println(countChar("Four score and seven years ago", 'o') == 3);
		System.out.println(countChar("Check Case-Sensitivity", 'C') == 2);
		System.out.println(countChar("", 'a') == 0);
		
		// testing for hasEvenOccurrences
		System.out.println();
		System.out.println("Testing for hasEvenOccurrences:");
	        System.out.println(hasEvenOccurrences("Morris", 'r') == true);
	        System.out.println(hasEvenOccurrences("Morris", 'M') == false);
	        System.out.println(hasEvenOccurrences("", 'a') == true);
	        
	        // testing for printFactors
	        System.out.println();
	        System.out.println("Testing for printFactors:");
	        printFactors(12); // Should print 1 and 12, 2 and 6, 3 and 4
	        printFactors(1); // Should print ???
	        printFactors(2); // Should print 1 and 2
	        printFactors(13); // Should print 1 and 13
	        printFactors(-5); // Should print "Input must be a positive integer."
	        
	        // testing for randomProduct
	        System.out.println();
	        System.out.println("Testing for randomProduct:");
	        int output = randomProduct(5);
	        System.out.println((output >= 1) && (output <= 25));
	        output = randomProduct(3);
	        System.out.println((output >= 1) && (output <= 9));
	        for (int i = 0; i < 100; i++) {
	        	output = randomProduct(1); // Should always return 1, never 0.
	        	System.out.println((output >= 1) && (output <= 1)); // Should print true 100 times.
	        }
	}
	
	static int countChar(String string, char character) {
		int count = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == character) {
				count++;
			}
		
		}
		return count;
	}
	
	static boolean hasEvenOccurrences(String string, char character) {
		return ((countChar(string, character) % 2) == 0);
	}
	
	static void printFactors(int input) {
		if (input > 0) {
			System.out.println(input + " can be factored as:");
			int firstFactor = 1;
			int secondFactor = input + 1; // this makes printFactors(1) work
			while (firstFactor < secondFactor) {
				if ((input % firstFactor) == 0) {
					secondFactor = input / firstFactor;
					System.out.println(firstFactor + " and " + secondFactor);
				}
				firstFactor++;
			}
		} else {
			System.out.println("Input must be a positive integer.");	
		}
	}
	
	static int randomProduct(int input) {
		Random rand = new Random();
		int num1 = rand.nextInt(input) + 1;
		int num2 = rand.nextInt(input) + 1;
		return num1 * num2;
	}
	
}
