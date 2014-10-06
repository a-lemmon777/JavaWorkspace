// Dalton Gus
public class BigBinary {
	
	private int[] value;
	private int length;
	private int sumOfOnes;
	
	public BigBinary(String input) {
		length = input.length();
		int chunks = (int) Math.ceil(length / 32.0);
		value = new int[chunks];
		// Filling up value piece by piece.
		for (int i = chunks - 1; i >= 0; i--) {
			String subString = input.length() > 32 ? input.substring(input.length() - 32) : input;
			value[i] = Integer.parseUnsignedInt(subString, 2);
			input = input.substring(0, input.length() >= 32 ? input.length() - 32 : 0);
		}
		
		// Figure out sumOfOnes (inspiration from: http://www.toves.org/books/bitops/
		sumOfOnes = countOnes();
	}

	private int countOnes() {
		int result = 0;
		for (int i : value) {
			while (i != 0) {
				i &= i - 1;
				result++;
			}
		}
		return result;
	}

	public int[] getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	public int getSumOfOnes() {
		// TODO Auto-generated method stub
		return sumOfOnes;
	}
}
