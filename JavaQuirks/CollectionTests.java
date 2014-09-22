import static org.junit.Assert.*;

import org.junit.Test;


public class CollectionTests {

	@Test
	public void arrayDeclaration() {
		int[] niceInts = new int[3];
		niceInts[0] = 5;
		assertEquals(5, niceInts[0]);
	}
	
	@Test
	public void otherArrayDeclaration() {
		int[] niceInts = {1, 2, 3};
		assertEquals(1, niceInts[0]);
	}
	
	@Test (expected = Error.class)
	public void reallyQuickInitializationWontWork() {
		int[] niceInts;
		niceInts = {1, 2, 3};
	}
	
	@Test
	public void kindaQuickInitializationWorks() {
		int[] niceInts;
		niceInts = new int[] {1, 2, 3};
		assertEquals(1, niceInts[0]);
	}
	
	@Test
	public void testOrdering() {
		String[][] coolArray;
		coolArray = new String[5][3];
		assertEquals(5, coolArray.length);
		assertEquals(3, coolArray[0].length);
	}

	@Test (expected = Error.class)
	public void testChangeSubarrayType() {
		String[][] coolArray;
		coolArray = new String[5][3];
		coolArray[0] = new int[3]; // says cant convert to String[]
	}
	
	@Test
	public void testMultiDimArrays() {
		String[][] coolArray;
		coolArray = new String[5][]; // Yes!!!! I dont have to initialize subarrays!!!!
		assertArrayEquals(null, coolArray[0]);
	}
	
	@Test
	public void arraysCanBeStoredAsObjects() {
		Object thing = new int[5];
		System.out.println(((int[]) thing)[0]);
	}
	
	@Test
	public void anArrayOfObjectsCanHoldOtherArrays() {
		Object[] thing = new Object[5];
		thing[0] = new int[3];
		thing[1] = new double[3];
	}
	
	@Test (expected = Error.class)
	public void anArrayOfObjectsNeedCastingToWorkWith() {
		Object[] thing = new Object[5];
		thing[0] = new int[3];
		thing[1] = new double[3];
		thing[0][0] = 5;
	}
	
	@Test
	public void anArrayOfObjectsNeedCastingToWorkWithHeresACast() {
		Object[] thing = new Object[5];
		thing[0] = new int[3];
		thing[1] = new double[3];
		((int[])thing[0])[0] = 5;
	}
}