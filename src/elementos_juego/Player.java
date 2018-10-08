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
		Card cardInHand = hand.get(posCardInHand);
		//CASOS
		if(cardInHand instanceof ChangeColor || cardInHand instanceof Take4) {//CARTA EN MANO CAMBIA COLOR
			cardInHand.setColor("User Choose");
			if(cardInHand instanceof Take4) {
				((Take4) cardInHand).makeAction();
				GameModel.getInstance().graveyard.push(cardInHand);
			}
			GameModel.getInstance().graveyard.push(cardInHand);
			hand.remove(hand.indexOf(cardInHand));
		}
		else if(cardInHand instanceof SimpleCard){//CARTA EN MANO SIMPLE
			if(cardInHand.getColor() == lastCard.getColor() || ((SimpleCard) cardInHand).getNumber() == ((SimpleCard) lastCard).getNumber()) {
				GameModel.getInstance().graveyard.push(cardInHand);
				hand.remove(hand.indexOf(cardInHand));
			}else {
				//RETORNA QUE ESA CARTA NO ES VALIDA
			}
		}else {//CARTA EN MANO ESPECIAL
			if(cardInHand.getColor() == lastCard.getColor()) {
				((iActionable) cardInHand).makeAction();
				GameModel.getInstance().graveyard.push(cardInHand);
				hand.remove(hand.indexOf(cardInHand));
			}else {
				//RETORNA QUE ESA CARTA NO ES VALIDA
			}
		}
			
	}
		
	public void UNO() {
		if(hand.size()==1) {
			//Aqui hace algo
			return;
		}
	}
	
}


