
public class InsertionSort {

	public static void sort(int[] myArray) {
		for (int i = 1; i < myArray.length; i++) {
			int key = myArray[i];
			// Insert key into the sorted sequence A[0..i-1]
			int j = i - 1;
			while (j >= 0 && myArray[j] > key) {
				myArray[j + 1] = myArray[j];
				j--;
			}
			myArray[j + 1] = key;
		}
		
	}

}
