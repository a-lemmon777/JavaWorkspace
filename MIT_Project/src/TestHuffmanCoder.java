import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;


public class TestHuffmanCoder {
		
	private Map<Character, Double> frequencies = new HashMap<Character, Double>();
	private Map<Character, String> expectedCodeTable = new HashMap<Character, String>();
	private String expectedTree = "(100.0,(40.0,(10.0,a)+(30.0,b))+(60.0,c))";

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
		System.out.println(coder.getCodeTable().get('a'));
		System.out.println(coder.getCodeTable().get('b'));
		System.out.println(coder.getCodeTable().get('c'));
		assertEquals(expectedCodeTable, coder.getCodeTable());
	}
	
	@Test
	public void testGetTree() {
		HuffmanCoder coder = new HuffmanCoder(frequencies);
		System.out.println(coder.getTree());
		assertEquals(expectedTree, coder.getTree());
		
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
