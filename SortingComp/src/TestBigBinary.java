import static org.junit.Assert.*;

import org.junit.Test;


public class TestBigBinary {
	

	@Test
	public void testAllZeros() {
		BigBinary bb = new BigBinary("00000");
		int[] expectedValue = {0};
		int expectedSumOfOnes = 0;
		assertArrayEquals(expectedValue, bb.getValue());
		assertEquals(expectedSumOfOnes, bb.getSumOfOnes());
	}

	@Test
	public void testAllOnes() {
		BigBinary bb = new BigBinary("11111111111111");
		int[] expectedValue = {16383};
		int expectedSumOfOnes = 14;
		assertArrayEquals(expectedValue, bb.getValue());
		assertEquals(expectedSumOfOnes, bb.getSumOfOnes());
	}
	
	@Test
	public void testBigString() {
		BigBinary bb = new BigBinary("1001011010110011000111001011010011010011");
		int[] expectedValue = {Integer.parseInt("10010110", 2), Integer.parseInt("1011001100011100101101001101001", 2)};
		int expectedSumOfOnes = 14;
		assertArrayEquals(expectedValue, bb.getValue());
		assertEquals(expectedSumOfOnes, bb.getSumOfOnes());
	}
}
