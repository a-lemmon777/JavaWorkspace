import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataHelper {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out
					.println("Please run with two command line arguments: input and output file names");
			System.exit(0);
		}

		String inputFileName = args[0];
		String outFileName = args[1];

		String[] toSort = readInData(inputFileName);
		
		try {
			PrintWriter out = new PrintWriter(outFileName);
			// Counting unique values
//			String AllDigits = toSort[0].substring(2);
//			int lastNewThing = 0;
//			for (int i = 0; i < toSort.length; i++) {
//				String digits = toSort[i].substring(2);
//				if (!digits.equals(AllDigits)) {
//					out.println((i - lastNewThing) + "\t" + AllDigits);
//					lastNewThing = i;
//					AllDigits = digits;
//				}
//			}
			// Counting groups by first 4 digits
			String firstFourDigits = toSort[0].substring(2, 6);
			int lastNewThing = 0;
			for (int i = 0; i < toSort.length; i++) {
				String digits = toSort[i].substring(2, 6);
				if (!digits.equals(firstFourDigits)) {
					out.println((i - lastNewThing) + "\t" + firstFourDigits);
					lastNewThing = i;
					firstFourDigits = digits;
				}
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

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
}
