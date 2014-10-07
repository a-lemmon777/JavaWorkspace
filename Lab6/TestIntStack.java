
public class TestIntStack {

	public static void main(String[] args) {
		testPushAndPop();
		testToString();
		//testClear();
		
	}

	private static void testPushAndPop() {
		System.out.println("Testing push and pop (should print all true):");
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

	private static void testToString() {
		System.out.println("Testing toString() (should print all true)");
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
		IntStackInterface testStack = new IntStack();
		testStack.push(0);
		testStack.push(2);
		testStack.push(3);
		System.out.println();// need to write toString that doesn't suck
		testStack.clear();
		System.out.println();// need to write toString
	}
	
	
}
