package MVCStuff;

import java.util.List;

import cardStuff.Card;
import gameStuff.Player;

public class GameController {
	
	//private GameModel model = GameModel.getInstance();
	//private GameView view = GameView.getInstance();
	
	private static GameController game = null;
	
	private GameController() {}
	
	public static GameController getInstance() {
		if (game == null) {
			game = new GameController();
		}
		return game;
	}
	
	public void actionUNO(Player player) {
		GameModel.getInstance().validateUNO(player);
	}
	public void actionPutCard(int posCardInHand,Player player) {
		GameModel.getInstance().validatePutCard(posCardInHand,player);
	}
	public void actionTakeCard(Player player) {
		GameModel.getInstance().giveCards(player, 1);
	}
	public void actionStart() {
		GameModel.getInstance().startGame();
	}
	public void actionAddMe(Player player) {
		GameModel.getInstance().addPlayer(player);
	}
	public void updatePlayers(List<Card> graveyard) {}
	public void updatePlayer(Player player) {}
	
}
