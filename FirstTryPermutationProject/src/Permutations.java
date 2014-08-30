import java.util.ArrayList;
import java.util.List;

public class Permutations {
	private static List<Integer> temp = new ArrayList<Integer>();
	private static int counter = 0;
	
	public static void main(String[] args) {
		int n = 7;
		List<Integer> base = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) { 
			base.add(i); //Fills the array with values from 1 to n
		}
		
		long timeBefore = System.currentTimeMillis();
		printPermutations(base);
		long timeAfter = System.currentTimeMillis();
		
		long total = timeAfter - timeBefore;
		if (total < 1000) {
			System.out.println("Time to compute: " + total + "ms");
		} else {
			System.out.println("Time to compute: " + (total/1000.0) + "s");
		}
		
		System.out.println("Calculated " + counter + " permutations.");
		System.out.println("There should be " + factorial(n) + " permutations.");
		
	}

	private static void printPermutations(List<Integer> base) {
		if (base.size() == 0) {
			counter++;
			System.out.println(temp);
		} else {
			for (Integer i : base) {
				temp.add(i);
				int indexOfi = base.indexOf(i);
				List<Integer> restOfBase = new ArrayList<Integer>();
				restOfBase.addAll(base.subList(0, indexOfi));
				restOfBase.addAll(base.subList(indexOfi + 1, base.size()));
				printPermutations(restOfBase);
				temp.remove((Integer) i);
			}
		}
	}
	
	public static int factorial(int number){
		if (number == 1) {
			return 1;
		} else {
			return (number * factorial(number - 1));
		}
	}

}
