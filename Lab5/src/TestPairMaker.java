// Tom Harren && Aaron Lemmon && Kristin Rachor
import static org.junit.Assert.*;
import org.junit.Test;

public class TestPairMaker {

	@Test
	public void testSmallProblem() {
		int[][] companyPrefs = {{0, 2, 1}, {2, 1, 0}, {0, 2, 1}};
		int[][] programmerPrefs = {{1, 2, 0}, {2, 1, 0}, {2, 0, 1}};
		// an array of programmer/company matches
		int[][] expectedPairings = {{0, 2}, {1, 1}, {2, 0}};
		
		PairMaker pairMaker = new PairMaker(companyPrefs, programmerPrefs);
		assertArrayEquals(expectedPairings, pairMaker.makePairings(companyPrefs, programmerPrefs));
	}

	@Test
	public void testBigProblem() {
		int[][] companyPrefs = {{1, 4, 0, 2, 3}, {0, 1, 2, 3, 4}, {4, 2, 1, 0, 3}, {0, 2, 1, 3, 4}, {1, 2, 4, 3, 0}};
		int[][] programmerPrefs = {{4, 0, 3, 1, 2}, {3, 4, 1, 0, 2}, {3, 1, 2, 4, 0}, {2, 1, 3, 0, 4}, {0, 3, 1, 2, 4}};
		// an array of programmer/company matches
		int[][] expectedPairings = {{0, 3}, {1, 4}, {2, 1}, {3, 2}, {4, 0}};
		
		PairMaker pairMaker = new PairMaker(companyPrefs, programmerPrefs);
		assertArrayEquals(expectedPairings, pairMaker.makePairings(companyPrefs, programmerPrefs));
	}
}
