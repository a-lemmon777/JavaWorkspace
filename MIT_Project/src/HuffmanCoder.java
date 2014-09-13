// Aaron Lemmon
// Inspiration drawn from: http://algs4.cs.princeton.edu/55compression/Huffman.java.html

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoder {

	private PriorityQueue<Node> queue = new PriorityQueue<Node>();
	private Map<Character, String> codeTable = new HashMap<Character, String>();
	private String treeString;
	private static final Double LOWER_BOUND = 99.895;
	private static final Double UPPER_BOUND = 100.015;

	public HuffmanCoder(Map<Character, Double> frequencies) {
		Double sumOfFrequencies = 0.0;
		for (Double frequency : frequencies.values()) {
			sumOfFrequencies += frequency;
		}
		if (LOWER_BOUND <= sumOfFrequencies && sumOfFrequencies <= UPPER_BOUND){
			// Make a new Node for each character and put them into the PriorityQueue
			for (Map.Entry<Character, Double> entry : frequencies.entrySet()) {
				queue.add(new Node(entry.getKey(), entry.getValue(), null, null));
			}
			
			// Handles the case where only a single character is provided
			if (queue.size() == 1) {
				queue.add(new Node('\1', 0.0, null, null));
			}
			
			// Construct a binary tree inside queue
			while (queue.size() > 1) {
				Node left = queue.poll();
				Node right = queue.poll();
				double combinedFrequency = left.getFrequency() + right.getFrequency();
				queue.add(new Node(null, combinedFrequency, left, right));
			}
			// Construct a code table (a Map of Characters and Strings containing the encoding for each character)
			buildCodeTable(codeTable , queue.peek(), "");
			// Construct a String representation of the binary tree
			treeString = makeTreeString(queue.peek());
		} else {
			throw new RuntimeException("Frequencies must add up to 100");
		}
	}

	private void buildCodeTable(Map<Character, String> codeTable, Node node, String encoding) {
		if (node.isLeaf()) {
			codeTable.put(node.getCharacter(), encoding);
		} else {
			buildCodeTable(codeTable, node.getLeft(), encoding + '0');
			buildCodeTable(codeTable, node.getRight(), encoding + '1');
		}
	}

	public Map<Character, String> getCodeTable() {
		return codeTable;
	}

	public String getTree() {
		return treeString;
	}

	private String makeTreeString(Node node) {
		String contents = "";
		if (node.isLeaf()) {
			contents += node.getCharacter();
		} else {
			contents += makeTreeString(node.getLeft()) + "+" + makeTreeString(node.getRight());
		}
		return "(" + node.getFrequency() + "," + contents + ")";
	}

	public String encode(String phrase) {
		String result = "";
		for (char character : phrase.toCharArray()) {
			if (codeTable.containsKey(character)) {
				result += codeTable.get(character);
			} else {
				result += "NO_ENCODING_FOUND";
			}
		}
		return result;
	}

	public String decode(String codedMessage) {
		String result = "";
		int i = 0;
		while (i < codedMessage.length()) {
			Node node = queue.peek();
			while (!node.isLeaf()) {
				if (codedMessage.charAt(i) == '0') {
					node = node.getLeft();
				} else {
					node = node.getRight();
				}
				i++;
			}
			result += node.getCharacter();
		}
		return result;
	}

}
