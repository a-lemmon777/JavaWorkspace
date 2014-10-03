import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

// Dalton Gusaas && Aaron Lemmon

public class Group4 {
	private static String inputFile;
	private static String outputFile;
	private static int numberOfLoops;
	private static double lambda;
	private static int maxDigits = 0;
	private static ArrayList<String> rawInput = new ArrayList<String>();
	private static int n;
	private static String[] sortThis;

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
		sortThis = new String[n];
		Thread.sleep(1000);
		
		// The Algorithm
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < numberOfLoops; i++) {
			rawInput.toArray(sortThis); // Takes 0.557 ms for n=100,000
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
}
