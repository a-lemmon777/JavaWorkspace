// Aaron Lemmon
import java.util.Stack;

public class ProblemSet2 {
	
	public static void main(String[] args) {
		// Setup for testing problem 1
		Stack<Integer> empty = new Stack<Integer>();
		Stack<Integer> anotherEmpty = new Stack<Integer>();
		Stack<Integer> stack3and4 = new Stack<Integer>();
		stack3and4.push(3);
		stack3and4.push(4);
		Stack<Integer> stack2and3and4 = new Stack<Integer>();
		stack2and3and4.push(2);
		stack2and3and4.push(3);
		stack2and3and4.push(4);
		Stack<Integer> anotherStack2and3and4 = new Stack<Integer>();
		anotherStack2and3and4.push(2);
		anotherStack2and3and4.push(3);
		anotherStack2and3and4.push(4);
		Stack<Integer> stack4and3and2 = new Stack<Integer>();
		stack4and3and2.push(4);
		stack4and3and2.push(3);
		stack4and3and2.push(2);
		
		// Testing for problem 1
		System.out.println("Testing for problem 1 (all should be true):");
		System.out.println(stacksEqual(empty, anotherEmpty));
		System.out.println(!stacksEqual(empty, stack3and4));
		System.out.println(!stacksEqual(stack3and4, empty));
		System.out.println(!stacksEqual(stack3and4, stack2and3and4)); // Makes sure the entire stacks are compared
		System.out.println(stacksEqual(stack2and3and4, anotherStack2and3and4));
		System.out.println(!stacksEqual(stack2and3and4, stack4and3and2)); // Makes sure that order matters
	}
	
	static boolean stacksEqual(Stack<Integer> firstStack, Stack<Integer> secondStack) {
		boolean areEqual;
		Stack<Integer> firstTemp = new Stack<Integer>();
		Stack<Integer> secondTemp = new Stack<Integer>();

		while (true) {
			if (firstStack.empty() != secondStack.empty()) {
				areEqual = false;
				break;
			} else if (firstStack.empty() && secondStack.empty()) {
				areEqual = true;
				break;
			} else if (firstStack.peek() != secondStack.peek()) { // At this point we're sure neither stack is empty
				areEqual = false;
				break;
			} else {
				firstTemp.push(firstStack.pop());
				secondTemp.push(secondStack.pop());
			}
		}
		// Fills firstStack with its original contents
		while (!firstTemp.empty()) {
			firstStack.push(firstTemp.pop());
		}
		// Fills secondStack with its original contents
		while (!secondTemp.empty()) {
			secondStack.push(secondTemp.pop());	
		}
		return areEqual;
	}
	
	static String randomSentence(String[] articles, String[] adjectives, String[] nouns, String[] verbs) {
		return "";	
	}
	
	static int[] diceRollDistribution() {
		return new int[1];	
	}
}