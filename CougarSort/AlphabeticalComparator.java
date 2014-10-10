import java.util.Comparator;


public class AlphabeticalComparator implements Comparator<EnhancedString> {

	@Override
	public int compare(EnhancedString o1, EnhancedString o2) {
		return o1.binaryString.compareTo(o2.binaryString);
	}

}
