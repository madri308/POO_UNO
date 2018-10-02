package elementos_juego;

import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deck;
	
	public Deck() {
		String[] colors = {"blue","red","green","yellow"};
		
		 //Esto crea las cartas normales.
		for (String color:colors) {
			for (int number = 0; number < 10; number++) {
				Card card = new Card(color,number);
				deck.add(card);
			}
		}
		
		//Aqui se deben crear las cartas especiales
		
		
		//Desordena las cartas
		Collections.shuffle(deck);
	}

}