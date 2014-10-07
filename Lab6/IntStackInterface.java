import java.util.EmptyStackException;
import java.util.ArrayList;

/*
An interface specifying the behavior of a stack that 
only holds integers.
*/
public interface IntStackInterface {
	/* Returns true if there are no elements on the stack. */
	public boolean empty();

	/* Adds the supplied value to the top of the stack. */
	public void push(int value);
	
	/* Returns (but does not remove) the top value of the
	   stack */
	public int peek() throws EmptyStackException;
	
	/* Returns and removes the top value of the stack. */
	public int pop() throws EmptyStackException;
	
	/* Removes all elements from the stack. */
	public void clear();
	
	/* Returns the number of elements in the stack. */
	public int size();

	/* Returns an inverted copy of the stack. Does not affect
	   the stack itself. */
	public IntStackInterface invert();
	
	/* Returns the contents of the stack in an ArrayList in order.
	   Does not affect the stack itself. */
	public ArrayList<Integer> convertToArrayList();
	
	/* Returns a copy of the stack. Does not affect the stack itself. */
	public IntStackInterface copy();
}