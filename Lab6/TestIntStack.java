import java.util.EmptyStackException;

// Aaron Lemmon && Lenny Scott

public class TestIntStack {

	public static void main(String[] args) {
		testPushAndPop();
		testPopOnEmptyStack();
		testToString();
		testClear();
		testEmpty();
		testPeek();
		testPeekOnEmptyStack();
		testSize();
		//testInvert();
	}

	private static void testPushAndPop() {
		System.out.println("Testing push() and pop() (should print all true):");
		IntStackInterface testStack = new IntStack();
		
		// Testing push and pop
		testStack.push(5);
		System.out.println(testStack.pop() == 5);
		
		// Testing that popping returns the most recently pushed item.
		testStack = new IntStack();
		testStack.push(1);
		testStack.push(2);
		System.out.println(testStack.pop() == 2);
		System.out.println(testStack.pop() == 1);
		
		// Will test exceptions here:
		
	}
	
	private static void testPopOnEmptyStack() {
		System.out.println("Testing that popping an empty stack throws an EmptyStackException (should print all true):");
		IntStackInterface testStack = new IntStack();
		try {
			testStack.pop();
			System.out.println(false);
		} catch (EmptyStackException e) {
			System.out.println(true);
		}
	}

	private static void testToString() {
		System.out.println("Testing toString() (should print all true):");
		// toString of an empty intStack (should print [])
		IntStackInterface testStack = new IntStack();
		System.out.println(testStack.toString().equals("[]"));
		// toString of a intStack with elements
		testStack = new IntStack();
		testStack.push(1);
		testStack.push(2);
		testStack.push(3);
		System.out.println(testStack.toString().equals("[1, 2, 3]"));
	}

	private static void testClear() {
		System.out.println("Testing clear() (should print all true):");
		// testing that clear() works on empty stacks
		IntStackInterface testStack = new IntStack();
		System.out.println("[]".equals(testStack.toString()));
		testStack.clear();
		System.out.println("[]".equals(testStack.toString()));
		
		// testing that clear() actually clears all values
		testStack = new IntStack();
		testStack.push(0);
		testStack.push(2);
		testStack.push(3);
		System.out.println("[0, 2, 3]".equals(testStack.toString()));
		testStack.clear();
		System.out.println("[]".equals(testStack.toString()));
	}

	private static void testEmpty() {
		System.out.println("Testing empty() (should print all true):");
		// testing that empty() returns true on empty stacks
		IntStackInterface testStack = new IntStack();
		System.out.println(testStack.empty());
		// testing that empty() returns false on non-empty stacks
		testStack = new IntStack();
		testStack.push(15);
		testStack.push(45);
		System.out.println(!testStack.empty());
	}
	
	private static void testPeek() {
		System.out.println("Testing peek() (should print all true):");
		// testing that peek() returns the top element without removing it.
		IntStackInterface testStack = new IntStack();
		testStack.push(34);
		testStack.push(17);
		testStack.push(87);
		System.out.println(87 == testStack.peek());
		System.out.println("[34, 17, 87]".equals(testStack.toString())); // makes sure the peeked element wasn't removed.
	}
	
	private static void testPeekOnEmptyStack() {
		System.out.println("Testing peek() on empty stack throws EmptyStackException (should print all true):");
		IntStackInterface testStack = new IntStack();
		try {
			testStack.peek();
			System.out.println(false);
		} catch (EmptyStackException e) {
			System.out.println(true);
		}
	}
	
	private static void testSize() {
		System.out.println("Testing size() (should print all true):");
		// should return 0 for an empty stack
		IntStackInterface testStack = new IntStack();
		System.out.println(0 == testStack.size());
		// should return the number of elements of a non-empty stack
		testStack = new IntStack();
		testStack.push(8);
		testStack.push(13);
		testStack.push(9);
		System.out.println(3 == testStack.size());
	}
	
	private static void testInvert() {
		System.out.println("Testing size() (should print all true):");
		// if invert() is called on an empty stack, should return an empty stack
		IntStackInterface testStack = new IntStack();
		System.out.println("[]".equals(testStack.invert()));
		// if invert() is called on a stack with size one, should return a stack with same element
		// if invert() is called on a stack with multiple elements, should return a stack with the elements in reverse order
	}
}
