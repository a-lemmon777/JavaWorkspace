import java.util.Map;
import java.util.PriorityQueue;


public class HuffmanCoder {
	
	private PriorityQueue<Node> queue = new PriorityQueue<Node>();

	public HuffmanCoder(Map<Character, Double> frequencies) {
		for (Map.Entry<Character, Double> entry : frequencies.entrySet()) {
			queue.add(new Node(entry.getKey(), entry.getValue(), null, null));
		}
	}

	public Map<Character, String> getCodeTable() {
		return null;
	}

}
