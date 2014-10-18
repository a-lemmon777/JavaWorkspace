
public class Quick3Median3 implements Sorter {

	public void sort(EnhancedString[] array) {
		quick3Median3Sort(array, 0, array.length - 1);
	}
	
	private static void quick3Median3Sort(EnhancedString[] array, int lowIndex, int highIndex) {
		if (highIndex > lowIndex) {
			int median = medianOf3(array, lowIndex, (lowIndex + highIndex) / 2, highIndex);
			
			EnhancedString temporary = array[lowIndex];
			array[lowIndex] = array[median];
			array[median] = temporary;
			int lesserIndex = lowIndex;
			int greaterIndex = highIndex;
			EnhancedString key = array[lowIndex];
			int i = lowIndex;
			while (i <= greaterIndex) {
//				int comparison = comparator.compare(array[i], key);
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
			
			quick3Median3Sort(array, lowIndex, lesserIndex - 1);
			quick3Median3Sort(array, greaterIndex + 1, highIndex);
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
