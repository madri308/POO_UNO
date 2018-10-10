package gameStuff;

import java.util.ArrayList;
import java.util.List;

import MVCStuff.GameController;
import MVCStuff.GameView;
import cardStuff.Card;
import cardStuff.Deck;


public class Player {
	
	private String name;
	private List<Card> hand = new ArrayList<Card>();
	
	public Player(String pName) {
		setName(pName);
		GameController.getInstance().actionAddMe(this);
	}
	public boolean isUNO() {
		return UNO;
	}
	public void join() {
		
	}
	public void setUNO(boolean pUNO) {
		UNO = pUNO;
	}
	private boolean UNO = false;
	
	public String getName() {
		return name;
	}
	public void setName(String pName) {
		name = pName;
	}
	public List<Card> getHand() {
		return hand;
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
	public void start() {
		GameController.getInstance().actionStart();
	}
	
}


