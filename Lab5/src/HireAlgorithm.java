// Tom Harren && Aaron Lemmon && Kristin Rachor
import java.util.Scanner;

public class HireAlgorithm {
	
	private int n;
	private Programmer[] allProgrammers;
	private Company[] allCompanies;
	
	public HireAlgorithm(int[][] companyPrefs, int[][] programmerPrefs) {
		n = companyPrefs.length;
		allCompanies = new Company[n];
		allProgrammers = new Programmer[n];
		
		for (int i = 0; i < n; i++) {
			allCompanies[i] = new Company(i, companyPrefs[i]);
		}
		
		for (int i = 0; i < n; i++) {
			int[] rearrangedProgrammerPrefs = new int[n];
			for (int j = 0; j < n; j++) {
				rearrangedProgrammerPrefs[programmerPrefs[i][j]] = j;
			}

			allProgrammers[i] = new Programmer(i, rearrangedProgrammerPrefs);
		}	
	}
	
	public int[][] makePairings(int[][] companyPrefs, int[][] programmerPrefs) {
		while (someoneNotMatched()){
			for (Programmer programmer : allProgrammers) {
				for (Company company : allCompanies) {
					if (!company.isMatched()){
						if (company.getNextProgrammer() == programmer.getID()) {
							programmer.considerNewCompany(company);
						}
					}
				}
			}
		}
		
		int[][] result = new int[n][];
		for (Programmer programmer : allProgrammers) {
			result[programmer.getID()] = new int[] {programmer.getID(), programmer.getEmployer().getID()};
		}
		return result;
	}

	private boolean someoneNotMatched() {
		for (Company company : allCompanies) {
			if (!company.isMatched()) {
				return true;
			}
		}
		return false;
	}
}
