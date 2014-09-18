// Jacob Opdahl && Aaron Lemmon 
// Algorithms Lab 4

// Algorithm explained in comments above packBins() method.

// ************Testing************
// Input: 20 8 12 4 8 15 9 3 1 10
// Output: 
//Bin 1 space used: 20
//Bin 1 items: [15, 4, 1]
//Bin 2 space used: 20
//Bin 2 items: [12, 8]
//Bin 3 space used: 19
//Bin 3 items: [10, 9]
//Not packed items: [3]
//Total amount of unused space: 1

// Input: 20 7 12 4 8 15 9 1 10
// Output: 
//Bin 1 space used: 20
//Bin 1 items: [15, 4, 1]
//Bin 2 space used: 20
//Bin 2 items: [12, 8]
//Bin 3 space used: 19
//Bin 3 items: [10, 9]
//Not packed items: []
//Total amount of unused space: 1

// Input: 90 20 15 17 4 26 63 20 20 11 14 1 9 30 18 6 32 4 4 40 1 6
// Output:
//Bin 1 space used: 89
//Bin 1 items: [63, 20, 6]
//Bin 2 space used: 89
//Bin 2 items: [40, 26, 18, 4, 1]
//Bin 3 space used: 89
//Bin 3 items: [32, 30, 20, 6, 1]
//Not packed items: [4, 4, 9, 11, 14, 15, 17]
//Total amount of unused space: 3

//#######################################
//### Example of Non-optimal solution ###
//#######################################
// Input: 20 9 11 11 11 10 10 10 10 10 10
// Output:
//Bin 1 space used: 11
//Bin 1 items: [11]
//Bin 2 space used: 11
//Bin 2 items: [11]
//Bin 3 space used: 11
//Bin 3 items: [11]
//Not packed items: [10, 10, 10, 10, 10, 10]
//Total amount of unused space: 27 
// As seen above, the unused space is 27. However,
// an optimal solution would've packed two 10s into
// each bin, which would leave no unused space.

//-=-=-=-=-=-=-SUMMARY OF OPTIMAL AND NON-OPTIMAL SOLUTIONS-=-=-=-=-=-=-=-
// Our algorithm finds the optimal solution when the optimal solution includes
// the largest numbers in packingNumbers.
// Using that knowledge, we were able to construct a non-optimal solution by
// making a set of numbers where the largest numbers should not be included 
// in the optimal solution. 
// In general for cases like the one mentioned above, our algorithm will produce 
// a non-optimal solution because the large numbers will be packed immediately,
// taking up space that would've went to the optimal choices.

// EXTRA CREDIT
// We assumed the maximal difference between our solution and the optimal one must occur
// when the optimal one has no unused space. Our algorithm performs poorly when the data set includes
// three numbers equaling ceiling(n/2)+1 along with other numbers based on if the bin size is even or odd. 
// For even bin sizes, the data set also includes six numbers equal to (n/2). For odd bin sizes, the 
// data set also includes 3 numbers equal to ceiling(n/2) and 3 numbers equal to ceiling(n/2)-1. For example,
// see our non-optimal solution above.
// Knowing this will produce maximal non-optimal solutions, we developed a formula to find the percentage of
// unused space. We do this since we assume that optimal fills up all the space. The formula we arrived at is:
// [3*n-(3*(ceiling(n/2)+1))]/(3*n)  *Where n is the size of a single bin.
// This ratio becomes larger as n increases. As n goes to infinity, the ratio approaches 50%, meaning that we approach 50%
// of available bin space being unused. Since we assumed the optimal fills the bins entirely, the maximal difference between
// our solution and the optimal one is 50% of total space.

// Big-O analysis
// Our algorithm starts with an optimized merge-sort, which runs in n*log(n) time. (See link below)
// We have a while loop that will run n times in the worst case (every number gets put in a bin).
// getEmptiestBin() is called n-1 times total from within the while loop. Since the operations in it all run
// in constant time, each time it is called it contributes a constant. So the total of all calls to getEmptiestBin()
// will run in constant*(n-1) time. 
// Throughout the loop there are several operations that run in constant time. Because the body of the while loop
// runs n-1 times (in the worst case), these will contribute constant*(n-1) each.
// The binary search we use has a worst-case running time of log(n). Since it's within the while loop, it will execute
// a total of (n-1) times. Thus, it contributes (n-1)*log(n) time, which is in O(n*log(n)).
// The next significant line is the one which uses ArrayList.remove(). This is within the while loop and in the worst case
// contributes n operations per iteration, so it contributes n*(n-1) time in total.
// Adding these all up, the dominant term will be n*(n-1) (from ArrayList.remove()). Therefore the efficiency of our 
// algorithm is in O(n^2).

