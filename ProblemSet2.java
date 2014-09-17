// Aaron Lemmon
import java.util.Stack;
import java.util.Random;
import java.util.Arrays;

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
		
		// Setup for testing problem 2
		String[] articles = {"A", "The", "This", "That", "Her", "His"};
		String[] adjectives = {"green", "mean", "jolly", "tall"};
		String[] nouns = {"dog", "cat", "house", "bicycle"};
		String[] verbs = {"is jumping", "is dancing", "is reading", "is programming"};
		
		// Testing for problem 2
		System.out.println("Testing for problem 2 (output should be well-formed sentences):");
		System.out.println(randomSentence(articles, adjectives, nouns, verbs));
		System.out.println(randomSentence(articles, adjectives, nouns, verbs));
		System.out.println(randomSentence(articles, adjectives, nouns, verbs));
		
		// Testing for problem 3
		System.out.println("Testing for problem 3 (numbers should be highest near the center):");
		int[] distribution = diceRollDistribution();
		System.out.println(Arrays.toString(distribution));
			// Make sure all elements add up to 10000 rolls.
		int sum = 0;
		for (int i = 0; i < distribution.length; i++) {
			sum += distribution[i];
		}
		System.out.println(sum + " of 10000 rolls accounted for.");
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
		Random random = new Random();
		// These get and store a random String from each array
		String article = articles[random.nextInt(articles.length)];
		String adjective = adjectives[random.nextInt(adjectives.length)];
		String noun = nouns[random.nextInt(nouns.length)];
		String verb = verbs[random.nextInt(verbs.length)];
		
		return (article + " " + adjective + " " + noun + " " + verb + ".");	
	}
	
	static int[] diceRollDistribution() {
		Random random = new Random();
		int[] distribution = new int[11]; // Needs 11 spaces since dice rolls can be from 2 to 12 inclusive
		for (int i = 0; i < 10000; i++) {
			// Each die roll will be stored as an int from 0 to 5 to avoid unnecessary arithmetic
			int roll1 = random.nextInt(6);
			int roll2 = random.nextInt(6);
			// Index 0 will represent a real-life roll of 2 and so on...
			distribution[roll1 + roll2]++;
		}
		return distribution;	
	}
}