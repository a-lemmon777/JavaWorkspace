// Aaron Lemmon

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {	
		// Problem 2
		String phrase1 = "If you can't explain it simply, you don't understand it well enough.";
		String phrase2 = "Courage is what it takes to stand up and speak; courage is also what it "
				+ "takes to sit down and listen.";
		String phrase3 = "Success consists of going from failure to failure without loss of enthusiasm.";
		System.out.println("Problem 2:");
		System.out.println("Encoding for the first phrase:");
		System.out.println(EqualLengthCoder.encode(phrase1));
		System.out.println("Encoding for the second phrase:");
		System.out.println(EqualLengthCoder.encode(phrase2));
		System.out.println(EqualLengthCoder.encode(phrase3));
		System.out.println();
		
		// Problem 3
		String code1 = "1001010100000100001000100100101001000010011100110110010010001001010011100100111000101001100111001000011010011000101100010111001100001010000001000010111010010001001001001101110001010000001000010111010010001001001011001000100110011101110101001001101011011101001010010011100010100100011011001100111101001001001000000001001001100";
		System.out.println("Problem 3:");
		System.out.println("Decoding of the given code:");
		System.out.println(EqualLengthCoder.decode(code1));
		System.out.println();
		
		// Problem 7
		// First example
		Map<Character, Double> characterFrequenciesFirstExample = new HashMap<Character, Double>();
		double[] frequenciesFirstExample = new double[] {51, 22, 15, 7, 5};
		for (char letter = 'a'; letter <= 'e'; letter++) {
			characterFrequenciesFirstExample.put(letter, frequenciesFirstExample[letter - 'a']);
		}
		HuffmanCoder coderFirstExample = new HuffmanCoder(characterFrequenciesFirstExample);
		System.out.println("Problem 7:");
		System.out.println("Coding for first example:");
		System.out.println(coderFirstExample.getCodeTable());
		
		// Second example
		Map<Character, Double> characterFrequenciesSecondExample = new HashMap<Character, Double>();
		double[] frequenciesSecondExample = new double[] {25, 22, 18, 15, 11, 9};
		for (char letter = 'a'; letter <= 'f'; letter++) {
			characterFrequenciesSecondExample.put(letter, frequenciesSecondExample[letter - 'a']);
		}
		HuffmanCoder coderSecondExample = new HuffmanCoder(characterFrequenciesSecondExample);
		System.out.println("Coding for second example:");
		System.out.println(coderSecondExample.getCodeTable());
		
		// Entire alphabet
		Map<Character, Double> characterFrequencies = new HashMap<Character, Double>();
		double[] englishFrequencies = new double[] {8.55, 1.60, 3.16, 3.87, 12.10, 2.18, 2.09, 4.96, 7.33, 0.22, 0.81,
				4.21, 2.53, 7.17, 7.47, 2.07, 0.10, 6.33, 6.73, 8.94, 2.68, 1.06, 1.83, 0.19, 1.72, 0.11};
		for (char letter = 'a'; letter <= 'z'; letter++) {
			characterFrequencies.put(letter, englishFrequencies[letter - 'a']);
		}
		HuffmanCoder englishCoder = new HuffmanCoder(characterFrequencies);
		System.out.println("Coding for entire English alphabet:");
		System.out.println(englishCoder.getCodeTable());
		System.out.println();

		// Problem 8
		System.out.println("Problem 8:");
		String phrase4 = "iliketurtles";
		System.out.println("Encoding for \"iliketurtles\":");
		System.out.println(englishCoder.encode(phrase4));
		String code2 = "01011111100010011111100001100100110111011011100011011101";
		System.out.println("Decoding a mystery binary string " + "\"" + code2 + "\":");
		System.out.println(englishCoder.decode(code2));
	}
}
