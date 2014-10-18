import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;


public class Group4 {

	private static String inputFile;
	private static String outputFile;
	private static int numberOfLoops;
	private static double lambda;
	private static int n = 0;
	private static ArrayList<String> rawInput = new ArrayList<String>();
	private static EnhancedString[] data;


	public static void main(String[] args) throws IOException, InterruptedException {

		// Store command-line args
		inputFile = args[0];
		outputFile = args[1];
		numberOfLoops = Integer.parseInt(args[2]);

		// Get the input from the file
		Path inFile = Paths.get(inputFile);
		try (BufferedReader reader = Files.newBufferedReader(inFile)) {
			lambda = Double.parseDouble(reader.readLine());
			String line = null;
			while ((line = reader.readLine()) != null) {
				rawInput.add(line);
				n++;
			}
		}

		data = new EnhancedString[n];
		Thread.sleep(10);

		Sorter algorithm = new Quick3();
//		Sorter algorithm = new Quick3Median3();
//		Sorter algorithm = new Merge();
//		Sorter algorithm = new Quick3Ins12Median3();
//		Sorter algorithm = new Quick();
		long startTime = System.currentTimeMillis();

		// Algorithm
		for (int loop = 0; loop < numberOfLoops; loop++) {
			for (int i = rawInput.size() - 1; i >= 0; i--) {
				data[i] = new EnhancedString(rawInput.get(i));
			}
			

			algorithm.sort(data);
//			quick3Sort(data, 0, data.length - 1);
//			quick3Median3Sort(data, 0, data.length - 1);
//			mergeSort(data, 0, data.length - 1);
//			quick3Ins12Median3Sort(data, 0, data.length - 1);
//			quickSort(data, 0, data.length - 1);
			
			
//			MSDsort(data);
//			Arrays.sort(data, new LengthAndSumComparator());
//			mergeSort(data, 0, data.length - 1, new LengthAndSumComparator());
//			quick3Sort(data, 0, data.length - 1, new EverythingComparator());
//			quickSort2(data, 0, data.length - 1, new EverythingComparator());
//			insertionSort(data, 0, data.length, new EverythingComparator());
//			Arrays.sort(data, new EverythingComparator());
//			bottomUpMergeSort(data, 0, data.length, new EverythingComparator());
			
			
			
//			compareAll(data, new LengthComparator());
//			compareAll(data, new EverythingComparator());
//			Arrays.sort(data, new AlphabeticalComparator());
//			quickSort(data, 0, data.length - 1, new EverythingComparator());
//			Arrays.sort(data, new LengthAndSumComparator());
//			quickSort(data, 0, data.length - 1, new SumOfOnesComparator());
//			quickSort(data, 0, data.length - 1, new LengthComparator());
//			insertionSort(data, 0, data.length, new EverythingComparator());
//			Arrays.sort(data, new AlphabeticalComparator());
//			insertionSort(data, 0, data.length, new AlphabeticalComparator());
//			Arrays.sort(data, new SumOfOnesComparator());
//			insertionSort(data, 0, data.length, new SumOfOnesComparator());
//			Arrays.sort(data, new LengthComparator());
//			insertionSort(data, 0, data.length, new LengthComparator());
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		Path outFile = Paths.get(outputFile);
		try (BufferedWriter writer = Files.newBufferedWriter(outFile)) {
			for (EnhancedString line : data) {
				writer.write(line.binaryString);
				writer.newLine();
			}
		}
	}


	private static void quick3Sort(EnhancedString[] array, int lowIndex, int highIndex) {
		if (highIndex > lowIndex) {
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
			
			quick3Sort(array, lowIndex, lesserIndex - 1);
			quick3Sort(array, greaterIndex + 1, highIndex);
		}
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


	private static void quick3Ins12Median3Sort(EnhancedString[] array, int lowIndex, int highIndex) {
		quick3Ins12Median3(array, lowIndex, highIndex);
		for (int j = lowIndex + 1; j < highIndex + 1; j++) {
			EnhancedString key = array[j];
			int i = j - 1;
			while (i > lowIndex - 1 && array[i].compareTo(key) > 0) {
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


	// highIndex is inclusive
	private static void mergeSort(EnhancedString[] array, int lowIndex, int highIndex) {
		EnhancedString[] temp = array.clone();
		mergeSort(array, temp, lowIndex, highIndex);
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

	// endIndex is inclusive
	private static void quickSort(EnhancedString[] array, int lowIndex, int highIndex) {
		if (lowIndex < highIndex) {  // -12 and -20 seems good
//			int median = medianOf3(array, lowIndex, (lowIndex + highIndex) / 2, highIndex, comparator);
//			T temp = array[lowIndex];
//			array[lowIndex] = array[median];
//			array[median] = temp;
			int pivot = partition(array, lowIndex, highIndex);
			quickSort(array, lowIndex, pivot - 1);
			quickSort(array, pivot + 1, highIndex);
		}
	}
	
	private static int partition(EnhancedString[] array, int lowIndex, int highIndex) {
		EnhancedString key = array[highIndex]; // Takes pivot from end of section.
		int i = lowIndex - 1;
		for (int j = lowIndex; j < highIndex; j++) {
			if (array[j].compareTo(key) <= 0) {
				i++;
				EnhancedString temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		array[highIndex] = array[i + 1];
		array[i + 1] = key;
		return i + 1;
	}

	// highIndex is inclusive
	//	private static <T> void quickSort2(T[] array, int lowIndex, int highIndex, Comparator<T> comparator) {
	//		if (lowIndex < highIndex - 12) { // -12 and -20 seems good
	//			int median = medianOf3(array, lowIndex, (lowIndex + highIndex) / 2, highIndex, comparator);
	//			T temp = array[lowIndex];
	//			array[lowIndex] = array[median];
	//			array[median] = temp;
	//			int pivot = partition2(array, lowIndex, highIndex, comparator);
	//			quickSort2(array, lowIndex, pivot - 1, comparator);
	//			quickSort2(array, pivot + 1, highIndex, comparator);
	//		}
	//	}
		
		// highIndex is inclusive
	//	private static <T> int partition2(T[] array, int lowIndex, int highIndex, Comparator<T> comparator) {
	//		int i = lowIndex;
	//		int j = highIndex + 1;
	//		T key = array[lowIndex]; // Takes pivot from beginning of section
	//		while (true) {
	//			while (comparator.compare(array[++i], key) < 0) {
	//				if (i == highIndex) {
	//					break;
	//				}
	//			}
	//			while (comparator.compare(key, array[--j]) < 0) {
	//				// Redundant check
	////				if (j == lowIndex) {
	////					break;
	////				}
	//			}
	//			
	//			if (i >= j) {
	//				break;
	//			}
	//			T temp = array[i];
	//			array[i] = array[j];
	//			array[j] = temp;
	//		}
	//		
	//		array[lowIndex] = array[j];
	//		array[j] = key;
	//		return j;
	//	}
	


	// Just used for testing, makes n! comparisons
//	private static <T> void compareAll(T[] array, Comparator<T> comparator) {
//		for (int i = 0; i < array.length - 1; i++) {
//			for (int j = i + 1; j < array.length; j++) {
//				int comparison = comparator.compare(array[i], array[j]);
//			}
//		}
//	}



	// endIndex is exclusive
//	private static <T> void insertionSort(T[] array, int startIndex, int endIndex, Comparator<T> comparator) {
//		for (int j = startIndex + 1; j < endIndex; j++) {
//			T key = array[j];
//			int i = j - 1;
//			while (i > startIndex - 1 && comparator.compare(array[i], key) > 0) {
//				array[i + 1] = array[i--];
//			}
//			array[i + 1] = key;
//		}
//	}


//	private static void MSDsort(EnhancedString[] array) {
//		int size = array.length;
//		EnhancedString[] auxiliary = new EnhancedString[size];
//		MSDsort(array, auxiliary, 0, size - 1, 0);
//	}


//	private static void MSDsort(EnhancedString[] array, EnhancedString[] auxiliary, int lowIndex, int highIndex, int digit) {
//		if (lowIndex < highIndex) {
//			int[] count = new int[4]; // 2 possible values + 2
//			for (int i = lowIndex; i <= highIndex; i++) {
//				count[charAt(array[i], digit) + 2]++;
//			}
//			for (int r = 0; r < 3; r++) { // r < 2 possible values + 1
//				count[r + 1] += count[r];
//			}
//			for (int i = lowIndex; i <= highIndex; i++) {
//				auxiliary[count[charAt(array[i], digit) + 1]++] = array[i];
//			}
//			for (int i = lowIndex; i <= highIndex; i++) {
//				array[i] = auxiliary[i - lowIndex]; 
//			}
//			
//			for (int r = 0; r < 2; r++) { // r < 2 since there are 2 possible values
//				MSDsort(array, auxiliary, lowIndex + count[r], lowIndex + count[r + 1] - 1, digit + 1);
//			}
//		}
//	}


//	private static int charAt(EnhancedString string, int digit) {
//		return (digit < string.length ? string.binaryString.charAt(digit) - '0' : -1);
//	}


	// highIndex is exclusive
//	private static <T> void bottomUpMergeSort(T[] array, int lowIndex, int highIndex, Comparator<T> comparator) {
//		for (int size = 1; size < highIndex; size += size) {
//			T[] temp = array.clone();
//			for (int start = lowIndex; start < highIndex - size; start += (size + size)) {
//				merge(array, temp, start, start + size - 1, Math.min(start + size + size - 1, highIndex - 1), comparator);
//			}
//		}
//	}
}