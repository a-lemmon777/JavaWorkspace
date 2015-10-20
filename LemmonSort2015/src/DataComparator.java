import java.util.Comparator;

public class DataComparator implements Comparator<Data> {

	@Override
	public int compare(Data value1, Data value2) {
		int prefixDifference = value2.modValue - value1.modValue;
		if (prefixDifference != 0) {
			// negative iff value1 should precede value2
			return prefixDifference;
		}
		// negative iff value1 should precede value2
		return value1.integerValue - value2.integerValue;
	}
}
