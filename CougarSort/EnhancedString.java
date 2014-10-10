
public class EnhancedString {
	
	public String binaryString;
	public int sumOfOnes;
	
	public EnhancedString(String bs) {
		binaryString = bs;
		for (int i = 0; i < bs.length(); i++) {
			sumOfOnes += bs.charAt(i) - '0';
		}
	}
}
