
public class Node implements Comparable<Node>{
	
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

	public double getFrequency() {
		return frequency;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public boolean isLeaf() {
		return (left == null && right == null);
	}

	public char getCharacter() {
		return character;
	}

	@Override
	public int compareTo(Node otherNode) {
		if (frequency == otherNode.frequency) {
			return getLeftMostLetter().compareTo(otherNode.getLeftMostLetter());
		} else {
			return frequency.compareTo(otherNode.frequency);
		}
	}

	private Character getLeftMostLetter() {
		if (isLeaf()) {
			return character;
		} else {
			return left.getLeftMostLetter();
		}
	}

}
