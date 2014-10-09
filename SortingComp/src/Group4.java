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
	private static int actualMaxLength = 0;
	private static ArrayList<String> rawInput = new ArrayList<String>();
	private static int n = 0;
//	private static BigBinary[] sortThis;
	private static String[] sortThis;
//	private static int chunkSize;
//	private static int possibleVals;
	private static int[] possibleVals = new int[5];
	private static double[] bucketDeterminers = {0.236, 0.3425, 0.479, 0.783};
	private static int[] maxLength = new int[5];
	private static int[] allDigits = new int[5];
	private static int[] avgNumDig = new int[5];
	private static int[] sizeOfPart = new int[5];
	private static int[] startIndex = new int[5];
	private static int[] endIndex = new int[5];
	private static int[] chunkSize = new int[5];
	private static int[] cumulativeSizeOfPart = new int[5];


	public static void main(String[] args) throws IOException, InterruptedException {
		// Store command-line args
		inputFile = args[0];
		outputFile = args[1];
		numberOfLoops = Integer.parseInt(args[2]);

		// Get the input from the file
		Path inFile = Paths.get(inputFile);
		try (BufferedReader reader = Files.newBufferedReader(inFile)) {
			lambda = Double.parseDouble(reader.readLine());
			int maxLengthGuess = (int) lambda * 45;
			for (int i = 0; i < bucketDeterminers.length; i++) {
				maxLength[i] = (int)(maxLengthGuess * bucketDeterminers[i]) - 1;
			}
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				if (line.length() > actualMaxLength) {
					actualMaxLength = line.length();
				}
				if (line.length() < maxLength[0]) {
					sizeOfPart[0]++;
					allDigits[0]++;
				} else if (line.length() < maxLength[1]) {
					sizeOfPart[1]++;
					allDigits[1]++;
				} else if (line.length() < maxLength[2]) {
					sizeOfPart[2]++;
					allDigits[2]++;
				} else if (line.length() < maxLength[3]) {
					sizeOfPart[3]++;
					allDigits[3]++;
				} else {
					sizeOfPart[4]++;
					allDigits[4]++;
				}
				rawInput.add(line);
				n++;
			}
			maxLength[4] = actualMaxLength;
			for (int i = 0; i < 5; i++) {
				avgNumDig[i] = (int) (allDigits[i] / sizeOfPart[i]);
				int logBaseTwoOfSize = logBaseTwo(sizeOfPart[i]);
				chunkSize[i] = (avgNumDig[i] < logBaseTwoOfSize ? avgNumDig[i] : logBaseTwoOfSize);
				possibleVals[i] = (int) Math.pow(2, chunkSize[i]);
			}
			startIndex[0] = 0;
			cumulativeSizeOfPart[0] = sizeOfPart[0];
			for (int i = 1; i < 5; i++) {
				startIndex[i] = startIndex[i - 1] + sizeOfPart[i - 1];
				cumulativeSizeOfPart[i] = cumulativeSizeOfPart[i - 1] + sizeOfPart[i]; 
			}
			endIndex[4] = n - 1;
			for (int i = 0; i < 4; i++) {
				endIndex[i] = startIndex[i+1] - 1;
			}
//			int avgNumDigits = (int) (allDigits / n);
//			System.out.println("avgNumDigits: " + avgNumDigits);
//			int logBaseTwoOfN = logBaseTwo(n);
//			System.out.println("logBaseTwo of n: " + logBaseTwoOfN);
//			chunkSize = (avgNumDigits < logBaseTwoOfN ? avgNumDigits : logBaseTwoOfN);
//			System.out.println("chunkSize: " + chunkSize);
//			possibleVals = (int) Math.pow(2, chunkSize);
			
			
			
			
		}

//		sortThis = new BigBinary[n];
		sortThis = new String[n];
		Thread.sleep(10);
