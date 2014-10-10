// Dalton Gusaas && Aaron Lemmon

import java.util.Comparator;


public class LengthComparator implements Comparator<EnhancedString>{

	@Override
	public int compare(EnhancedString o1, EnhancedString o2) {
		return o1.binaryString.length() - o2.binaryString.length();
	}
}

