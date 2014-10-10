
public class EnhancedString {
	
	public String binaryString;
	public int length;
	public int sumOfOnes;
	
	public EnhancedString(String bs) {
		binaryString = bs;
		length = bs.length();
		for (int i = 0; i < bs.length(); i++) {
			sumOfOnes += bs.charAt(i) - '0';
		}
	}
}
