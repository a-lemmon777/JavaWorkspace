import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TimSort {

	public static void main(String[] args) throws InterruptedException {
		if (args.length < 2) {
			System.out
			.println("Please run with two command line arguments: input and output file names");
			System.exit(0);
		}

		String inputFileName = args[0];
		String outFileName = args[1];

		String[] data = readInData(inputFileName);

		String [] toSort = data.clone();

		sort(toSort);  // JVM warmup

		toSort = data.clone();

		Thread.sleep(10); //to let other things finish before timing; adds stability of runs

		long start = System.currentTimeMillis();

		sort(toSort);

		long end = System.currentTimeMillis();

		System.out.println(end - start);

		writeOutResult(toSort, outFileName);
	}

	private static String[] readInData(String inputFileName) {
		ArrayList<String> input = new ArrayList<String>();
		Scanner in;
		try {
			in = new Scanner(new File(inputFileName));
			while (in.hasNext()) {
				input.add(in.next());
			}
			in.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// System.out.println(input);

		return input.toArray(new String[0]); // convert to array of strings
	}

	// YOUR SORTING METHOD GOES HERE: (you may call other methods and use other classes). 
	private static void sort(String[] toSort) {
		Data[] data = new Data[toSort.length];
		for (int i = 0; i < toSort.length; i++) {
			data[i] = new Data(toSort[i]);
		}
		Arrays.sort(data, new DataComparator());
		for (int i = 0; i < toSort.length; i++) {
			toSort[i] = data[i].fullString;
		}
	}

	private static void writeOutResult(String[] sorted, String outputFilename) {
		try {
			PrintWriter out = new PrintWriter(outputFilename);
			for (String str : sorted) {
				out.println(str);
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static class Data implements Comparable<Data> {
//		public static int[][][][] mods = new int[10][10][10][10];
		public String fullString;
//		public int prefixValue;
//		public int integerValue;
		public long longValue;
		//
		public Data(String input) {
			fullString = input;
//			int firstDigit = input.charAt(2);
//			int secondDigit = input.charAt(3);
//			int thirdDigit = input.charAt(4);
//			int fourthDigit = input.charAt(5);
			// using intValue
//			prefixValue = (firstDigit + secondDigit + thirdDigit + fourthDigit + 8) % 10;
//			integerValue = (firstDigit - 48) * 100000000 + (secondDigit - 48) * 10000000 + (thirdDigit - 48) * 1000000 +
//					(fourthDigit - 48) * 100000 + (input.charAt(6) - 48) * 10000 + (input.charAt(7) - 48) * 1000 + (input.charAt(8) - 48) * 100 +
//					(input.charAt(9) - 48) * 10 + (input.charAt(10) - 48);
//			prefixValue = (input.charAt(2) + input.charAt(3) + input.charAt(4) + input.charAt(5) + 8) % 10;
//			integerValue = (input.charAt(2) - 48) * 100000000 + (input.charAt(3) - 48) * 10000000 + (input.charAt(4) - 48) * 1000000 +
//					(input.charAt(5) - 48) * 100000 + (input.charAt(6) - 48) * 10000 + (input.charAt(7) - 48) * 1000 + (input.charAt(8) - 48) * 100 +
//					(input.charAt(9) - 48) * 10 + (input.charAt(10) - 48);
			
			// using longValue
//			int prefixValue = (firstDigit + secondDigit + thirdDigit + fourthDigit + 8) % 10;
//			longValue = (9 - prefixValue) * 1000000000L + (firstDigit - 48) * 100000000 + (secondDigit - 48) * 10000000 + (thirdDigit - 48) * 1000000 +
//					(fourthDigit - 48) * 100000 + (input.charAt(6) - 48) * 10000 + (input.charAt(7) - 48) * 1000 + (input.charAt(8) - 48) * 100 +
//					(input.charAt(9) - 48) * 10 + (input.charAt(10) - 48);
			int prefixValue = (input.charAt(2) + input.charAt(3) + input.charAt(4) + input.charAt(5) + 8) % 10;
			longValue = (9 - prefixValue) * 1000000000L + (input.charAt(2) - 48) * 100000000 + (input.charAt(3) - 48) * 10000000 + (input.charAt(4) - 48) * 1000000 +
					(input.charAt(5) - 48) * 100000 + (input.charAt(6) - 48) * 10000 + (input.charAt(7) - 48) * 1000 + (input.charAt(8) - 48) * 100 +
					(input.charAt(9) - 48) * 10 + (input.charAt(10) - 48);
			
			
//			prefixValue = (input.charAt(2) + input.charAt(3) + input.charAt(4) + input.charAt(5) + 8) % 10;
//			prefixValue = getMod(input.charAt(2) - 48, input.charAt(2) - 48, input.charAt(2) - 48, input.charAt(2) - 48);
			
			// old stuff
//			integerValue = new Integer(input.substring(2));
//			integerValue = Integer.valueOf(input.substring(2));
//			integerValue = Integer.parseInt(input.substring(2));
//			integerValue = getIntegerValue(input);

			// factor out most of the -48s, except first one since that would cause out of range to occur.
//			integerValue = (input.charAt(2) - 48) * 100000000 + input.charAt(3) * 10000000 + input.charAt(4) * 1000000 +
//					input.charAt(5) * 100000 + input.charAt(6) * 10000 + input.charAt(7) * 1000 + input.charAt(8) * 100 +
//					input.charAt(9) * 10 + input.charAt(10) - 533333328;
			//			prefixValue = (new Integer(input.charAt(2)) + new Integer(input.charAt(3)) + new Integer(input.charAt(4)) + new Integer(input.charAt(5))) % 10;
			//			prefixValue = (new Integer(input.substring(2, 3)) + new Integer(input.substring(3, 4)) + new Integer(input.substring(4, 5)) + new Integer(input.substring(5, 6))) % 10;
		}

		@Override
		public int compareTo(Data value2) {
			return -1;
			//			int prefixDifference = value2.prefixValue - this.prefixValue;
			//			if (prefixDifference != 0) {
			//				// negative iff this should precede value2
			//				return prefixDifference;
			//			}
			//			// negative iff this should precede value2
			//			return this.integerValue - value2.integerValue;
		}
		
//		private static int getMod(int first, int second, int third, int fourth) {
//			int storedVal = mods[first][second][third][fourth];
//			// if the value hasn't been calculated yet
//			if (storedVal == 0) {
//				int newValue = (first + second + third + fourth % 10);
//				mods[first][second][third][fourth] = newValue + 1;
//				return newValue;
//			}
//			return storedVal - 1;
//		}


	}

	public static class DataComparator implements Comparator<Data> {

		@Override
		public int compare(Data value1, Data value2) {
			// comparator for prefix and value
//			int prefixDifference = value2.prefixValue - value1.prefixValue;
//			if (prefixDifference != 0) {
//				// negative iff value1 should precede value2
//				return prefixDifference;
//			}
//			// negative iff value1 should precede value2
//			return value1.integerValue - value2.integerValue;
			
			
			// comparator for just longValue
//			// negative iff value1 should precede value2
			return (value1.longValue < value2.longValue) ? -1 : ((value1.longValue == value2.longValue) ? 0 : 1);
			
//			return -1;
		}
	}
}