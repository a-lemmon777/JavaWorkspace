import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
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


			quickSortFat(data, 0, data.length - 1, new EverythingComparator());
//			compareAll(data, new LengthComparator());
//			compareAll(data, new EverythingComparator());
//			Arrays.sort(data, new AlphabeticalComparator());
//			quickSort(data, 0, data.length - 1, new AlphabeticalComparator());
//			Arrays.sort(data, new LengthAndSumComparator());
//			quickSort(data, 0, data.length - 1, new SumOfOnesComparator());
//			quickSort(data, 0, data.length - 1, new LengthComparator());
//			quickSort(data, 0, data.length - 1, new EverythingComparator());
//			Arrays.sort(data, new EverythingComparator());
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

	// Just used for testing, makes n! comparisons
	private static <T> void compareAll(T[] array, Comparator<T> comparator) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int comparison = comparator.compare(array[i], array[j]);
			}
		}
	}

	// endIndex is inclusive
	private static <T> void quickSort(T[] array, int startIndex, int endIndex, Comparator<T> comparator) {
		if (startIndex < endIndex) {
			int pivot = partition(array, startIndex, endIndex, comparator);
			quickSort(array, startIndex, pivot - 1, comparator);
			quickSort(array, pivot + 1, endIndex, comparator);
		}
	}

	private static <T> int partition(T[] array, int startIndex, int endIndex, Comparator<T> comparator) {
		T key = array[endIndex];
		int i = startIndex - 1;
		for (int j = startIndex; j < endIndex; j++) {
			if (comparator.compare(array[j], key) <= 0) {
				i++;
				T temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		T temp = array[i + 1];
		array[i + 1] = array[endIndex];
		array[endIndex] = temp;
		return i + 1;
	}

	// endIndex is inclusive
	private static <T> void quickSortFat(T[] array, int startIndex, int endIndex, Comparator<T> comparator) {
		if (startIndex < endIndex) {
			int pivot = endIndex; // could chose a different pivot
			int[] leftAndRight = partitionFat(array, pivot, startIndex, endIndex, comparator);
			quickSortFat(array, startIndex, leftAndRight[0], comparator);
			quickSortFat(array, leftAndRight[1], endIndex, comparator);
		}
	}

	// Assumes the pivot is the last element
	private static <T> int[] partitionFat(T[] array, int pivot, int startIndex, int endIndex, Comparator<T> comparator) {
		T key = array[pivot];
		int i = startIndex;
		int lessThan = startIndex;
		int greaterThan = endIndex - 1;
		int comparison = comparator.compare(array[i], key);
		while (i <= greaterThan) {
			if (comparison < 0) {
				T temp = array[lessThan];
				array[lessThan++] = array[i];
//				array[i++] = temp;
//				lessThan++; // These were put in above
				i++;
			} else if (comparison > 0) {
				T temp = array[i];
				array[i] = array[greaterThan];
				array[greaterThan--] = temp;
//				greaterThan--; // Put in above
			} else {
				i++;
			}
		}
		return new int[] {lessThan, greaterThan};
	}

	// endIndex is exclusive
	public static <T> void insertionSort(T[] array, int startIndex, int endIndex, Comparator<T> comparator) {
		for (int j = startIndex + 1; j < endIndex; j++) {
			T key = array[j];
			int i = j - 1;
			while (i > startIndex - 1 && comparator.compare(array[i], key) > 0) {
				array[i + 1] = array[i];
				i--;
			}
			array[i + 1] = key;
		}
	}


}