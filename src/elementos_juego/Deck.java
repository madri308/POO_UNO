package elementos_juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<Card>();
	
	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	public Deck() {
		String[] colors = {"blue","red","green","yellow"};
		for (String color:colors) {
			//SE CREAN 4(CEROS, CAMBIA COLOR, COME4)
				
			SimpleCard zeroCard = new SimpleCard();
			zeroCard.setNumber(0);
			zeroCard.setColor(color);
			deck.add(zeroCard);
				
			ChangeColor ccCard = new ChangeColor();
			deck.add(ccCard);
				
			Take4 t4Card = new Take4();
			deck.add(t4Card);
				
			for(int i = 0; i<2; i++) {
				//SE CREAN 8(SALTOS, REVERSAS, COME2)
				Jump jCard = new Jump();
				jCard.setColor(color);
				deck.add(jCard);
					
				Reverse rCard = new Reverse();
				rCard.setColor(color);
				deck.add(rCard);
				
				Take2 t2Card = new Take2();
				t2Card.setColor(color);
				deck.add(t2Card);
					
				for (int number = 1; number < 10; number++) {
					//SE CREAN 76 CARTAS SIMPLES.
					SimpleCard sCard = new SimpleCard();
				    sCard.setColor(color);
					sCard.setNumber(number);
					deck.add(sCard);
				}
			}
		}
		//Desordena las cartas
		Collections.shuffle(deck);
	}

}
