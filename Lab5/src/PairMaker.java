// Tom Harren && Aaron Lemmon && Kristin Rachor
public class PairMaker {
	
	private int n;
	private Programmer[] allProgrammers;
	private Company[] allCompanies;
	
	/**
	 * Creates a new PairMaker and initializes all its fields.
	 */
	public PairMaker(int[][] companyPrefs, int[][] programmerPrefs) {
		n = companyPrefs.length;
		allCompanies = new Company[n];
		allProgrammers = new Programmer[n];
		
		for (int i = 0; i < n; i++) {
			allCompanies[i] = new Company(i, companyPrefs[i]);
		}
		
		for (int i = 0; i < n; i++) {
			// The programmer's preferences are stored differently than a company's preferences.
			// Rather than having the favorite companies near the front of the list, each company
			// is represented by the index of the array and the value stored there represents that
			// company's ranking. Smaller ranks are more preferred, with 0 being the most preferred
			// rank.
			int[] rearrangedProgrammerPrefs = new int[n];
			for (int j = 0; j < n; j++) {
				rearrangedProgrammerPrefs[programmerPrefs[i][j]] = j;
			}
			allProgrammers[i] = new Programmer(i, rearrangedProgrammerPrefs);
		}	
	}
	
	/**
	 * Pairs each programmer with a company. Returns an array of programmer/company pairs.
	 */
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
		// Constructs the output of an array of programmer/company pairs
		int[][] result = new int[n][];
		for (Programmer programmer : allProgrammers) {
			result[programmer.getID()] = new int[] {programmer.getID(), programmer.getEmployer().getID()};
		}
		return result;
	}

	/**
	 * Checks if there are any companies that don't have a match yet.
	 */
	private boolean someoneNotMatched() {
		for (Company company : allCompanies) {
			if (!company.isMatched()) {
				return true;
			}
		}
		return false;
	}
}
