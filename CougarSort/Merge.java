
public class Merge implements Sorter {

	@Override
	public void sort(EnhancedString[] array) {
		EnhancedString[] temp = array.clone();
		mergeSort(array, temp, 0, array.length - 1);
	}

	private static void mergeSort(EnhancedString[] array, EnhancedString[] temp, int lowIndex, int highIndex) {
		if (highIndex <= lowIndex) {
			return;
		}
		int midIndex = (lowIndex + highIndex) / 2;
		mergeSort(temp, array, lowIndex, midIndex);
		mergeSort(temp, array, midIndex + 1, highIndex);
		merge(array, temp, lowIndex, midIndex, highIndex);
	}


	private static void merge(EnhancedString[] array, EnhancedString[] temp, int lowIndex, int midIndex, int highIndex) {
		int i = lowIndex;
		int j = midIndex + 1;
		for (int k = lowIndex; k <= highIndex; k++) {
			if (i > midIndex) {
				array[k] = temp[j++];
			} else if (j > highIndex) {
				array[k] = temp[i++]; 
			} else if (temp[j].compareTo(temp[i]) < 0) {
				array[k] = temp[j++];
			} else {
				array[k] = temp[i++]; 
			}
		}
	}
}
