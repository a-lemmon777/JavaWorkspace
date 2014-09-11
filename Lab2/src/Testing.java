// Dalton Gusaas && Aaron Lemmon
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class Testing {
	
	private TestInteger low;
	private TestInteger high;
	private TestInteger[] unsorted3 = new TestInteger[] {new TestInteger(3), new TestInteger(2), new TestInteger(1)};
	private TestInteger[] sorted3;
	
	@Before
	public void setup() {
		low = new TestInteger(new Integer(5));
		high = new TestInteger(new Integer(20));
		TestInteger.resetCounter();
		sorted3 = unsorted3.clone();
		Arrays.sort(sorted3);
	}
			
	

	@Test
	public void testCompareTo() {
		TestInteger.resetCounter();
		assertEquals(-1, low.compareTo(high));
		assertEquals(0, high.compareTo(high));
		assertEquals(1, high.compareTo(low));
		assertEquals(3, TestInteger.getCounter());
		TestInteger.resetCounter();
		assertEquals(0, TestInteger.getCounter());
		
	}
	
	@Test
	public void testQuickSort() {
		QuickSort.sort(unsorted3, 0, unsorted3.length - 1);
		assertArrayEquals(sorted3, unsorted3);
		assertArrayEquals(sorted3, sorted3);
		assertTrue(QuickSort.isSorted(unsorted3));
		
	}
	
	@Test
	public void testName() {
		System.out.println(Arrays.toString(sorted3));
		assertTrue(true);
	}
	
	@Test
	public void testRandomQuickSort() {
		RandomQuickSort.sort(unsorted3, 0, unsorted3.length - 1);
		assertArrayEquals(sorted3, unsorted3);
		assertArrayEquals(sorted3, sorted3);
		assertTrue(RandomQuickSort.isSorted(unsorted3));
	}

	
}
