import java.util.Scanner;

public class HireAlgorithm {
	
	private static Programmer[] allProgrammers;
	private static Company[] allCompanies;
	private static int n;
	
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of companies/programmers (or enter 0 for prestored data):");
		n = scanner.nextInt();
		if (n == 0) {
			usePrestoredData();
		} else {
			useUserInput();
		}
		scanner.close();
		
		while (someoneNotMatched()){
			for (int programmer = 0; programmer < n; programmer++) {
				for (int company = 0; company < n; company++) {
					if (allCompanies[company].getCurrentMatch() == -1){
						if (allCompanies[company].getNextProposal() == programmer) {
							allProgrammers[programmer].acceptBest(company);
//							if (best == -1) {
//								best = company;
//							} else {
//								best = allProgrammers[programmer].getBest(best, company);
//							}
//							allCompanies[company].increment();
						}
					}
				}
//				if(best != -1){
//					if () {
//						
//					}
//					allCompanies[best].setCurrentMatch(programmer);
//				}
			}
			for (Company company : allCompanies) {
				company.updateNextProposalIndex();
			}
		}
		
		
		for(int i = 0; i < n; i++){
			System.out.println("Company: " + i + " is matched with programmer: " + allCompanies[i].getCurrentMatch() );
		}
	
	}

	private static boolean someoneNotMatched() {
		for (Company company : allCompanies) {
			if (company.getCurrentMatch() == -1) {
				return true;
			}
		}
		return false;
	}

	private static void useUserInput() {
		Scanner scanner = new Scanner(System.in);
		
		allCompanies = new Company[n];
		allProgrammers = new Programmer[n];
		
		for (int i = 0; i < n; i++) {
			System.out.println("Give the programmer preferences of Company " + i + 
					" (Give each number from 0 through " + (n-1) + " inclusive, putting a space between each number):");
			int[] preferences = new int[n];
			for (int j = 0; j < n; j++) {
				preferences[j] = scanner.nextInt();
			}
			allCompanies[i] = new Company(preferences);
			scanner.reset();
		}
		for (int i = 0; i < n; i++) {
			System.out.println("Give the company preferences of Programmer " + i + 
					" (Give each number from 0 through " + (n-1) + " inclusive, putting a space between each number):");
			int[] preferences = new int[n];
			for (int j = 0; j < n; j++) {
				// 0 is placed at the index of the first number given, 0 meaning most preferred.
				preferences[scanner.nextInt()] = j;
			}
			allProgrammers[i] = new Programmer(preferences);
			scanner.reset();
		}
		scanner.close();
	}

	private static void usePrestoredData() {
		n = 3;
		allCompanies = new Company[n];
		allProgrammers = new Programmer[n];
		int[][] companyPrefs = {{0, 2, 1}, {2, 1, 0}, {0, 2, 1}};
		// {{1, 2, 0}, {2, 1, 0}, {2, 0, 1}} original input
		// Each array gets reordered, the index that contains 0 is the most preferred.
		int[][] programmerPrefs = {{2, 0, 1}, {2, 1, 0}, {1, 2, 0}};
		for (int i = 0; i < n; i++) {
			allCompanies[i] = new Company(companyPrefs[i]);
		}
		for (int i = 0; i < n; i++) {
			allProgrammers[i] = new Programmer(programmerPrefs[i]);
		}
	}

}
