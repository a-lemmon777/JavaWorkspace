// Aaron Lemmon && Lenny Scott

import java.util.ArrayList;
import java.util.EmptyStackException;

public class IntStack implements IntStackInterface {

	private int[] intArray = new int[1];
	private int nextIndex = 0;
	
	@Override
	public boolean empty() {
		return (nextIndex == 0);
	}

	@Override
	public void push(int value) {
		ensureCapacity();
		intArray[nextIndex] = value;
		nextIndex++;
	}

	@Override
	public int peek() throws EmptyStackException {
		if(nextIndex <= 0){
			throw new EmptyStackException();
		}
		return intArray[nextIndex - 1];
	}

	@Override
	public int pop() throws EmptyStackException {
		nextIndex--;
		if (nextIndex < 0) {
			throw new EmptyStackException();
		}
		int popElement = intArray[nextIndex];
		return popElement;
	}

	@Override
	public void clear() {
		nextIndex = 0;
	}

	@Override
	public int size() {
		return nextIndex;
	}

	@Override
	public IntStackInterface invert() {
		IntStackInterface inverse = new IntStack();
		for(int i = 0; i < nextIndex; i++) {
			
		}
		return null;
	}

	@Override
	public ArrayList<Integer> convertToArrayList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IntStackInterface copy() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		String result = "[";
		for (int i = 0; i < nextIndex; i++) {
			result += intArray[i];
			if (i < nextIndex - 1) {
				result += ", ";
			}
		}
		result += "]";
		return result;
	}
	
	/* doubles length of the array on the fly as needed*/
	private void ensureCapacity() {
		if (nextIndex >= intArray.length) {
			int[] doubledArray = new int[intArray.length * 2];
			for (int i = 0; i < intArray.length; i++) {
				doubledArray[i] = intArray[i];
			}
			intArray = doubledArray;
		}
	}
}
