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
	//private static BigBinary[] sortThis;
	private static String[] sortThis;
	private static int chunkSize;
	private static int possibleVals;

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
			int allDigits = 0;
			while ((line = reader.readLine()) != null) {
				if (line.length() > maxDigits) {
					maxDigits = line.length();
				}
				allDigits += line.length();
				rawInput.add(line);
				n++;
			}
			int avgNumDigits = (int) (allDigits / n);
//			System.out.println("avgNumDigits: " + avgNumDigits);
			int logBaseTwoOfN = logBaseTwo(n);
//			System.out.println("logBaseTwo of n: " + logBaseTwoOfN);
			chunkSize = (avgNumDigits < logBaseTwoOfN ? avgNumDigits : logBaseTwoOfN);
//			System.out.println("chunkSize: " + chunkSize);
			possibleVals = (int) Math.pow(2, chunkSize);
			
			
			
			
		}

		//sortThis = new BigBinary[n];
		sortThis = new String[n];
		Thread.sleep(10);
//		System.out.println("max digits: " + maxDigits);

		// The Algorithm
		long startTime = System.currentTimeMillis();
		
		
		
		for (int loop = 0; loop < numberOfLoops; loop++) {
			sortThis = rawInput.toArray(sortThis);
			Arrays.sort(sortThis, new StringComparator());
	/*
			// Fill sortThis with BigBinaries
			for (int i = 0; i < n; i++) {
				sortThis[i] = new BigBinary(rawInput.get(i));
			}
			long afterCopy = System.currentTimeMillis();
			System.out.println(afterCopy - startTime);
			// radix sort alphabetically
			for (int i = 0; i < maxDigits; i += chunkSize) {
				int[] counts = new int[possibleVals];
				for (int j = 0; j < sortThis.length; j++) {
					counts[sortThis[j].getValBefore(i, chunkSize)]++;
				}
				for (int j = 1; j < possibleVals; j++) {
					counts[j] += counts[j - 1]; 
				}
				BigBinary[] temp = new BigBinary[n];
				for (int j = sortThis.length - 1; j >= 0; j--) {
					temp[counts[sortThis[j].getValBefore(i, chunkSize)] - 1] = sortThis[j];
					counts[sortThis[j].getValBefore(i, chunkSize)]--;
				}
				sortThis = temp;
			}
			
			long afterRadix = System.currentTimeMillis();
			System.out.println(afterRadix - afterCopy);
			// counting sort on sumOfOnes
			int[] count = new int[maxDigits + 1]; // change to maxOnes + 1
			for (int j = 0; j < sortThis.length; j++) {
				count[sortThis[j].getSumOfOnes()]++;
			}
			for (int j = 1; j < count.length; j++) {
				count[j] += count[j - 1]; 
			}
			BigBinary[] temp = new BigBinary[n];
			for (int j = sortThis.length - 1; j >= 0; j--) {
				temp[count[sortThis[j].getSumOfOnes()] - 1] = sortThis[j];
				count[sortThis[j].getSumOfOnes()]--;
			}
			sortThis = temp;

			long afterSumOfOnes = System.currentTimeMillis();
			System.out.println(afterSumOfOnes - afterRadix);
			// counting sort on length
			int[] counts = new int[maxDigits + 1];
			for (int j = 0; j < sortThis.length; j++) {
				counts[sortThis[j].getLength()]++;
			}
			for (int j = 1; j < counts.length; j++) {
				counts[j] += counts[j - 1]; 
			}
			BigBinary[] tempArray = new BigBinary[n];
			for (int j = sortThis.length - 1; j >= 0; j--) {
				tempArray[counts[sortThis[j].getLength()] - 1] = sortThis[j];
				counts[sortThis[j].getLength()]--;
			}
			sortThis = tempArray;

			long afterLengthSort = System.currentTimeMillis();
			System.out.println(afterLengthSort - afterSumOfOnes);
			*/
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);

		// Write out the results
		Path outFile = Paths.get(outputFile);
		try (BufferedWriter writer = Files.newBufferedWriter(outFile)) {
			//for (BigBinary line : sortThis) {
			for (String line : sortThis) { 
				writer.write(line.toString());
				writer.newLine();
			}
		}
	}

	private static int logBaseTwo(int value) {
		// Divides by natural log of 2
		return (int) (Math.log(value) / 0.6931471805599453);
	}
}
