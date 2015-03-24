import java.util.ArrayList;

public class ThreadedSearch<T> implements Runnable {
    
    private T storedTarget;
    private ArrayList<T> storedList;
    private int storedStart;
    private int storedEnd;
    private Answer storedAnswer;
    
    public ThreadedSearch() {
    	//this is the base constructor
    	storedAnswer = new Answer();
    }
    
    private ThreadedSearch(T target, ArrayList<T> list, int start, int end, Answer answer) {
        storedTarget = target;
        storedList = list; 
        storedStart = start;
        storedEnd = end; // End is exclusive
        storedAnswer = answer;
    }
    
    //assume list size is divisible by numThreads to start
    public boolean parallelSearch(int numThreads, T target, ArrayList<T> list) throws InterruptedException {
    	numThreads = Math.min(numThreads, list.size()); // Doesn't make sense to have more threads than items in list.
    	Thread[] threads = new Thread[numThreads];
    	for (int i = 0; i < numThreads; i++) {
    		int startIndex = getStartIndex(i, numThreads, list.size());
    		int endIndex = getEndIndex(i, numThreads, list.size());
    		threads[i] = new Thread(new ThreadedSearch<T>(target, list, startIndex, endIndex, storedAnswer));
    		threads[i].start();
    	}
    	
    	for (int i = 0; i < numThreads; i++) {
    		threads[i].join();
    	}
    	
        return storedAnswer.answer;
    }
    
    private int getStartIndex(int currentThread, int numThreads, int arraySize) {
    	int chunkSize = divideAndRoundUp(arraySize, numThreads);
		return currentThread * chunkSize;
	}

    private int getEndIndex(int currentThread, int numThreads, int arraySize) {
    	int chunkSize = divideAndRoundUp(arraySize, numThreads);
    	int endIndex = (currentThread + 1) * chunkSize; // endIndex is exclusive
    	return Math.min(endIndex, arraySize); // Prevents out of bounds exceptions
	}

	// Just trying to divide and round up here... couldn't find a better way
	private int divideAndRoundUp(int x, int y) {
		return x % y == 0 ? x / y : (x / y) + 1;
	}

	@Override
	public void run() {
		for(int i = storedStart; i < storedEnd; i++) {
            if(storedList.get(i).equals(storedTarget)) {
                storedAnswer.answer = true;
                return; // Optimizes speed if the item is found early.
            }
        }
    	// If not found, do nothing, and the value in storedAnswer stays false
	}

	private class Answer {
	    public boolean answer = false;
	}

}