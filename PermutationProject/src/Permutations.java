import java.util.ArrayList;
import java.util.List;

public class Permutations {
	private static List<Integer> temp = new ArrayList<Integer>();

	public static void main(String[] args) {
		int n = 5;
		List<Integer> base = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) { 
			base.add(i); //Fills the array with values from 1 to n
		}
		printPermutations(base);
	}

	private static void printPermutations(List<Integer> base) {
		if (base.size() == 0) {
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
}
