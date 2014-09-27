// Tom Harren && Aaron Lemmon && Kristin Rachor
import java.util.Scanner;

public class Main {

	private static int[][] companyPrefs;
	private static int[][] programmerPrefs;

	public static void main(String[] args) {
		getInput();
		PairMaker pairMaker = new PairMaker(companyPrefs, programmerPrefs);
		int[][] pairings = pairMaker.makePairings(companyPrefs, programmerPrefs);
		displayOutput(pairings);
	}
	
	/**
	 * Gets all company's preferences for employees and all programmer's preferences
	 * for employers for the user. Stores the results in companyPrefs and programmerPrefs.
	 */
	private static void getInput() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the number of companies/programmers:");
		int n = scanner.nextInt();
		companyPrefs = new int[n][n];
		programmerPrefs = new int[n][n];
		
		// Gets each company's preferences
		for (int i = 0; i < n; i++) {
			System.out.println("Give the programmer preferences of Company " + i + 
					" (Give each number from 0 through " + (n-1) + " inclusive, putting a space between each number):");
			for (int j = 0; j < n; j++) {
				companyPrefs[i][j] = scanner.nextInt();
			}
			scanner.reset();
		}
		
		// Gets each programmer's preferences
		for (int i = 0; i < n; i++) {
			System.out.println("Give the company preferences of Programmer " + i + 
					" (Give each number from 0 through " + (n-1) + " inclusive, putting a space between each number):");
			for (int j = 0; j < n; j++) {
				programmerPrefs[i][j] = scanner.nextInt();
			}
			scanner.reset();
		}
		scanner.close();		
	}
	
	/**
	 * Takes an array of pairs representing programmer/company matches and prints
	 * all the matches to the console.
	 */
	private static void displayOutput(int[][] pairings) {
		for(int[] pair : pairings){
			System.out.println("Programmer " + pair[0] + " is hired by Company " + pair[1]);
		}
		
	}
}
