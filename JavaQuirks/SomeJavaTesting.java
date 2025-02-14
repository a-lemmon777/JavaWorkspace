import static org.junit.Assert.*;

import org.junit.Test;


public class SomeJavaTesting {

	private int coolInt;
	private char defaultChar;
//	final int neverChanged2; // The declaration throws a compilation error early

	@Test
	public void test() {
		assertTrue(true);
	}

	@Test
	public void byteRollover() {
		byte myByte = 127;
		myByte++;
		assertEquals(-128, myByte);
	}
	
	@Test
	public void byteMultiplicationRollover() {
		byte myByte = 64;
		myByte *= 2;
		assertEquals(-128, myByte);
	}
	
	@Test
	public void shortRollover() {
		short myShort = -32768;
		myShort--;
		assertEquals(32767, myShort);
	}
	
	@Test
	public void intRollover() {
		int myInt = 2147483647;
		myInt++;
		assertEquals(-2147483648, myInt);
	}
	
	@Test
	public void longRollover() {
		long myLong = 9223372036854775807L;
		myLong++;
		assertEquals(-9223372036854775808L, myLong);
	}
	
	@Test (expected = Error.class)
	public void badLongLiteral() {
		long myLong = 9223372036854775807;
	}
	@Test
	public void upConvert() {
		byte myByte = 5;
		short myShort = myByte;
		int myInt = myShort;
		long myLong = myInt;
		assertEquals(5, myLong);
	}
	
	@Test (expected = Error.class)
	public void cantDownConvert() {
		int myInt = 5;
		short myShort = myInt;
	}
	
	@Test
	public void downCast() {
		int myInt = 5;
		short myShort = (short) myInt;
	}
	
	@Test
	public void downCastAndRollsOver() {
		int myInt = 128;
		byte myByte = (byte) myInt;
		assertEquals(-128, myByte);
	}
	
	@Test (expected = Error.class)
	public void cantDownCovertToByte() {
		byte myByte = 2349087;
	}
	
	@Test (expected = Error.class)
	public void stillCantDownConvertToByte() {
		byte myByte = 128;
	}
	
	@Test (expected = Error.class)
	public void doubleToInt() {
		double thing = -5.5;
		int intThing = thing; // Type mismatch compilation error
	}
	
	@Test
	public void absOfMostNegativeNumber() {
		assertEquals(Integer.MIN_VALUE, Math.abs(Integer.MIN_VALUE));
	}
	
	@Test
	public void defaultIntFieldValue() {
		assertEquals(0, coolInt);
	}
	
	@Test (expected = Error.class)
	public void noDefaultVariableValue() {
		int unCoolInt;
		assertEquals(0, unCoolInt); // Throws Unresolved compilation error
	}
	
	@Test
	public void defaultCharFieldValue() {
		assertEquals('\0', defaultChar);
		assertEquals('\u0000', defaultChar);
	}
	
	@Test
	public void uniCodeLiterals() {
		int \u00ED = 5;
		assertEquals(\u00ed, \u00ed);
	}
	
	@Test
	public void notAssigningAValueToFinal() {
		final int neverChanged; // no compilation error
	}
	
}
