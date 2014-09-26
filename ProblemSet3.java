// Aaron Lemmon

import java.util.ArrayList;

public class ProblemSet3 {
	
	public static void main(String [] args) {
		// sample test: in this example "jayhawk" is the most frequent element:
		String[] elements = {"wildcat", "gopher", "badger", "wildcat", "badger", "hawkeye", 
					"gopher", "jayhawk", "jayhawk", "jayhawk", "hawkeye", "cougar", 
					"wolverine", "jayhawk", "wolverine", "gopher",  "wildcat", 
					"wolverine", "wildcat", "badger", "jayhawk", "wildcat", "wildcat", 
					"badger", "hawkeye", "jayhawk", "gopher", "cougar", "jayhawk"};
		System.out.println(mostFrequentElement(elements).equals("jayhawk"));  // should print true
		
		elements = new String[] {"crane", "duck", "crane"};
		System.out.println(mostFrequentElement(elements).equals("crane")); // should print true
		
		elements = new String[] {"moose"};
		System.out.println(mostFrequentElement(elements).equals("moose")); // should print true
		
		// Tests for behavior when the input has more than one most frequent string.
		// My implementation should return the one that occured first in the input array.
		elements = new String[] {"librarian", "fireman", "policeman", "policeman", "fireman"};
		System.out.println(mostFrequentElement(elements).equals("fireman")); // should print true

    }

    /**
       Given an array of Strings, the method finds and returns the most frequently occurring element. 
       If there is more than one such element, any one of them may be returned. 
       The method can assume that the given array contains at least one element.
     **/
	static String mostFrequentElement(String[] elements) {
		ArrayList<String> encounteredStrings = new ArrayList<String>();
		ArrayList<Integer> stringCounts = new ArrayList<Integer>();
		
		for (String currentString : elements) {
			int index = encounteredStrings.indexOf(currentString);
			if (index == -1) {
				encounteredStrings.add(currentString);
				stringCounts.add(1);
			} else {
				stringCounts.set(index, stringCounts.get(index) + 1);
			}
		}
		
		int indexHoldingMaxCount = 0;
		int maxCount = 0;
		for (int currentIndex = 0; currentIndex < stringCounts.size(); currentIndex++) {
			if (stringCounts.get(currentIndex) > maxCount) { // Should always be true the first time through the loop
				maxCount = stringCounts.get(currentIndex);
				indexHoldingMaxCount = currentIndex;
			}
		}
		return encounteredStrings.get(indexHoldingMaxCount);
	}
}
