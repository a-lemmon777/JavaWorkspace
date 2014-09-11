import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;


public class TestHuffmanCoder {
		//Map frequencies = new Map<Character, Integer>();
		//Fill it {(a,50), (b, 30), (c, 20)}
		
		//Map expectedCodeTable = new Map<Character, String>();
		// It should be {(a,"0"), (b, "10"), (c, "110")} or something
	@Test
	public void testMakeCodes() {
		// assertEquals(encodings, HuffmanCoder.makeCodeTable(frequencies));
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
