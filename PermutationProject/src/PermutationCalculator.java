import org.apache.commons.lang3.ArrayUtils;
import java.util.Arrays;

public class PermutationCalculator {

	private int[] temp;
	private int n;

	public PermutationCalculator(int n) {
		this.n = n;
		temp = new int[n];
	}

	public void printAllPermutations() {
		int[] base = new int[n];
		for (int i = 1; i <= n; i++) {
			base[i - 1] = i;
		}
		printPermutations(base);
	}

	// We used a function 'remove' below. It takes an array and an index, and returns a new copy of the given array but
	// with the specified index removed. Thus, the returned array is 1 shorter than the given array.
	private void printPermutations(int[] base) {
		if (base.length == 0) {
			Main.counter++;
			System.out.println(Arrays.toString(temp));
		} else {
			for (int i = 0; i < base.length; i++) {
				temp[n - base.length] = base[i];
				printPermutations(ArrayUtils.remove(base, i)); // The function remove is defined in an
			}												   // apache library, see above.
		}
	}
}
