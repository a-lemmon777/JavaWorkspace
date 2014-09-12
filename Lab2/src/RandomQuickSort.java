// Dalton Gusaas && Aaron Lemmon
import java.util.Random;


public class RandomQuickSort extends QuickSort {

	public static void sort(TestInteger[] array, int start, int end) {
		if (start < end) {
			int midpoint = partition(array, start, end);
			sort(array, start, midpoint - 1);
			sort(array, midpoint + 1, end);
		}
	}
	
	public static int partition(TestInteger[] array, int start, int end) {
		Random random = new Random();
		int pivotIndex = (random.nextInt(end - start + 1) + start);
		swap(array, end, pivotIndex);
		return QuickSort.partition(array, start, end);
	}
}
