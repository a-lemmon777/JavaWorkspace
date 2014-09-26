// Tom Harren && Aaron Lemmon && Kristin Rachor
public class Company {
	
	private final int ID;
	private final int[] preferences;
	private int nextOfferIndex = 0;
	private boolean isMatched;
	
	public Company(int ID, int[] preferences) {
		this.ID = ID;
		this.preferences = preferences;
	}

	public int getID() {
		return ID;
	}
	
	public int getNextProgrammer() {
		return preferences[nextOfferIndex];
	}
	
	public void incrementNextOfferIndex() {
		nextOfferIndex++;
	}
	
	public boolean isMatched() {
		return isMatched;
	}

	public void setMatched(boolean b) {
		this.isMatched = b;
	}
}
