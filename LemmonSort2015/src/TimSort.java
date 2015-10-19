import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
//		Arrays.sort(data, new DataComparator());
//		for (int i = 0; i < toSort.length; i++) {
//			toSort[i] = data[i].fullString;
//		}
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
//		public String fullString;
		public int prefixValue;
//		public int integerValue;
//
		public Data(String input) {
//			fullString = input;
//			integerValue = new Integer(input.substring(2));
			prefixValue = (input.charAt(2) + input.charAt(3) + input.charAt(4) + input.charAt(5) + 8) % 10;
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
	}
}