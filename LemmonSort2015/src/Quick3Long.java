import java.util.ArrayList;

public class Quick3Long {

	public static void sortArray(LongData[] array) {
		quick3SortArray(array, 0, array.length - 1);
	}

	// highIndex is inclusive
	private static void quick3SortArray(LongData[] array, int lowIndex, int highIndex) {
		if (highIndex > lowIndex) {
			int lesserIndex = lowIndex;
			int greaterIndex = highIndex;
			LongData key = array[lowIndex];
			int i = lowIndex;
			while (i <= greaterIndex) {
				int comparison = array[i].compareTo(key);
				if (comparison < 0) {
					LongData temp = array[lesserIndex];
					array[lesserIndex++] = array[i];
					array[i++] = temp;
				} else if (comparison > 0) {
					LongData temp = array[i];
					array[i] = array[greaterIndex];
					array[greaterIndex--] = temp;
				} else {
					i++;
				}
			}

			quick3SortArray(array, lowIndex, lesserIndex - 1);
			quick3SortArray(array, greaterIndex + 1, highIndex);
		}
	}
	
	public static void sortArrayList(ArrayList<LongData> arrayList) {
		quick3SortArrayList(arrayList, 0, arrayList.size() - 1);
	}
	
	// highIndex is inclusive
	private static void quick3SortArrayList(ArrayList<LongData> arrayList, int lowIndex, int highIndex) {
		if (highIndex > lowIndex) {
			int lesserIndex = lowIndex;
			int greaterIndex = highIndex;
			LongData key = arrayList.get(lowIndex);
			int i = lowIndex;
			while (i <= greaterIndex) {
				int comparison = arrayList.get(i).compareTo(key);
				if (comparison < 0) {
					LongData temp = arrayList.get(lesserIndex);
					arrayList.set(lesserIndex++, arrayList.get(i));
					arrayList.set(i++, temp);
				} else if (comparison > 0) {
					LongData temp = arrayList.get(i);
					arrayList.set(i, arrayList.get(greaterIndex));
					arrayList.set(greaterIndex--, temp);
				} else {
					i++;
				}
			}

			quick3SortArrayList(arrayList, lowIndex, lesserIndex - 1);
			quick3SortArrayList(arrayList, greaterIndex + 1, highIndex);
		}
	}
}
