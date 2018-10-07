package elementos_juego;

import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;
	
	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	public Deck() {
		String[] colors = {"blue","red","green","yellow"};
		
		 //Esto crea las cartas normales.
		for (String color:colors) {
			for (int number = 0; number < 10; number++) {
				SimpleCard card = new SimpleCard(color);
				card.setNumber(number);
				deck.add(card);
			}
		}
		
		//Aqui se deben crear las cartas especiales
		
		
		//Desordena las cartas
		Collections.shuffle(deck);
	}

}
