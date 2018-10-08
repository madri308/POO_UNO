package MVCStuff;

import java.util.List;
import java.util.Stack;

import cardStuff.Card;
import cardStuff.Deck;
import gameStuff.Player;

public class GameModel {
	private List<Player> players;
	private Deck actualDeck;
	public Stack<Card> graveyard;
	private int actualTurn;

	private static GameModel game;
	
	private GameModel() {
		
	}

	public static GameModel getInstance() {
		if (game == null) {
			game = new GameModel();
		}
		return game;
	}
	
	public void searchWinner() {
		for ( Player player : players) {
			//if (!(player)) {	
		}
	}

}
