// Dalton Gusaas && Aaron Lemmon

public class TestInteger implements Comparable<TestInteger> {
	private Integer value;
	
	private static long counter = 0;
	
	
	public TestInteger(int i) {
		value = i;
	}

	@Override
	public int compareTo(TestInteger other) {
		counter++;
		return value.compareTo(other.value);
	}
	
	public static void resetCounter() {
		counter = 0;
	}
	
	public static long getCounter() {
		return counter;
	}

	@Override
	public String toString() {
		return value.toString();
	}
	
	

}
