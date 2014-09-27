// Tom Harren && Aaron Lemmon && Kristin Rachor
public class Programmer {

	private final int ID;
	private final int[] preferences;
	private Company employer;

	public Programmer(int ID, int[] preferences) {
		this.ID = ID;
		this.preferences = preferences;
	}
	
	public int getID() {
		return ID;
	}

	/**
	 * Checks if the new company's offer is better than the current
	 * offer. If it is, this programmer will accept the new company's
	 * offer and reject it's old company.
	 */
	public void considerNewCompany(Company newCompany) {
		newCompany.incrementNextOfferIndex();
		if (employer == null) {
			newCompany.setMatched(true);
			employer = newCompany;
		} else if (preferences[newCompany.getID()] < preferences[employer.getID()]) {
			employer.setMatched(false);
			newCompany.setMatched(true);
			employer = newCompany;
		}
	}

	public Company getEmployer() {
		return employer;
	}
}
