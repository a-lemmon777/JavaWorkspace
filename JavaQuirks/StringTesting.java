import static org.junit.Assert.*;

import org.junit.Test;


public class StringTesting {

	String bestString;
	
	@Test (expected = Error.class)
	public void testUninitializedLocalString() {
		String thing;
		thing.trim(); //may not have been initialized.
	}
	
	@Test (expected = NullPointerException.class)
	public void testUninitializedFieldString() {
		bestString.trim(); // throws a null pointer exception
	}

}
