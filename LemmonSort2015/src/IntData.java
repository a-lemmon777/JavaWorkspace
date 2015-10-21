public class IntData implements Comparable<IntData> {
	public String fullString;
	public int integerValue;

	public IntData(String input) {
		fullString = input;
		integerValue = (input.charAt(2) - 48) * 100000000 + (input.charAt(3) - 48) * 10000000 + (input.charAt(4) - 48) * 1000000 +
				(input.charAt(5) - 48) * 100000 + (input.charAt(6) - 48) * 10000 + (input.charAt(7) - 48) * 1000 + (input.charAt(8) - 48) * 100 +
				(input.charAt(9) - 48) * 10 + (input.charAt(10) - 48);
	}

	@Override
	public int compareTo(IntData value2) {
		// negative iff this should precede value2
		return this.integerValue - value2.integerValue;
	}
}