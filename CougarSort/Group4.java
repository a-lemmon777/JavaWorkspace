import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


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

		long startTime = System.currentTimeMillis();

		// Algorithm
		for (int loop = 0; loop < numberOfLoops; loop++) {
			for (int i = rawInput.size() - 1; i >= 0; i--) {
				data[i] = new EnhancedString(rawInput.get(i));
			}
			
//			MSDsort(data);
//			Arrays.sort(data, new LengthAndSumComparator());
//			mergeSort(data, 0, data.length - 1, new LengthAndSumComparator());
			quick3Sort(data, 0, data.length - 1, new EverythingComparator());
//			quickSort2(data, 0, data.length - 1, new EverythingComparator());
//			insertionSort(data, 0, data.length, new EverythingComparator());
//			Arrays.sort(data, new EverythingComparator());
//			mergeSort(data, 0, data.length - 1, new EverythingComparator());
//			bottomUpMergeSort(data, 0, data.length, new EverythingComparator());
			
			
			
//			compareAll(data, new LengthComparator());
//			compareAll(data, new EverythingComparator());
//			Arrays.sort(data, new AlphabeticalComparator());
//			quickSort(data, 0, data.length - 1, new EverythingComparator());
//			Arrays.sort(data, new LengthAndSumComparator());
//			quickSort(data, 0, data.length - 1, new SumOfOnesComparator());
//			quickSort(data, 0, data.length - 1, new LengthComparator());
//			quickSort(data, 0, data.length - 1, new EverythingComparator());
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


	private static <T> void quick3Sort(T[] array, int lowIndex, int highIndex, Comparator<T> comparator) {
		if (highIndex > lowIndex) { // +12 or +20
			/* I'm not sure if this makes it faster */
			int median = medianOf3(array, lowIndex, (lowIndex + highIndex) / 2, highIndex, comparator);
			T temporary = array[lowIndex];
			array[lowIndex] = array[median];
			array[median] = temporary;
			int lesserIndex = lowIndex;
			int greaterIndex = highIndex;
			T key = array[lowIndex];
			int i = lowIndex;
			while (i <= greaterIndex) {
				int comparison = comparator.compare(array[i], key);
				if (comparison < 0) {
					T temp = array[lesserIndex];
					array[lesserIndex++] = array[i];
					array[i++] = temp;
				} else if (comparison > 0) {
					T temp = array[i];
					array[i] = array[greaterIndex];
					array[greaterIndex--] = temp;
				} else {
					i++;
				}
			}
			
			quick3Sort(array, lowIndex, lesserIndex - 1, comparator);
			quick3Sort(array, greaterIndex + 1, highIndex, comparator);
		}
	}


	// highIndex is inclusive
	private static <T> void mergeSort(T[] array, int lowIndex, int highIndex, Comparator<T> comparator) {
		T[] temp = array.clone();
		mergeSort(array, temp, lowIndex, highIndex, comparator);
	}


	private static <T> void mergeSort(T[] array, T[] temp, int lowIndex, int highIndex, Comparator<T> comparator) {
		/* Doesn't really make it faster */
//		if (highIndex <= lowIndex + 20) {
//			insertionSort(array, lowIndex, highIndex + 1, comparator);
//			return;
//		}
		if (highIndex <= lowIndex) {
			return;
		}
		int midIndex = (lowIndex + highIndex) / 2;
		mergeSort(temp, array, lowIndex, midIndex, comparator);
		mergeSort(temp, array, midIndex + 1, highIndex, comparator);
		merge(array, temp, lowIndex, midIndex, highIndex, comparator);
	}


	private static <T> void merge(T[] array, T[] temp, int lowIndex, int midIndex, int highIndex, Comparator<T> comparator) {
		int i = lowIndex;
		int j = midIndex + 1;
		for (int k = lowIndex; k <= highIndex; k++) {
			if (i > midIndex) {
				array[k] = temp[j++];
			} else if (j > highIndex) {
				array[k] = temp[i++]; 
			} else if (comparator.compare(temp[j], temp[i]) < 0) {
				array[k] = temp[j++];
			} else {
				array[k] = temp[i++]; 
			}
		}
	}

	// endIndex is inclusive
	private static <T> void quickSort(T[] array, int lowIndex, int highIndex, Comparator<T> comparator) {
		if (lowIndex < highIndex) {  // -12 and -20 seems good
			int median = medianOf3(array, lowIndex, (lowIndex + highIndex) / 2, highIndex, comparator);
			T temp = array[lowIndex];
			array[lowIndex] = array[median];
			array[median] = temp;
			int pivot = partition(array, lowIndex, highIndex, comparator);
			quickSort(array, lowIndex, pivot - 1, comparator);
			quickSort(array, pivot + 1, highIndex, comparator);
		}
	}

	// highIndex is inclusive
	private static <T> void quickSort2(T[] array, int lowIndex, int highIndex, Comparator<T> comparator) {
		if (lowIndex < highIndex - 12) { // -12 and -20 seems good
			int median = medianOf3(array, lowIndex, (lowIndex + highIndex) / 2, highIndex, comparator);
			T temp = array[lowIndex];
			array[lowIndex] = array[median];
			array[median] = temp;
			int pivot = partition2(array, lowIndex, highIndex, comparator);
			quickSort2(array, lowIndex, pivot - 1, comparator);
			quickSort2(array, pivot + 1, highIndex, comparator);
		}
	}
	
	private static <T> int medianOf3(T[] array, int lowIndex, int midIndex, int highIndex, Comparator<T> comparator) {
		if (comparator.compare(array[lowIndex], array[midIndex]) < 0) {
			if (comparator.compare(array[midIndex], array[highIndex]) < 0) {
				return midIndex;
			} else if (comparator.compare(array[lowIndex], array[highIndex]) < 0) {
				return highIndex;
			} else {
				return lowIndex;
			}
		} else {
			if (comparator.compare(array[lowIndex], array[highIndex]) < 0) {
				return lowIndex;
			} else if (comparator.compare(array[midIndex], array[highIndex]) < 0) {
				return highIndex;
			} else {
				return midIndex;
			}
		}
	}
	
	// highIndex is inclusive
	private static <T> int partition2(T[] array, int lowIndex, int highIndex, Comparator<T> comparator) {
		int i = lowIndex;
		int j = highIndex + 1;
		T key = array[lowIndex]; // Takes pivot from beginning of section
		while (true) {
			while (comparator.compare(array[++i], key) < 0) {
				if (i == highIndex) {
					break;
				}
			}
			while (comparator.compare(key, array[--j]) < 0) {
				// Redundant check
//				if (j == lowIndex) {
//					break;
//				}
			}
			
			if (i >= j) {
				break;
			}
			T temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		
		array[lowIndex] = array[j];
		array[j] = key;
		return j;
	}


	private static <T> int partition(T[] array, int lowIndex, int highIndex, Comparator<T> comparator) {
		T key = array[highIndex]; // Takes pivot from end of section.
		int i = lowIndex - 1;
		for (int j = lowIndex; j < highIndex; j++) {
			if (comparator.compare(array[j], key) <= 0) {
				i++;
				T temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		array[highIndex] = array[i + 1];
		array[i + 1] = key;
		return i + 1;
	}



	// Just used for testing, makes n! comparisons
//	private static <T> void compareAll(T[] array, Comparator<T> comparator) {
//		for (int i = 0; i < array.length - 1; i++) {
//			for (int j = i + 1; j < array.length; j++) {
//				int comparison = comparator.compare(array[i], array[j]);
//			}
//		}
//	}



	// endIndex is exclusive
	private static <T> void insertionSort(T[] array, int startIndex, int endIndex, Comparator<T> comparator) {
		for (int j = startIndex + 1; j < endIndex; j++) {
			T key = array[j];
			int i = j - 1;
			while (i > startIndex - 1 && comparator.compare(array[i], key) > 0) {
				array[i + 1] = array[i--];
			}
			array[i + 1] = key;
		}
	}


	private static void MSDsort(EnhancedString[] array) {
		int size = array.length;
		EnhancedString[] auxiliary = new EnhancedString[size];
		MSDsort(array, auxiliary, 0, size - 1, 0);
	}


	private static void MSDsort(EnhancedString[] array, EnhancedString[] auxiliary, int lowIndex, int highIndex, int digit) {
		if (lowIndex < highIndex) {
			int[] count = new int[4]; // 2 possible values + 2
			for (int i = lowIndex; i <= highIndex; i++) {
				count[charAt(array[i], digit) + 2]++;
			}
			for (int r = 0; r < 3; r++) { // r < 2 possible values + 1
				count[r + 1] += count[r];
			}
			for (int i = lowIndex; i <= highIndex; i++) {
				auxiliary[count[charAt(array[i], digit) + 1]++] = array[i];
			}
			for (int i = lowIndex; i <= highIndex; i++) {
				array[i] = auxiliary[i - lowIndex]; 
			}
			
			for (int r = 0; r < 2; r++) { // r < 2 since there are 2 possible values
				MSDsort(array, auxiliary, lowIndex + count[r], lowIndex + count[r + 1] - 1, digit + 1);
			}
		}
	}


	private static int charAt(EnhancedString string, int digit) {
		return (digit < string.length ? string.binaryString.charAt(digit) - '0' : -1);
	}


	// highIndex is exclusive
	private static <T> void bottomUpMergeSort(T[] array, int lowIndex, int highIndex, Comparator<T> comparator) {
		for (int size = 1; size < highIndex; size += size) {
			T[] temp = array.clone();
			for (int start = lowIndex; start < highIndex - size; start += (size + size)) {
				merge(array, temp, start, start + size - 1, Math.min(start + size + size - 1, highIndex - 1), comparator);
			}
		}
	}
}