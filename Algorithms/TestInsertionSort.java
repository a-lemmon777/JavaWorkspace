import static org.junit.Assert.*;

import org.junit.Test;


public class TestInsertionSort {

	@Test
	public void alreadySorted() {
		int[] myArray = new int[] {1, 2, 3};
		InsertionSort.sort(myArray);
		assertArrayEquals(new int[] {1, 2, 3}, myArray);
	}
	
	@Test
	public void testInvertSort() {
		int[] myArray = new int[] {3, 2, 1};
		InsertionSort.sort(myArray);
		assertArrayEquals(new int[] {1, 2, 3}, myArray);
	}

	@Test
	public void lotsOfElements() {
		int[] myArray = new int[] {3, 1, 5, 1, 9, 7, 7, 23, 0};
		InsertionSort.sort(myArray);
		assertArrayEquals(new int[] {0, 1, 1, 3, 5, 7, 7, 9, 23}, myArray);
	}
	
	@Test
	public void emptyArray() {
		int[] myArray = new int[] {};
		InsertionSort.sort(myArray);
		assertArrayEquals(new int[] {}, myArray);
	}
}
