package elementos_juego;

import java.util.List;

public class Player {
	private String name;
	private List<Card> hand;
	
	public String getName() {
		return name;
	}


	public List<Card> getHand() {
		return hand;
	}


	public Player(String pName, Deck actualDeck) {
		name = pName;
		for(int counter = 0;  counter < 7; counter++ ) {
			hand.add(actualDeck.getDeck().get(0));
			actualDeck.getDeck().remove(0);
		}
	}
	
	
	public void takeCard(Deck actualDeck) {
		hand.add(actualDeck.getDeck().get(0));
		actualDeck.getDeck().remove(0);
	}
	
	public void putCard(int posCardInHand) {
		Card lastCard = GameModel.getInstance().graveyard.pop();
		Card cardPlayed = hand.get(posCardInHand);
		if(GameModel.getInstance().graveyard.pop() instanceof SimpleCard ) {
			
		}
		if(lastCard.getColor() == cardPlayed.getColor() || lastCard.getNumber() == cardPlayed.getNumber()) {
			GameModel.getInstance().graveyard.push(cardPlayed);
			hand.remove(posCardInHand);
		}
		else if(true) {
			//Si es una carta especial
		}
		/*else {
			//Que diga que no es posible hacer esa jugada
			return;
		}
		*/
		
	}
	
	public void UNO() {
		if(hand.size()==1) {
			//Aqui hace algo
			return;
		}
	}
	
}


