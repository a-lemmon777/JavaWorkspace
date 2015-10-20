import java.util.Comparator;

public class LongDataComparator implements Comparator<LongData> {

	@Override
	public int compare(LongData value1, LongData value2) {
		return (value1.longValue < value2.longValue) ? -1 : ((value1.longValue == value2.longValue) ? 0 : 1);
	}
}
