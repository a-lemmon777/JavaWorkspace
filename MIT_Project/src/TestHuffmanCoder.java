import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;


public class TestHuffmanCoder {
		
	private Map<Character, Double> frequencies = new HashMap<Character, Double>();
	private Map<Character, String> expectedCodeTable = new HashMap<Character, String>();

	@Before
	public void setUp() {
		frequencies.put('a', 10.0);
		frequencies.put('b', 30.0);
		frequencies.put('c', 60.0);
		expectedCodeTable.put('a', "00");
		expectedCodeTable.put('b', "01");
		expectedCodeTable.put('c', "1");
	}
	
	@Test
	public void testGetCodeTable() {
		HuffmanCoder coder = new HuffmanCoder(frequencies);
		assertEquals(expectedCodeTable, coder.getCodeTable());
	}
	
	@Test
	public void testEncode() {
		// Map encoding = HuffmanCoder.makeCodes(frequencies);
		// String phrase = "I like turtles.";
		// assertEquals("010101010101", HuffmanCoder.encode(encoding, phrase);
	}
	
	@Test
	public void testDecode() {
		// Map encoding = HuffmanCoder.makeCodes(frequencies);
		// String codedMessage = "010101010101";
		// assertEquals("I like turtles", HuffmanCoder.decode(encoding, codedMessage);
	}

}
