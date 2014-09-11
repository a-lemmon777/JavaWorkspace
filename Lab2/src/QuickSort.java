// Dalton Gusaas && Aaron Lemmon
public class QuickSort {

	public static void sort(TestInteger[] array, int start, int end) {
		if (start < end) {
			int midpoint = partition(array, start, end);
			sort(array, start, midpoint - 1);
			sort(array, midpoint + 1, end);
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

	public static void swap(TestInteger[] array, int index1, int index2) {
		TestInteger temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public static boolean isSorted(TestInteger[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i].compareTo(array[i + 1]) == 1) {
				return false;
			}
		}
		return true;
	}
}
