import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;


public class BigIntegerTests {

	@Test
	public void testConstructor() {
		BigInteger bigInt = new BigInteger("1111");
		assertEquals(1111, bigInt.intValue());
	}
	
	@Test
	public void testBinaryConstructor() {
		BigInteger int1 = new BigInteger("1001", 2); // It's positive!!!
		assertEquals(9, int1.intValue());
		BigInteger int2 = new BigInteger("-1001", 2);
		assertEquals(-9, int2.intValue());
	}
	
	// check if it makes stuff negative
	@Test
	public void testIfMakesStuffNegative() {
		BigInteger int1 = new BigInteger("1111", 2);
		assertEquals(4, int1.bitCount());
		assertEquals(4, int1.bitLength());
		BigInteger int2 = new BigInteger("-1111", 2);
		assertEquals(3, int2.bitCount()); // this is confusing
		assertEquals(4, int2.bitLength()); // this is confusing
	}
	// check if can convert back to string

	// check if it keeps zeros
	@Test
	public void testIfItKeepsZeros() {
		BigInteger int1 = new BigInteger("0000", 2);
		assertNotEquals(4, int1.bitCount()); // Doesn't keep leading zeros
	}
}
