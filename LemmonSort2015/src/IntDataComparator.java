import java.util.Comparator;

public class IntDataComparator implements Comparator<IntData> {

	@Override
	public int compare(IntData value1, IntData value2) {
		// negative iff value1 should precede value2
		return value1.integerValue - value2.integerValue;
	}
}
