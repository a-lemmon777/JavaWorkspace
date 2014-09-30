//Lemmon, Yuting, Cassie

import java.util.Stack;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private Stack<Card> deck = new Stack<Card>();

	public Deck() {
		ArrayList<Card> cards = new ArrayList<Card>();
		
		String[] suits = new String[] {"Hearts", "Clubs", "Spades", "Diamonds"};
		String[] vals = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < vals.length; j++) {
				Card card = new Card (suits[i], vals[j]);
				cards.add(card);
			}
		}
		//System.out.println(cards);
		
		Random rand = new Random();
		while (!cards.isEmpty()) {
			int nextCardIndex = rand.nextInt(cards.size());
			deck.push(cards.remove(nextCardIndex));
		}
		
		//System.out.println(deck);
		//System.out.println(deck.size());
	}	
	
	/* Return the top numCards cards from the deck, in an arraylist.  This can be used to
	   Give a player his/her initial 26 cards all at once */
	public ArrayList<Card> dealCards(int numCards) {
		// TO-DO
		ArrayList<Card> playerdeck = new ArrayList<Card>();
		for (int k = 0 ; k < numCards; k++) {
			playerdeck.add(deck.pop());	
		}
		System.out.println(playerdeck);
		return playerdeck;
	}
}