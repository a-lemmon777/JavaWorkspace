import static org.junit.Assert.*;

import org.junit.Test;


public class TestMergeSort {

	@Test
	public void alreadySorted() {
		int[] myArray = new int[] {1, 2, 3};
		MergeSort.sort(myArray, 0, myArray.length - 1);
		assertArrayEquals(new int[] {1, 2, 3}, myArray);
	}
	
	@Test
	public void testInvertSort() {
		int[] myArray = new int[] {3, 2, 1};
		MergeSort.sort(myArray, 0, myArray.length - 1);
		assertArrayEquals(new int[] {1, 2, 3}, myArray);
	}
	
	@Test
	public void testEvenN() {
		int[] myArray = new int[] {5, 9, 21, 4};
		MergeSort.sort(myArray, 0, myArray.length - 1);
		assertArrayEquals(new int[] {4, 5, 9, 21}, myArray);
	}
	
	@Test
	public void testMaxIntValue() {
		int[] myArray = new int[] {Integer.MAX_VALUE, 4, 3, 2};
		MergeSort.sort(myArray, 0, myArray.length - 1);
		assertArrayEquals(new int[] {2, 3, 4, Integer.MAX_VALUE}, myArray);
	}

	@Test
	public void testMaxIntValueAgain() {
		int[] myArray = new int[] {4, Integer.MAX_VALUE, 4, 3, 2};
		MergeSort.sort(myArray, 0, myArray.length - 1);
		assertArrayEquals(new int[] {2, 3, 4, 4, Integer.MAX_VALUE}, myArray);
	}
}
