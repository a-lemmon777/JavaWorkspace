
public class Programmer {

	public Programmer(int[] preferences) {
		this.preferences = preferences;
	}

	private int[] preferences;
	private int currentMatch = -1;

	public int getBest(int best, int nextProposal) {
		return (preferences[best] < preferences[nextProposal] ? best : nextProposal);
	}

	public void acceptBest(int company) {
		// increment new guy
		
		// if no current, set new to current
		// else compare them,
		//   reject loser (set to single)
		//   and set winner's current match to her
		//   and set her currentMatch to winner
	}
}
