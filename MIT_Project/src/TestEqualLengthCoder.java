// Aaron Lemmon

import static org.junit.Assert.*;

import org.junit.Test;


public class TestEqualLengthCoder {

	@Test
	public void testIsALetter() {
		assertTrue(EqualLengthCoder.isALetter('A'));
		assertTrue(EqualLengthCoder.isALetter('Z'));
		assertTrue(EqualLengthCoder.isALetter('z'));
		assertTrue(EqualLengthCoder.isALetter('z'));
		assertTrue(EqualLengthCoder.isALetter('M'));
		assertTrue(EqualLengthCoder.isALetter('u'));
		assertFalse(EqualLengthCoder.isALetter('@'));
		assertFalse(EqualLengthCoder.isALetter('['));
		assertFalse(EqualLengthCoder.isALetter('`'));
		assertFalse(EqualLengthCoder.isALetter('{'));
		assertFalse(EqualLengthCoder.isALetter('5'));
	}
	
	@Test
	public void testRemoveNonLetters1() {
		String originalPhrase = "If you can't explain it simply, you don't understand it well enough.";
		String editedPhrase = "Ifyoucantexplainitsimplyyoudontunderstanditwellenough";
		assertEquals(editedPhrase, EqualLengthCoder.removeNonLetters(originalPhrase));
	}
	
	@Test
	public void testRemoveNonLetters2() {
		String originalPhrase = "!@#$%^&*()_+";
		String editedPhrase = "";
		assertEquals(editedPhrase, EqualLengthCoder.removeNonLetters(originalPhrase));
	}
	
	@Test
	public void testLetterToNumber() {
		assertEquals(0, EqualLengthCoder.letterToNumber('a'));
		assertEquals(19, EqualLengthCoder.letterToNumber('t'));
		assertEquals(25, EqualLengthCoder.letterToNumber('z'));
	}
	
	@Test
	public void testNumberToBinaryString() {
		assertEquals("00000", EqualLengthCoder.numberToBinaryString(0));
		assertEquals("00001", EqualLengthCoder.numberToBinaryString(1));
		assertEquals("01001", EqualLengthCoder.numberToBinaryString(9));
		assertEquals("11111", EqualLengthCoder.numberToBinaryString(31));
	}
	
	@Test
	public void testEncode() {
		assertEquals("00000", EqualLengthCoder.encode("a"));
		assertEquals("00000", EqualLengthCoder.encode("A"));
		assertEquals("11001", EqualLengthCoder.encode("Z"));
		assertEquals("00001000000110100011", EqualLengthCoder.encode("$B*a'N!d"));
	}
	
	@Test
	public void testNumberToLetter() {
		assertEquals('a', EqualLengthCoder.numberToLetter(0));
		assertEquals('z', EqualLengthCoder.numberToLetter(25));
		assertEquals('t', EqualLengthCoder.numberToLetter(19));
	}
	
	@Test
	public void testDecode() {
		assertEquals("a", EqualLengthCoder.decode("00000"));
		assertEquals("b", EqualLengthCoder.decode("00001"));
		assertEquals("z", EqualLengthCoder.decode("11001"));
		assertEquals("band", EqualLengthCoder.decode("00001000000110100011"));
	}
}
