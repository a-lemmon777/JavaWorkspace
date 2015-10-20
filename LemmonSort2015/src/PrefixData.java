//public class PrefixData implements Comparable<PrefixData> {
//	public String fullString;
//	public int modValue;
//	public int prefixValue;
//	public int prefixValue;
//
//	public PrefixData(String input) {
//		fullString = input;
//		modValue = (input.charAt(2) + input.charAt(3) + input.charAt(4) + input.charAt(5) + 8) % 10;
//		integerValue = (input.charAt(2) - 48) * 100000000 + (input.charAt(3) - 48) * 10000000 + (input.charAt(4) - 48) * 1000000 +
//				(input.charAt(5) - 48) * 100000 + (input.charAt(6) - 48) * 10000 + (input.charAt(7) - 48) * 1000 + (input.charAt(8) - 48) * 100 +
//				(input.charAt(9) - 48) * 10 + (input.charAt(10) - 48);
//	}
//
//	@Override
//	public int compareTo(PrefixData value2) {
//		int prefixDifference = value2.modValue - this.modValue;
//		if (prefixDifference != 0) {
//			// negative iff this should precede value2
//			return prefixDifference;
//		}
//		// negative iff this should precede value2
//		return this.integerValue - value2.integerValue;
//	}
//}