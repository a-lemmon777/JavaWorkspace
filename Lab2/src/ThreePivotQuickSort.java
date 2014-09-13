// Dalton Gusaas && Aaron Lemmon
import java.util.Random;


public class ThreePivotQuickSort extends QuickSort {

	private static final int THRESHOLD = 15;

	public static void sort(TestInteger[] array, int start, int end) {
		if (start < end) {
			int midpoint = partition(array, start, end);
			sort(array, start, midpoint - 1);
			sort(array, midpoint + 1, end);
		}
	}
	
	public static int partition(TestInteger[] array, int start, int end) {
		if ((end - start) > THRESHOLD) {
			Random random = new Random();
			int n1 = (random.nextInt(end - start + 1) + start);
			int n2 = (random.nextInt(end - start + 1) + start);
			int n3 = (random.nextInt(end - start + 1) + start);
			int pivotIndex = returnMiddle(array, n1, n2, n3);
			swap(array, end, pivotIndex);
		}
		return QuickSort.partition(array, start, end);
	}

	private static int returnMiddle(TestInteger[] array, int n1, int n2, int n3) {
		TestInteger val1 = array[n1];
		TestInteger val2 = array[n2];
		TestInteger val3 = array[n3];
		
		if (val2.compareTo(val1) <= 0 && val1.compareTo(val3) <= 0) {
			return n1;
		} else if (val3.compareTo(val1) <= 0 && val1.compareTo(val2) <= 0) {
			return n1;
		} else if (val1.compareTo(val2) <= 0 && val2.compareTo(val3) <= 0) {
			return n2;
		} else if (val3.compareTo(val2) <= 0 && val2.compareTo(val1) <= 0) {
			return n2;
		} else {
			return n3;
		}
	}
}