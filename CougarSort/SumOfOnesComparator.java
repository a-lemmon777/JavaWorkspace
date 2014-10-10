import java.util.Comparator;


public class SumOfOnesComparator implements Comparator<EnhancedString> {

	@Override
	public int compare(EnhancedString o1, EnhancedString o2) {
		return o1.sumOfOnes - o2.sumOfOnes;
	}

}
