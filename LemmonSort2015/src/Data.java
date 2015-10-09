public class Data implements Comparable<Data> {
	public String fullString;
	public int prefixValue;
	public int integerValue;

	public Data(String input) {
		fullString = input;
		integerValue = new Integer(input.substring(2));
		prefixValue = (new Integer(input.substring(2, 3)) + new Integer(input.substring(3, 4)) + new Integer(input.substring(4, 5)) + new Integer(input.substring(5, 6))) % 10;
	}

	@Override
	public int compareTo(Data value2) {
		int prefixDifference = value2.prefixValue - this.prefixValue;
		if (prefixDifference != 0) {
			// negative iff this should precede value2
			return prefixDifference;
		}
		// negative iff this should precede value2
		return this.integerValue - value2.integerValue;
	}
}