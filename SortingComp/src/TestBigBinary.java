import static org.junit.Assert.*;

import org.junit.Test;

public class TestBigBinary {
	
	@Test
	public void testAllZeros() {
		String value = "00000";
		BigBinary bb = new BigBinary(value);
		int expectedSumOfOnes = 0;
		assertEquals(value, bb.toString());
		assertEquals(expectedSumOfOnes, bb.getSumOfOnes());
	}

	@Test
	public void testAllOnes() {
		String value = "111111";
		BigBinary bb = new BigBinary(value);
		int expectedSumOfOnes = 6;
		assertEquals(value, bb.toString());
		assertEquals(expectedSumOfOnes, bb.getSumOfOnes());
	}
	
	@Test
	public void testGetValAt() {
		BigBinary bb = new BigBinary("10010110");
		assertEquals(6, bb.getValBefore(8,4));
		assertEquals(9, bb.getValBefore(4,4));
		assertEquals(0, bb.getValBefore(12, 4));
	}
	
	@Test
	public void testName() {
		System.out.println(Integer.parseUnsignedInt("1100", 2));
		System.out.println(Integer.parseUnsignedInt("0011", 2));
		System.out.println(Integer.parseUnsignedInt("1110", 2));
		System.out.println("Hello".substring(0, 3));
		System.out.println("Hello".substring(2, 5));

	}
	
	@Test
	public void testName2() {
		System.out.println(Math.log(2));
	}
}
