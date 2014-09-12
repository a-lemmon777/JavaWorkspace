// Aaron Lemmon
public class ReverseString {
	// Testing:
	// "abcdefg" -> "gfedcba"
	// "racecar" -> "racecar"
	// "race car" -> "rac ecar"
	// "" -> ""
	// nothing -> Index out of bounds
	public static void main(String[] args) {
		String myString = args[0];
		for (int i = myString.length() - 1; i >= 0; i--) {
			System.out.print(myString.charAt(i));
		}
		System.out.println();
	}
}