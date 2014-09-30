//Lemmon, Yuting, Cassie

import java.util.ArrayList;
import java.util.Collection;

public class Player {
	private ArrayList<Card> hand = new ArrayList<Card>();
	String name;
	
	public Player(String name) {
		this.name = name;	
	}
	
	public String getName() {
		return name;	
	}
	
	/* Adds a card to the bottom of the player's hand of cards */
	public void addCardToHand(Card card) {
		hand.add(card);	
	}
	
	/* NOTE: Collection is a java Interface (we'll cover these soon) - both Stacks 
	and ArrayLists of Cards can be passed to this method without any 
	modification of this code */
	public void addCardsToHand(Collection<Card> cards) {
		hand.addAll(cards);
	}
	
	/* Removes the top card from the player's hand and returns it to the caller */
	public Card playCard() {
		return hand.remove(0);	
	}
	
	/* True if the player still has any cards */
	public boolean hasCards() {
		return hand.size() > 0;	
	}
	
	/* The number of cards left in the player's hand */
	public int cardCount() {
		return hand.size();	
	}
	
	/* Returns the player's name */
	public String toString() {
		return name;
	}
	
	public ArrayList<Card> removeAllCards() {
		ArrayList<Card> playersHand = new ArrayList<Card>();
		for (Card card : hand) {
			playersHand.add(card);
		}
		
		hand.clear();
		return playersHand;
	}
}