public class QuickMod {

	public static void sortArray(ModData[] array) {
		quickSortArray(array, 0, array.length - 1);
	}

	// endIndex is inclusive
	private static void quickSortArray(ModData[] array, int lowIndex, int highIndex) {
		if (lowIndex < highIndex) {
			int pivot = partitionArray(array, lowIndex, highIndex);
			quickSortArray(array, lowIndex, pivot - 1);
			quickSortArray(array, pivot + 1, highIndex);
		}
	}

	private static int partitionArray(ModData[] array, int lowIndex, int highIndex) {
		ModData key = array[highIndex]; // Takes pivot from end of section.
		int i = lowIndex - 1;
		for (int j = lowIndex; j < highIndex; j++) {
			if (array[j].compareTo(key) <= 0) {
				i++;
				ModData temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		array[highIndex] = array[i + 1];
		array[i + 1] = key;
		return i + 1;
	}
}
