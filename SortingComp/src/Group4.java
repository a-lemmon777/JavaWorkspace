import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// Dalton Gusaas && Aaron Lemmon

public class Group4 {
	private static String inputFile;
	private static String outputFile;
	private static int numberOfLoops;
	private static double lambda;
	private static int maxDigits = 0;
	private static ArrayList<String> rawInput = new ArrayList<String>();
	private static int n = 0;
	private static String[] sortThis;
	private static int numBuckets;
	private static ArrayList<Integer> partitions = new ArrayList<Integer>();

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
				if (line.length() > maxDigits) {
					maxDigits = line.length();
				}
				rawInput.add(line);
				n++;
			}
		}
		
		partitions.add(25000);
		partitions.add(50000);
		partitions.add(75000);
		sortThis = new String[n];
		Thread.sleep(10);
		System.out.println(maxDigits);
		
		// The Algorithm
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < numberOfLoops; i++) {
			rawInput.toArray(sortThis); // Takes 0.557 ms for n=100,000
			Arrays.sort(sortThis, new StringComparator());
			// Counting/bucket sort by length
			int[] countsForBuckets = new int[numBuckets];
			for (int j = 0; j < n; j++) {
				//countsForBuckets[partitions[j]]++;
				
				// j is location of element
				// look at value at j
				// 
			}
			for (int k = 0; k < numBuckets; k++) {
				// do cumulative sum
			}
			for (int j = 0; j < n; j++) {
				// copy value into its bucket
			}
			
			// Radix sort for each bucket
				// Alphabetically
				// Sum
				// Length
			
			
			
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
		// Write out the results
		Path outFile = Paths.get(outputFile);
		try (BufferedWriter writer = Files.newBufferedWriter(outFile)) {
			for (String line : sortThis) {
				writer.write(line);
				writer.newLine();
			}
		}
	}
	
	private static class StringComparator implements Comparator<String> {

		@Override
		public int compare(String str1, String str2) {
			if (str1.length() != str2.length()) {
				return str1.length() - str2.length();
			}
			
			// only get here if the lengths are equal
			int sum1 = sumOnes(str1);
			int sum2 = sumOnes(str2);
			if (sum1 != sum2) {
				return (sum1 - sum2);
			}
			
			// only get here if the sum and the length are equal
			return str1.compareTo(str2);
		}
		
		private int sumOnes(String str) {
			int count = 0;
			for (int i = 0; i < str.length(); ++i) {
				count += str.charAt(i) - '0';
			}
			return count;
		}
		
	}
}