//		System.out.println("max digits: " + maxDigits);

		// The Algorithm
		long startTime = System.currentTimeMillis();
		
		
		
		for (int loop = 0; loop < numberOfLoops; loop++) {
			sortThis = rawInput.toArray(sortThis);
			Arrays.sort(sortThis, new StringComparator());
//	
//			// Fill sortThis with BigBinaries
//			for (int i = rawInput.size() - 1; i >= 0; i--) {
////				sortThis[i] = new BigBinary(rawInput.get(i));
//				int bucket = -1;
//				String current = rawInput.get(i);
////				if(current == null) {
////					System.out.println("ha"+current);
////				}
//				if (current.length() <= maxLength[0]) {
//					bucket = 0;
//				} else if (current.length() <= maxLength[1]) {
//					bucket = 1;
//				} else if (current.length() <= maxLength[2]) {
//					bucket = 2;
//				} else if (current.length() <= maxLength[3]) {
//					bucket = 3;
//				} else {
//					bucket = 4;
//				}
//				sortThis[cumulativeSizeOfPart[bucket] - 1] = new BigBinary(current);
////				if (sortThis[cumulativeSizeOfPart[bucket] - 1] == null) {
////					System.out.println("here: " + i);
////				}
//				cumulativeSizeOfPart[bucket]--;
//			}
//			System.out.println(maxLength[3]);
//			for (int zoo = 0; zoo < sortThis.length; zoo++){
//				if (sortThis[zoo] == null) {
//					System.out.println("lolol");
//					System.out.println(zoo);
//				}
//			}
//			
//			long afterCopy = System.currentTimeMillis();
//			System.out.println(afterCopy - startTime);
//			// radix sort alphabetically
////			for (int i = 0; i < actualMaxLength; i += chunkSize) {
////				int[] counts = new int[possibleVals];
////				for (int j = 0; j < sortThis.length; j++) {
////					counts[sortThis[j].getValBefore(i, chunkSize)]++;
////				}
////				for (int j = 1; j < possibleVals; j++) {
////					counts[j] += counts[j - 1]; 
////				}
////				BigBinary[] temp = new BigBinary[n];
////				for (int j = sortThis.length - 1; j >= 0; j--) {
////					temp[counts[sortThis[j].getValBefore(i, chunkSize)] - 1] = sortThis[j];
////					counts[sortThis[j].getValBefore(i, chunkSize)]--;
////				}
////				sortThis = temp;
////			}
//			
//			for (int partition = 0; partition < 5; partition++) {
//				radixSort(partition);
//			}
//			
//			long afterRadix = System.currentTimeMillis();
//			System.out.println(afterRadix - afterCopy);
//			// counting sort on sumOfOnes
//			int[] count = new int[actualMaxLength + 1]; // change to maxOnes + 1
//			for (int j = 0; j < sortThis.length; j++) {
//				count[sortThis[j].getSumOfOnes()]++;
//			}
//			for (int j = 1; j < count.length; j++) {
//				count[j] += count[j - 1]; 
//			}
//			BigBinary[] temp = new BigBinary[n];
//			for (int j = sortThis.length - 1; j >= 0; j--) {
//				temp[count[sortThis[j].getSumOfOnes()] - 1] = sortThis[j];
//				count[sortThis[j].getSumOfOnes()]--;
//			}
//			sortThis = temp;
//
//			long afterSumOfOnes = System.currentTimeMillis();
//			System.out.println(afterSumOfOnes - afterRadix);
//			// counting sort on length
//			int[] counts = new int[actualMaxLength + 1];
//			for (int j = 0; j < sortThis.length; j++) {
//				counts[sortThis[j].getLength()]++;
//			}
//			for (int j = 1; j < counts.length; j++) {
//				counts[j] += counts[j - 1]; 
//			}
//			BigBinary[] tempArray = new BigBinary[n];
//			for (int j = sortThis.length - 1; j >= 0; j--) {
//				tempArray[counts[sortThis[j].getLength()] - 1] = sortThis[j];
//				counts[sortThis[j].getLength()]--;
//			}
//			sortThis = tempArray;
//
//			long afterLengthSort = System.currentTimeMillis();
//			System.out.println(afterLengthSort - afterSumOfOnes);
//			
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);

		// Write out the results
		Path outFile = Paths.get(outputFile);
		try (BufferedWriter writer = Files.newBufferedWriter(outFile)) {
			for (String line : sortThis) {
//			for (BigBinary line : sortThis) { 
				writer.write(line.toString());
				writer.newLine();
			}
		}
	}
//
//	private static void radixSort(int bkt) {
//
////		for (int i = 0; i < actualMaxLength; i += chunkSize) {
////			int[] counts = new int[possibleVals];
////			for (int j = 0; j < sortThis.length; j++) {
////				counts[sortThis[j].getValBefore(i, chunkSize)]++;
////			}
////			for (int j = 1; j < possibleVals; j++) {
////				counts[j] += counts[j - 1]; 
////			}
////			BigBinary[] temp = new BigBinary[n];
////			for (int j = sortThis.length - 1; j >= 0; j--) {
////				temp[counts[sortThis[j].getValBefore(i, chunkSize)] - 1] = sortThis[j];
////				counts[sortThis[j].getValBefore(i, chunkSize)]--;
////			}
////			sortThis = temp;
////		for (int i = 0; i < maxLength[bkt]; i += chunkSize[bkt]) {
//			int i = 0;
//			int[] counts = new int[possibleVals[bkt]];
//			for (int j = startIndex[bkt]; j <= endIndex[bkt]; j++) {
//				BigBinary bigBinary = sortThis[j];
////				System.out.println(bigBinary);
//				int valBefore = bigBinary.getValBefore(i, chunkSize[bkt]);
//				counts[valBefore]++;
//			}
//			for (int j = 1; j < possibleVals[bkt]; j++) {
//				counts[j] += counts[j - 1];
//			}
//			BigBinary[] temp = new BigBinary[sizeOfPart[bkt]];
//			for (int j = endIndex[bkt]; j >= startIndex[bkt]; j--) {
//				int value = sortThis[j].getValBefore(i, chunkSize[bkt]);
//				temp[counts[value] - 1] = sortThis[j];
//				counts[value]--;
//			}
////		}
//	}

	private static int logBaseTwo(int value) {
		// Divides by natural log of 2
		return (int) (Math.log(value) / 0.6931471805599453);
	}
}
