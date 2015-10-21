import java.util.Comparator;

public class ModDataComparator implements Comparator<ModData> {

	@Override
	public int compare(ModData value1, ModData value2) {
		// comparator for modValue and integerValue
		int prefixDifference = value2.modValue - value1.modValue;
		if (prefixDifference != 0) {
			// negative iff value1 should precede value2
			return prefixDifference;
		}
		// negative iff value1 should precede value2
		return value1.integerValue - value2.integerValue;
	}
}
