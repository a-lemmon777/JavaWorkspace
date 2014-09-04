import java.util.Scanner;

public class Main {
	public static long counter = 0;
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a positive number for n: ");
		int n = scanner.nextInt();
		scanner.close();
		System.out.println("Your n value is: " + n);
// for testing
//		int n = 5;
		PermutationCalculator myCalc = new PermutationCalculator(n);
		long timeBefore = System.currentTimeMillis();
		myCalc.printAllPermutations();
		long timeAfter = System.currentTimeMillis();
		
		long total = timeAfter - timeBefore;
		if (total < 1000) {
			System.out.println("Time to compute: " + total + "ms");
		} else {
			System.out.println("Time to compute: " + (total/1000.0) + "s");
		}
		
		System.out.println("Expected number of permutations: " + factorial(n));
		System.out.println("Counted number of permutations:  " + counter);
	}
	
	public static long factorial(int number){
		if (number == 1) {
			return 1;
		} else {
			return (number * factorial(number - 1));
		}
	}
}
