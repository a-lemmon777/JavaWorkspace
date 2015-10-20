
public class Testing {
	public static void main(String[] args) {
		String input = "0.123456789";
		int prefixValue = (input.charAt(2) + input.charAt(3) + input.charAt(4) + input.charAt(5) + 8) % 10;
		System.out.println(prefixValue);
		long longValue = (9 - prefixValue) * 1000000000L + input.charAt(2) * 100000000L + input.charAt(3) * 10000000L + input.charAt(4) * 1000000L +
				input.charAt(5) * 100000L + input.charAt(6) * 10000L + input.charAt(7) * 1000L + input.charAt(8) * 100L +
				input.charAt(9) * 10L + input.charAt(10) - 5333333328L;
		System.out.println((9 - prefixValue) * 1000000000L + input.charAt(2) * 100000000L);
		System.out.println(longValue);
	}
}
