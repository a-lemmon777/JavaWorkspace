import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoder {
	
	private PriorityQueue<Node> queue = new PriorityQueue<Node>();
	private Map<Character, String> codeTable = new HashMap<Character, String>();
	private String treeString;

	public HuffmanCoder(Map<Character, Double> frequencies) {
		// Make a new Node for each character and put them into the PriorityQueue
		for (Map.Entry<Character, Double> entry : frequencies.entrySet()) {
			queue.add(new Node(entry.getKey(), entry.getValue(), null, null));
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
		treeString = makeTreeString(queue.peek());
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

}
