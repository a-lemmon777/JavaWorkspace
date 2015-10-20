import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class FewBuckets {

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
		@SuppressWarnings("unchecked")
		ArrayList<Data>[] buckets = (ArrayList<Data>[]) new ArrayList[10];
		int bucketStartSize = toSort.length / 5;
		for (int i = 0; i < 10; i++) {
			// make buckets pretty big
			buckets[i] = new ArrayList<Data>(bucketStartSize);
		}
		int toSortLength = toSort.length;
		
		// fill buckets
		for (int i = 0; i < toSortLength; i++) {
			String input = toSort[i];
			buckets[(input.charAt(2) + input.charAt(3) + input.charAt(4) + input.charAt(5) + 8) % 10].add(new Data(input));
		}
		
		// sort buckets
		DataComparator comparator = new DataComparator();
		for (int i = 0; i < 10; i++) {
			buckets[i].sort(comparator);
		}
		
		// copy back to input array
		int index = 0;
		for (int i = 9; i >= 0; i--) {
			ArrayList<Data> bucket = buckets[i];
			int bucketSize = bucket.size();
			for (int j = 0; j < bucketSize; j++) {
				toSort[index++] = bucket.get(j).fullString;
			}
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
	
	private static class Data {
		public String fullString;
		public int integerValue;
		
		public Data(String input) {
			fullString = input;
			integerValue = (input.charAt(2) - 48) * 100000000 + (input.charAt(3) - 48) * 10000000 + (input.charAt(4) - 48) * 1000000 +
					(input.charAt(5) - 48) * 100000 + (input.charAt(6) - 48) * 10000 + (input.charAt(7) - 48) * 1000 + (input.charAt(8) - 48) * 100 +
					(input.charAt(9) - 48) * 10 + (input.charAt(10) - 48);
		}
	}
	
	public static class DataComparator implements Comparator<Data> {

		@Override
		public int compare(Data value1, Data value2) {
			// negative iff value1 should precede value2
			return value1.integerValue - value2.integerValue;
		}
	}
}