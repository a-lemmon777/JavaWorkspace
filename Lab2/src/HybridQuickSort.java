// Dalton Gusaas && Aaron Lemmon
import java.util.Arrays;


public class HybridQuickSort {

	private static final int THRESHOLD = 4;

	public static void sort(TestInteger[] array, int start, int end) {
		quickSort(array, start, end);
		//System.out.println(Arrays.toString(array));
		insertionSort(array);
		//System.out.println(Arrays.toString(array));
	}

	public static void quickSort(TestInteger[] array, int start, int end) {
		if ((end - start) > THRESHOLD) {
			int midpoint = partition(array, start, end);
			quickSort(array, start, midpoint - 1);
			quickSort(array, midpoint + 1, end);
		}
		
	}
	
	public static int partition(TestInteger[] array, int start, int end) {
		TestInteger pivot = array[end];
		int i = start - 1;

		for (int j = start; j < end; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, end);
		return i + 1;
	}

	public static void insertionSort(TestInteger[] myArray) {
		for (int i = 1; i < myArray.length; i++) {
			TestInteger key = myArray[i];
			// Insert key into the sorted sequence A[0..i-1]
			int j = i - 1;
			while (j >= 0 && (myArray[j].compareTo(key) == 1)) {
				myArray[j + 1] = myArray[j];
				j--;
			}
			myArray[j + 1] = key;
		}
	}
	
	public static void swap(TestInteger[] array, int index1, int index2) {
		TestInteger temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
