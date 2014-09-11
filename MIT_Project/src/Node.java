
public class Node {
	
	private final Character character;
	private final Double frequency;
	private final Node left;
	private final Node right;

	public Node(Character character, Double frequency, Node left, Node right) {
		this.character = character;
		this.frequency = frequency;
		this.left = left;
		this.right = right;
	}

}
