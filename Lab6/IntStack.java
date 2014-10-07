import java.util.ArrayList;
import java.util.EmptyStackException;


public class IntStack implements IntStackInterface {

	private int[] intArray = new int[1];
	private int nextIndex = 0;
	
	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void push(int value) {
		ensureCapacity();
		intArray[nextIndex] = value;
		nextIndex++;
	}

	@Override
	public int peek() throws EmptyStackException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int pop() throws EmptyStackException {
		nextIndex--;
		int popElement = intArray[nextIndex];
		return popElement;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IntStackInterface invert() {
		// TODO Auto-generated method stub
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
