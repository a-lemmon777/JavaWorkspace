//Lemmon, Yuting, Cassie

/*The way we designed our code eliminates the possibility of an infinite loop.*/

import java.util.ArrayList;

public class War{
	
	private static Player playerOne = new Player("Joe Beaver");
	private static Player playerTwo = new Player("Lenny");
	private static boolean done = false;	
	public static void main(String[] args){
		Deck deck = new Deck();
		playerOne.addCardsToHand(deck.dealCards(26));
		playerTwo.addCardsToHand(deck.dealCards(26));
		//deck.dealCards(1); // for testing
		playGame();
	}
	
	private static void playGame(){
		while (playerOne.hasCards() && playerTwo.hasCards() && !done){
			ArrayList<Card> pile = new ArrayList<Card>();
			decideRoundWinner(pile);
			System.out.println(playerOne + " has " + playerOne.cardCount() + " card" + ((playerOne.cardCount() == 1) ? "." : "s."));
			System.out.println(playerTwo + " has " + playerTwo.cardCount() + " card" + ((playerTwo.cardCount() == 1) ? "." : "s."));
			System.out.println();
		}
		if (playerOne.cardCount() == 0) {
			System.out.println(playerTwo + " wins!!");
		} else if (playerTwo.cardCount() == 0){
			System.out.println(playerOne + " wins!!");
		} else {
			System.out.println("The players tied -_-");
		}
		System.out.println();
	}
	private static void decideRoundWinner(ArrayList<Card> pile){
		Card playerOneCard = playerOne.playCard();
		Card playerTwoCard = playerTwo.playCard();
		System.out.println(playerOne + " played the " + playerOneCard + "!");
		System.out.println(playerTwo + " played the " + playerTwoCard + "!");
		int comparison = playerOneCard.compareTo(playerTwoCard);
			if (comparison > 0) {
				//one wins round
				playerOne.addCardToHand(playerOneCard);
				playerOne.addCardToHand(playerTwoCard);
				playerOne.addCardsToHand(pile);
			} else if (comparison < 0) {
				// two wins round
				playerTwo.addCardToHand(playerTwoCard);
				playerTwo.addCardToHand(playerOneCard);
				playerTwo.addCardsToHand(pile);
			} else {
				// war!!
				System.out.println("WAR!!!!!");
				pile.add(0, playerOneCard);
				pile.add(0, playerTwoCard);
				letsPlayWar(pile);
			}
	}
	private static void letsPlayWar(ArrayList<Card> pile) {
		if ((playerOne.cardCount() < 4) && (playerTwo.cardCount() < 4)) {
			done = true;
		} else if (playerOne.cardCount() < 4) {
			System.out.println(playerOne + " does not have enough cards to continue.");
			playerTwo.addCardsToHand(playerOne.removeAllCards());	
		} else if (playerTwo.cardCount() < 4) {
			System.out.println(playerTwo + " does not have enough cards to continue.");
			playerOne.addCardsToHand(playerTwo.removeAllCards());
		} else {
			pile.add(playerOne.playCard());
			pile.add(playerOne.playCard());
			pile.add(playerOne.playCard());
			pile.add(playerTwo.playCard());
			pile.add(playerTwo.playCard());
			pile.add(playerTwo.playCard());
			decideRoundWinner(pile);
		}
	}
}