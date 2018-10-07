package elementos_juego;

import java.util.List;

public class Player {
	List<Card> hand;
	
	
	void takeCard(Deck actualDeck) {
		hand.add(actualDeck.getDeck().get(0));
		actualDeck.getDeck().remove(0);
	}
	
	void putCard(int posCardInHand) {
		GameModel.getInstance().graveyard.push(hand.get(posCardInHand));
		hand.remove(posCardInHand);
		
	}
	
}


