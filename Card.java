//Lemmon, Yuting, Cassie

public class Card {
	private String suit;
	private String value;
	private int numericValue;
	
	public Card(String cardSuit, String cardValue) {
		suit = cardSuit;
		value = cardValue;
		setNumericValue();
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String getValue() {
		return value;	
	}
	
	public int getNumericValue() {
		return numericValue;	
	}
	

	public String toString() {
		return value + " of " + suit;
	}
	
	public int compareTo(Card other) {
		return this.numericValue - other.numericValue;
	}

	private void setNumericValue() {
		try {
			numericValue = Integer.parseInt(value);
			// note: not yet checking for invalid numbers
		}
		catch (Exception e) {
			if (value.equals("A")) {
				numericValue = 14;	
			}
			else if (value.equals("K")) {
				numericValue = 13;
			}
			else if (value.equals("Q")) {
				numericValue = 12;
			}
			else if (value.equals("J")) {
				numericValue = 11;
			}
			else {
				//problem - deal with it later	
			}
		}
	}
}