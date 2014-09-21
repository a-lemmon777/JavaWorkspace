import static org.junit.Assert.*;

import org.junit.Test;


public class IdentifierTests {

	@Test
	public void lettersUnderscoresDigitsDollarSigns() {
		int val__234$$$ = 5;
	}

	@Test
	public void numbers() {
		int val3 = 5;
	}
	@Test
	public void beinningUnderscores() {
		int ____val = 5;
	}	
	
	@Test (expected = Error.class)
	public void beinningNumber() {
		int 3val = 5;
	}
	
	@Test
	public void beginningDollarSigns() {
		int $$$val = 5;
	}
	
	@Test
	public void onlyOneDollarSign() {
		int $ = 5;
	}
	
	@Test (expected = Error.class)
	public void reservedKeyword() {
		int goto = 5;
	}
	
	@Test (expected = Error.class)
	public void specialCharacters() {
		int s#sd = 5;
	}
}
