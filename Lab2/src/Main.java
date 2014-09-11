// Dalton Gusaas && Aaron Lemmon

import java.util.Arrays;
import java.util.Random;


public class Main {
	
	static TestInteger[] arrayRandom = new TestInteger[10000];
	static TestInteger[] arraySorted = new TestInteger[10000];
	static TestInteger[] arrayBigChunks = new TestInteger[10000];
	static TestInteger[] arraySmallChunks = new TestInteger[10000];
	
	
	static Random rand = new Random();
	static int max = 1000000;
	static int min = 1;

	public static void main(String[] args) {
		fillupArrays();
		TestInteger.resetCounter();
		TestInteger[] testArray;
		
		//testing
//		testArray = arrayRandom.clone();
//		HybridQuickSort.insertionSort(testArray);
//		System.out.println(Arrays.toString(testArray));
//		System.out.println(TestInteger.getCounter());
//		System.out.println(QuickSort.isSorted(testArray));
//		TestInteger.resetCounter();
		
		testArray = arrayRandom.clone();
		TestInteger.resetCounter();
		Arrays.sort(testArray, 0, 10000);
		System.out.print("MergeSort on random array: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();
		
		testArray = arrayRandom.clone();
		QuickSort.sort(testArray, 0, 9999);
		System.out.print("QuickSort on random array: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();
		
		testArray = arrayRandom.clone();
		RandomQuickSort.sort(testArray, 0, 9999);
		System.out.print("RandomQuickSort on random array: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();
		
		testArray = arrayRandom.clone();
		ThreePivotQuickSort.sort(testArray, 0, 9999);
		System.out.print("ThreePivotQuickSort on random array: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();
		
		testArray = arrayRandom.clone();
		HybridQuickSort.sort(testArray, 0, 9999);
		//System.out.println(Arrays.toString(testArray));
		System.out.print("HybridQuickSort on random array: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();
		
		testArray = arraySorted.clone();
		Arrays.sort(testArray, 0, 10000);
		System.out.print("MergeSort on sorted array: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();
		
		testArray = arraySorted.clone();
		QuickSort.sort(testArray, 0, 9999);
		System.out.print("QuickSort on sorted array: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();
		
		testArray = arraySorted.clone();
		RandomQuickSort.sort(testArray, 0, 9999);
		System.out.print("RandomQuickSort on sorted array: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();

		testArray = arraySorted.clone();
		ThreePivotQuickSort.sort(testArray, 0, 9999);
		System.out.print("ThreePivotQuickSort on sorted array: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();

		testArray = arraySorted.clone();
		HybridQuickSort.sort(testArray, 0, 9999);
		//System.out.println(Arrays.toString(testArray));
		System.out.print("HybridQuickSort on sorted array: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();
		
		testArray = arrayBigChunks.clone();
		Arrays.sort(testArray, 0, 10000);
		System.out.print("MergeSort on array with big chunks: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();
		
		testArray = arrayBigChunks.clone();
		QuickSort.sort(testArray, 0, 9999);
		System.out.print("QuickSort on array with big chunks: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();
		
		testArray = arrayBigChunks.clone();
		RandomQuickSort.sort(testArray, 0, 9999);
		System.out.print("RandomQuickSort on array with big chunks: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();

		testArray = arrayBigChunks.clone();
		ThreePivotQuickSort.sort(testArray, 0, 9999);
		System.out.print("ThreePivotQuickSort on array with big chunks: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();

		testArray = arrayBigChunks.clone();
		HybridQuickSort.sort(testArray, 0, 9999);
		System.out.print("HybridQuickSort on array with big chunks: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();
		
		testArray = arraySmallChunks.clone();
		Arrays.sort(testArray, 0, 10000);
		System.out.print("MergeSort on array with small chunks: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();
		
		testArray = arraySmallChunks.clone();
		QuickSort.sort(testArray, 0, 9999);
		System.out.print("QuickSort on array with small chunks: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();
		
		testArray = arraySmallChunks.clone();
		RandomQuickSort.sort(testArray, 0, 9999);
		System.out.print("RandomQuickSort on array with small chunks: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();

		testArray = arraySmallChunks.clone();
		ThreePivotQuickSort.sort(testArray, 0, 9999);
		System.out.print("ThreePivotQuickSort on array with small chunks: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();

		testArray = arraySmallChunks.clone();
		HybridQuickSort.sort(testArray, 0, 9999);
		System.out.print("HybridQuickSort on array with small chunks: " + TestInteger.getCounter());
		System.out.println(", isSorted?: " + QuickSort.isSorted(testArray));
		TestInteger.resetCounter();
	}

	private static void fillupArrays() {
		// Fills arrayRandom
		for (int i = 0; i < arrayRandom.length; i++) {
			arrayRandom[i] = new TestInteger(rand.nextInt(max - min + 1) + min);
		}
		
		// Fills arraySorted
		arraySorted = arrayRandom.clone();
		Arrays.sort(arraySorted);
		
		// Fills arrayBigChunks
		arrayBigChunks = arrayRandom.clone();
		for (int i = 0; i < 10; i++) {
			int startIndex = i * 1000;
			QuickSort.sort(arrayBigChunks, startIndex, startIndex + 999);
		}
		
		// Fills arraySmallChunks
		arraySmallChunks = arrayRandom.clone();
		for (int i = 0; i < 100; i++) {
			int startIndex = i * 100;
			QuickSort.sort(arraySmallChunks, startIndex, startIndex + 99);
		}
	}
}
