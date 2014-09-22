import static org.junit.Assert.*;

import org.junit.Test;


public class WrapperTests {

	@Test
	public void testBYTES() {
		assertEquals(4, Integer.BYTES);
	}

	@Test
	public void testSIZE() {
		assertEquals(32, Integer.SIZE);
	}
	
	@Test
	public void testNameTYPE() {
		assertEquals(int.class, Integer.TYPE);
	}
	
	@Test (expected = Error.class)
	public void testStringConstructor() {
		assertEquals(5, new Integer("5"));
	}
	
	@Test
	public void testStringConstructorAgain() {
		assertEquals(new Integer(5), new Integer("5"));
	}
	
	@Test
	public void testStringConstructorYetAgain() {
		assertEquals(new Integer(20), new Integer("020")); //same as parseInt for radix 10
	}
	
	@Test
	public void testStringPooling() {
		String first = "hi";
		String second = "hi";
		assertTrue(first == second);
		String third = String.valueOf('h') + String.valueOf('i');
		assertFalse(first == third);
	}
	
//	@Test
//	public void testIntegerPooling() {
//		Integer first = 1;
//		Integer second = 1;
//		assertTrue(first == second);
//		Integer third = Integer.valueOf(1);
//		assertFalse(first == third);
//	}
}
