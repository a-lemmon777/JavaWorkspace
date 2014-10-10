import java.util.Comparator;


public class LengthAndSumComparator implements Comparator<EnhancedString> {

	@Override
	public int compare(EnhancedString o1, EnhancedString o2) {
		int lengthDifference = o1.length - o2.length;
		if (lengthDifference != 0) {
			return lengthDifference;
		}
		return o1.sumOfOnes - o2.sumOfOnes;
	}

}
