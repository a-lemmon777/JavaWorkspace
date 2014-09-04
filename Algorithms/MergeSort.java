
public class MergeSort {

	public static void sort(int[] myArray, int start, int end) {
		if (start < end) {
			int midpoint = (start + end) / 2;
			sort(myArray, start, midpoint);
			sort(myArray, midpoint + 1, end);
			merge(myArray, start, midpoint, end);
		}
	}

	private static void merge(int[] myArray, int start, int midpoint, int end) {
		int lhsLength = midpoint - start + 1;
		int rhsLength = end - midpoint;
		int[] lhs = new int[lhsLength + 1];
		int[] rhs = new int[rhsLength + 1];
		for (int i = 0; i < lhsLength; i++) {
			lhs[i] = myArray[start + i];
		}
		for (int i = 0; i < rhsLength; i++) {
			rhs[i] = myArray[midpoint + i + 1];
		}
		lhs[lhsLength] = Integer.MAX_VALUE;
		rhs[rhsLength] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for (int k = start; k <= end; k++) {
			if (lhs[i] <= rhs[j]) {
				myArray[k]= lhs[i];
				i++;
			} else {
				myArray[k] = rhs[j];
				j++;
			}
		}
	}
	
}