// http://docs.oracle.com/javase/tutorial/collections/algorithms/index.html (mergesort)
// http://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist/322742#322742 (ArrayList.remove)

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class BinProblem {
	
	// We declare our bins and whatnot as fields so the methods don't all require
	// a bunch of arguments.
	private static int binSize;
	private static int numberOfItems;
	private static ArrayList<Integer> packingNumbers;
	private static ArrayList<Integer> bin1 = new ArrayList<Integer>();
	private static ArrayList<Integer> bin2 = new ArrayList<Integer>();
	private static ArrayList<Integer> bin3 = new ArrayList<Integer>();


	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter the bin size, followed by the number of items, "
				+ "and then the items themselves (separated by spaces).");
		
		// First number is bin size.
		binSize = scanner.nextInt();
		// Second number is number of items.
		numberOfItems = scanner.nextInt();
		// Used to store items to be packed.
		packingNumbers = new ArrayList<Integer>();
		
		// Reads the rest of the input.
		for (int i = 0; i < numberOfItems; ++i) {
			packingNumbers.add(scanner.nextInt());
		}
			
		scanner.close();
		
		// The index 0 will be reserved to hold the current sum of all other items in the ArrayList
		bin1.add(0);
		bin2.add(0);
		bin3.add(0);
		
		// All the "work" is done here.
		packBins();
		
		// Information formatting for feedback/results.
		int unusedSpace = (binSize * 3) - bin1.get(0) - bin2.get(0) - bin3.get(0);
		int bin1Sum = bin1.remove(0);
		int bin2Sum = bin2.remove(0);
		int bin3Sum = bin3.remove(0);
		
		System.out.println("Bin 1 space used: " + bin1Sum);
		System.out.println("Bin 1 items: " + bin1);
		System.out.println("Bin 2 space used: " + bin2Sum);
		System.out.println("Bin 2 items: " + bin2);
		System.out.println("Bin 3 space used: " + bin3Sum);
		System.out.println("Bin 3 items: " + bin3);
		System.out.println("Not packed items: " + packingNumbers);
		System.out.println("Total amount of unused space: " + unusedSpace);
		
	}
	
	// Used to solve a bin-packing problem.
	// Explanation of Algorithm:
	// Starts by sorting the packingNumbers so binarySearch can be used.
	// Finds the emptiest bin by comparing their sums, which are stored
	// at index 0. Calculates the remaining space of the emptiest bin found.
	// Uses binarySearch to find the largest number in packingNumbers <= remaining space.
	// Moves the item from packingNumbers to the bin, and adds its value to the sum
	// at index 0.
	private static void packBins() {
		
		// Required to use binarySearch() method.
		packingNumbers.sort(null);
		
		int i = 0;
		
		while (i  < numberOfItems) {
			
			ArrayList<Integer> emptiestBin = getEmptiestBin();
			int remainingSpace = binSize - emptiestBin.get(0);
			
			// refer to http://docs.oracle.com/javase/tutorial/collections/algorithms/index.html
			int position = Collections.binarySearch(packingNumbers, remainingSpace);
			// converts "not-found" negative indices to a positive index of the largest value less than remainingSpace.
			if (position == -1) {
				return;
			}
			if (position < -1) {
				position = -(position + 2);
			}
			
			int itemToAdd = packingNumbers.remove(position);
			emptiestBin.add(itemToAdd);
			// Updates the current sum, which is being stored at index 0.
			emptiestBin.set(0, itemToAdd + emptiestBin.get(0));
			
			i++;
		}
	}


	// Based on the sum at index 0, we find the bin that is
	// the "emptiest."
	private static ArrayList<Integer> getEmptiestBin() {
		
		if ((bin1.get(0) <= bin2.get(0)) && bin1.get(0) <= bin3.get(0)) {
			return bin1;
		}
		
		if (bin2.get(0) <= bin3.get(0)) {
			return bin2;
		}
		
		return bin3;
	}
	
}
