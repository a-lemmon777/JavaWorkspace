public class LongData implements Comparable<LongData> {
	public String fullString;
	public long longValue;

	public LongData(String input) {
		fullString = input;
		int prefixValue = (input.charAt(2) + input.charAt(3) + input.charAt(4) + input.charAt(5) + 8) % 10;
		longValue = (9 - prefixValue) * 1000000000L + (input.charAt(2) - 48) * 100000000 + (input.charAt(3) - 48) * 10000000 + (input.charAt(4) - 48) * 1000000 +
				(input.charAt(5) - 48) * 100000 + (input.charAt(6) - 48) * 10000 + (input.charAt(7) - 48) * 1000 + (input.charAt(8) - 48) * 100 +
				(input.charAt(9) - 48) * 10 + (input.charAt(10) - 48);			
	}

	@Override
	public int compareTo(LongData value2) {
		return (longValue < value2.longValue) ? -1 : ((longValue == value2.longValue) ? 0 : 1);
	}
}