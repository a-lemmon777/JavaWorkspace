// Aaron Lemmon

import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;

public class TakeHomeOne {
	public static void main(String[] args) {
		/* Testing for listIntersection() */
		System.out.println("Testing listIntersection(), all lines should print true:");
		
		// Edge case where both inputs are empty
		ArrayList<Integer> input1 = new ArrayList<Integer>();
		ArrayList<Integer> input2 = new ArrayList<Integer>();
		ArrayList<Integer> expectedResult = new ArrayList<Integer>();
		ArrayList<Integer> input1AfterSideEffects = new ArrayList<Integer>(input1);
		ArrayList<Integer> input2AfterSideEffects = new ArrayList<Integer>(input2);
		System.out.println(expectedResult.equals(listIntersection(input1, input2)));
		System.out.println(input1AfterSideEffects.equals(input1));
		System.out.println(input2AfterSideEffects.equals(input2));
		
		// Edge case where the first input is empty
		input1 = new ArrayList<Integer>(Arrays.asList(5));
		input2 = new ArrayList<Integer>();
		expectedResult = new ArrayList<Integer>();
		input1AfterSideEffects = new ArrayList<Integer>(input1);
		input2AfterSideEffects = new ArrayList<Integer>(input2);
		System.out.println(expectedResult.equals(listIntersection(input1, input2)));
		System.out.println(input1AfterSideEffects.equals(input1));
		System.out.println(input2AfterSideEffects.equals(input2));
		
		// Edge case where the second input is empty
		input1 = new ArrayList<Integer>();
		input2 = new ArrayList<Integer>(Arrays.asList(5));
		expectedResult = new ArrayList<Integer>();
		input1AfterSideEffects = new ArrayList<Integer>(input1);
		input2AfterSideEffects = new ArrayList<Integer>(input2);
		System.out.println(expectedResult.equals(listIntersection(input1, input2)));
		System.out.println(input1AfterSideEffects.equals(input1));
		System.out.println(input2AfterSideEffects.equals(input2));
		
		// Case where inputs have some common values
		input1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		input2 = new ArrayList<Integer>(Arrays.asList(4, 5, 6));
		expectedResult = new ArrayList<Integer>(Arrays.asList(4, 5));
		input1AfterSideEffects = new ArrayList<Integer>(input1);
		input2AfterSideEffects = new ArrayList<Integer>(input2);
		System.out.println(expectedResult.equals(listIntersection(input1, input2)));
		System.out.println(input1AfterSideEffects.equals(input1));
		System.out.println(input2AfterSideEffects.equals(input2));
		
		// Case where inputs have some common values (with multiple instances)
		input1 = new ArrayList<Integer>(Arrays.asList(7, 5, 2, 7, 6));
		input2 = new ArrayList<Integer>(Arrays.asList(5, 7, 7, 1, 0, 2, 7));
		expectedResult = new ArrayList<Integer>(Arrays.asList(7, 5, 2, 7));
		input1AfterSideEffects = new ArrayList<Integer>(input1);
		input2AfterSideEffects = new ArrayList<Integer>(input2);
		System.out.println(expectedResult.equals(listIntersection(input1, input2)));
		System.out.println(input1AfterSideEffects.equals(input1));
		System.out.println(input2AfterSideEffects.equals(input2));
		
		// Case where inputs have values, but no common values
		input1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		input2 = new ArrayList<Integer>(Arrays.asList(4, 5, 6));
		expectedResult = new ArrayList<Integer>();
		input1AfterSideEffects = new ArrayList<Integer>(input1);
		input2AfterSideEffects = new ArrayList<Integer>(input2);
		System.out.println(expectedResult.equals(listIntersection(input1, input2)));
		System.out.println(input1AfterSideEffects.equals(input1));
		System.out.println(input2AfterSideEffects.equals(input2));
		
		/* Testing for stackToArray() */
		System.out.println("Testing stackToArray(), all lines should print true:");
		
		// Edge case where the input is empty
		Stack<Integer> input = new Stack<Integer>();
		int[] expectedResultArray = new int[0];
		Stack<Integer> inputAfterSideEffects = new Stack<Integer>();
		inputAfterSideEffects.addAll(input);
		System.out.println(Arrays.equals(expectedResultArray, stackToArray(input)));
		System.out.println(inputAfterSideEffects.equals(input));
		
		// Case where the stack has some values
		input = new Stack<Integer>();
		input.push(9);
		input.push(3);
		input.push(4);
		input.push(8);
		input.push(12);
		expectedResultArray = new int[] {9, 3, 4, 8, 12};
		inputAfterSideEffects = new Stack<Integer>();
		inputAfterSideEffects.addAll(input);
		System.out.println(Arrays.equals(expectedResultArray, stackToArray(input)));
		System.out.println(inputAfterSideEffects.equals(input));
		
		/* Testing for removeAlphabeticallyLast */
		System.out.println("Testing removeAlphabeticallyLast(), all lines should print true:");
		
		// Edge case where the input is empty
		Stack<String> inputStack = new Stack<String>();
		Stack<String> expectedResultStack = new Stack<String>();
		removeAlphabeticallyLast(inputStack);
		System.out.println(expectedResultStack.equals(inputStack));
		// Case where the input has only one instance of the last-alphabetical-string
		inputStack = new Stack<String>();
		inputStack.push("aaa");
		inputStack.push("ccc");
		inputStack.push("bbb");
		expectedResultStack = new Stack<String>();
		expectedResultStack.push("aaa");
		expectedResultStack.push("bbb");
		removeAlphabeticallyLast(inputStack);
		System.out.println(expectedResultStack.equals(inputStack));
		// Case where the input has multiple instances of the last-alphabetical-string
		inputStack = new Stack<String>();
		inputStack.push("zzz");
		inputStack.push("mmm");
		inputStack.push("zzz");
		inputStack.push("www");
		inputStack.push("zzz");
		expectedResultStack = new Stack<String>();
		expectedResultStack.push("mmm");
		expectedResultStack.push("www");
		removeAlphabeticallyLast(inputStack);
		System.out.println(expectedResultStack.equals(inputStack));
		
		// In all of these cases the program ran as expected.
	}
	
