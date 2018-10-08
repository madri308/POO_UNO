package gameStuff;

import java.util.List;

import MVCStuff.GameController;
import cardStuff.Card;
import cardStuff.Deck;


public class Player {
	
	private String name;
	private List<Card> hand;
	public boolean ready = false;
	public boolean UNO = false;
	
	public void start() {
		ready = true;
	}
	
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
			
		}
	}
	public void takeCard() {
		GameController.getInstance().actionTakeCard(this);
	}
	public void putCard(int CardInHand) {
		GameController.getInstance().actionPutCard(CardInHand,this);
	}
	public void UNO() {
		GameController.getInstance().actionUNO(this);
		}
	
	
}


