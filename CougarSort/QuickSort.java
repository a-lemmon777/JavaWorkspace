import java.util.Comparator;


public class QuickSort {


	// endIndex is inclusive
	public static <T> void quickSort(T[] array, int startIndex, int endIndex, Comparator<T> comparator) {
		if (startIndex < endIndex) {
			int pivot = partition(array, startIndex, endIndex, comparator);
			quickSort(array, startIndex, pivot - 1, comparator);
			quickSort(array, pivot + 1, endIndex, comparator);
		}
	}

	private static <T> int partition(T[] array, int startIndex, int endIndex, Comparator<T> comparator) {
		T key = array[endIndex];
		int i = startIndex - 1;
		for (int j = startIndex; j < endIndex; j++) {
			if (comparator.compare(array[j], key) <= 0) {
				i++;
				T temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		T temp = array[i + 1];
		array[i + 1] = array[endIndex];
		array[endIndex] = temp;
		return i + 1;
	}
}
