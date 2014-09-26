
public class Company {
	
	private int[] preferences;
	private int currentMatch = -1;
	private int nextProposalIndex = 0;
	private int increment = 0;
	
	
	public Company(int[] preferences) {
		this.preferences = preferences;
	}


	public int getNextProposal() {
		return preferences[nextProposalIndex];
	}


	public int getCurrentMatch() {
		return currentMatch;
	}


	public void setCurrentMatch(int currentMatch) {
		this.currentMatch = currentMatch;
	}


	public void increment() {
		increment++;
	}


	public void updateNextProposalIndex() {
		nextProposalIndex += increment;
		increment = 0;
	}
	
	
}
