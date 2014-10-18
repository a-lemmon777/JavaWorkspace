
public class Quick3Ins12Median3 implements Sorter {

	@Override
	public void sort(EnhancedString[] array) {
		int length = array.length;
		quick3Ins12Median3(array, 0, length - 1);
		for (int j = 1; j < length; j++) {
			EnhancedString key = array[j];
			int i = j - 1;
			while (i >= 0 && array[i].compareTo(key) > 0) {
				array[i + 1] = array[i--];
			}
			array[i + 1] = key;
		}
	}
	
	private static void quick3Ins12Median3(EnhancedString[] array, int lowIndex, int highIndex) {
		if (highIndex > lowIndex + 12) {
			int median = medianOf3(array, lowIndex, (lowIndex + highIndex) / 2, highIndex);
			EnhancedString temporary = array[lowIndex];
			array[lowIndex] = array[median];
			array[median] = temporary;
			int lesserIndex = lowIndex;
			int greaterIndex = highIndex;
			EnhancedString key = array[lowIndex];
			int i = lowIndex;
			while (i <= greaterIndex) {
				int comparison = array[i].compareTo(key);
				if (comparison < 0) {
					EnhancedString temp = array[lesserIndex];
					array[lesserIndex++] = array[i];
					array[i++] = temp;
				} else if (comparison > 0) {
					EnhancedString temp = array[i];
					array[i] = array[greaterIndex];
					array[greaterIndex--] = temp;
				} else {
					i++;
				}
			}
			
			quick3Ins12Median3(array, lowIndex, lesserIndex - 1);
			quick3Ins12Median3(array, greaterIndex + 1, highIndex);
		}
	}
	
	private static int medianOf3(EnhancedString[] array, int lowIndex, int midIndex, int highIndex) {
		if (array[lowIndex].compareTo(array[midIndex]) < 0) {
			if (array[midIndex].compareTo(array[highIndex]) < 0) {
				return midIndex;
			} else if (array[lowIndex].compareTo(array[highIndex]) < 0) {
				return highIndex;
			} else {
				return lowIndex;
			}
		} else {
			if (array[lowIndex].compareTo(array[highIndex]) < 0) {
				return lowIndex;
			} else if (array[midIndex].compareTo(array[highIndex]) < 0) {
				return highIndex;
			} else {
				return midIndex;
			}
		}
	}

}
