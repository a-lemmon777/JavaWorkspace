import java.util.ArrayList;

public class QuickInt {

	public static void sortArray(IntData[] array) {
		quickSortArray(array, 0, array.length - 1);
	}

	// endIndex is inclusive
	private static void quickSortArray(IntData[] array, int lowIndex, int highIndex) {
		if (lowIndex < highIndex) {
			int pivot = partitionArray(array, lowIndex, highIndex);
			quickSortArray(array, lowIndex, pivot - 1);
			quickSortArray(array, pivot + 1, highIndex);
		}
	}

	private static int partitionArray(IntData[] array, int lowIndex, int highIndex) {
		IntData key = array[highIndex]; // Takes pivot from end of section.
		int i = lowIndex - 1;
		for (int j = lowIndex; j < highIndex; j++) {
			if (array[j].compareTo(key) <= 0) {
				i++;
				IntData temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		array[highIndex] = array[i + 1];
		array[i + 1] = key;
		return i + 1;
	}
	
	public static void sortArrayList(ArrayList<IntData> arrayList) {
		quickSortArrayList(arrayList, 0, arrayList.size() - 1);
	}

	// endIndex is inclusive
	private static void quickSortArrayList(ArrayList<IntData> arrayList, int lowIndex, int highIndex) {
		if (lowIndex < highIndex) {
			int pivot = partitionArrayList(arrayList, lowIndex, highIndex);
			quickSortArrayList(arrayList, lowIndex, pivot - 1);
			quickSortArrayList(arrayList, pivot + 1, highIndex);
		}
	}

	private static int partitionArrayList(ArrayList<IntData> arrayList, int lowIndex, int highIndex) {
		IntData key = arrayList.get(highIndex); // Takes pivot from end of section.
		int i = lowIndex - 1;
		for (int j = lowIndex; j < highIndex; j++) {
			if (arrayList.get(j).compareTo(key) <= 0) {
				i++;
				IntData temp = arrayList.get(i);
				arrayList.set(i, arrayList.get(j));
				arrayList.set(j, temp);
			}
		}
		arrayList.set(highIndex, arrayList.get(i + 1));
		arrayList.set(i + 1, key);
		return i + 1;
	}
}