	public static ArrayList<Integer> listIntersection(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>(arrayList2); // makes a copy of arrayList2 so no side-effecting occurs
		// add "matches" to the result and remove from list2 to avoid double-counting
		for (int number : arrayList1) {
			int foundIndex = list2.indexOf(number);
			if (foundIndex != -1) {
				result.add(list2.remove(foundIndex));	
			}
		}
		return result;	
	}
	
	public static int[] stackToArray(Stack<Integer> stack) {
		Stack<Integer> temp = new Stack<Integer>();
		// Empty the stack into the temporary stack, keeping track of how many elements there are
		int count = 0;
		while (!stack.empty()) {
			temp.push(stack.pop());
			count++;
		}
		// declare an int array big enough to hold all elements
		int[] result = new int[count];
		// move each element back to the original stack and copy it to the array
		for (int i = 0; i < count; i++) {
			int element = temp.pop();
			result[i] = element;
			stack.push(element);
		}
		return result;
	}
	
	public static void removeAlphabeticallyLast(Stack<String> stack) {
		Stack<String> temp = new Stack<String>();
		// empty the stack into the temp stack, keeping track of the "greatest" string
		String lastAlphabetically = "";
		while (!stack.empty()) {
			String current = stack.pop();
			if (current.compareTo(lastAlphabetically) > 0) {
				lastAlphabetically = current;	
			}
			temp.push(current);
		}
		// push each element in temp back into the original stack, but only if the element isn't the "greatest" string
		while (!temp.empty()) {
			String current = temp.pop();
			if (!current.equals(lastAlphabetically)) {
				stack.push(current);		
			}
		}
	}
}