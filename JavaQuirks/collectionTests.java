import static org.junit.Assert.*;

import org.junit.Test;


public class collectionTests {

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
	public void test() {
		String[][] coolArray;
		coolArray = new String[5][]; // Yes!!!! I dont have to initialize subarrays!!!!
		assertArrayEquals(null, coolArray[0]);
	}
}