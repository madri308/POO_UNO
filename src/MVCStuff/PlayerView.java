package MVCStuff;

import java.util.List;

import cardStuff.Card;

public class PlayerView {//Esta clase es la que se va a enviar a java script
	String playerName;
	Card lastCard;
	List<Card> Hand;
	int[] numHandPlayers; //El tamaño del array es la cantidad de jugador que hay, y el array en la posicion i es la cantidad de cartas que tiene en la mano el jugador i
	
	public PlayerView(String pPlayerName) {
		playerName = pPlayerName;
	}

}
