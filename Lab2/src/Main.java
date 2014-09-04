// Dalton Gusaas && Aaron Lemmon

import java.util.Arrays;
import java.util.Random;


public class Main {
	
	static TestInteger[] mergeArrayRandom = new TestInteger[10000];
	static TestInteger[] quickArrayRandom = new TestInteger[10000];
	static TestInteger[] mergeArraySorted = new TestInteger[10000];
	static TestInteger[] quickArraySorted = new TestInteger[10000];
	static TestInteger[] mergeArrayBigChunks = new TestInteger[10000];
	static TestInteger[] quickArrayBigChunks = new TestInteger[10000];
	static TestInteger[] mergeArraySmallChunks = new TestInteger[10000];
	static TestInteger[] quickArraySmallChunks = new TestInteger[10000];
	static Random rand = new Random();
	static int max = 1000000;
	static int min = 1;

	public static void main(String[] args) {
		fillupArrays();
		
		System.out.println();
		TestInteger.resetCounter();
		Arrays.sort(mergeArrayRandom, 0, 10000);
		System.out.print("mergeArrayRandom: " + TestInteger.getCounter());
		// System.out.println(Arrays.toString(mergeArrayRandom));
		System.out.println(", isSorted?: " + QuickSort.isSorted(mergeArrayRandom));
		TestInteger.resetCounter();
		QuickSort.sort(quickArrayRandom, 0, 9999);
		System.out.print("quickArrayRandom: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(quickArrayRandom));
		TestInteger.resetCounter();
		Arrays.sort(mergeArraySorted, 0, 10000);
		System.out.print("mergeArraySorted: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(mergeArraySorted));
		TestInteger.resetCounter();
		QuickSort.sort(quickArraySorted, 0, 9999);
		System.out.print("quickArraySorted: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(quickArraySorted));
		TestInteger.resetCounter();
		Arrays.sort(mergeArrayBigChunks, 0, 10000);
		System.out.print("mergeArrayBigChunks: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(mergeArrayBigChunks));
		TestInteger.resetCounter();
		QuickSort.sort(quickArrayBigChunks, 0, 9999);
		System.out.print("quickArrayBigChunks: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(quickArrayBigChunks));
		TestInteger.resetCounter();
		Arrays.sort(mergeArraySmallChunks, 0, 10000);
		System.out.print("mergeArraySmallChunks: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(mergeArraySmallChunks));
		TestInteger.resetCounter();
		QuickSort.sort(quickArraySmallChunks, 0, 9999);
		System.out.print("quickArraySmallChunks: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(quickArraySmallChunks));
		TestInteger.resetCounter();
		
		
	}

	private static void fillupArrays() {
		// Fills Randoms
		for (int i = 0; i < mergeArrayRandom.length; i++) {
			mergeArrayRandom[i] = new TestInteger(rand.nextInt(max - min) + min);
		}
		quickArrayRandom = mergeArrayRandom.clone();
		
		// Fills Sorteds
		mergeArraySorted = mergeArrayRandom.clone();
		Arrays.sort(mergeArraySorted);
		quickArraySorted = mergeArraySorted.clone();
		
		// Fills BigChunks
		mergeArrayBigChunks = mergeArrayRandom.clone();
		for (int i = 0; i < 10; i++) {
			int startIndex = i * 1000;
			QuickSort.sort(mergeArrayBigChunks, startIndex, startIndex + 999);
		}
		quickArrayBigChunks = mergeArrayBigChunks.clone();
		
		// Fills SmallChunks
		mergeArraySmallChunks = mergeArrayRandom.clone();
		for (int i = 0; i < 100; i++) {
			int startIndex = i * 100;
			QuickSort.sort(mergeArraySmallChunks, startIndex, startIndex + 99);
		}
		quickArraySmallChunks = mergeArraySmallChunks.clone();
	}
}
