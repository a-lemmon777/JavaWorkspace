// Aaron Lemmon
public class CountSubstrings {
	// Testing:
	// "This is a string" "is" -> 2
	// "aabbaaaba" "aa" -> 3
	// "Forgot second arg" -> Index out of bounds
	// nothing -> Index out of bounds
	// "soup" "souppppppp" -> 0
	public static void main(String[] args) {
		String myString = args[0];
		String substring = args[1];
		int count = 0;
		int nextIndexToCheck = 0;
		while (true) {
			nextIndexToCheck = myString.indexOf(substring, nextIndexToCheck);
			if (nextIndexToCheck == -1) {
				break;	
			}
			count++;
			nextIndexToCheck++;
		}
		System.out.println(count);
	}
}