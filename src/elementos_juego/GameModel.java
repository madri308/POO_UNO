package elementos_juego;

import java.util.List;
import java.util.Stack;

public class GameModel {
	private List<Player> players;
	private Deck actualDeck;
	public Stack<Card> graveyard;

	private static GameModel game;
	
	private GameModel() {
		
	}

	public static GameModel getInstance() {
		if (game == null) {
			game = new GameModel();
		}
		return game;
	}
	

}
