package MVCStuff;

import java.util.List;

import cardStuff.Card;
import gameStuff.Player;

public class GameController {
	
	private GameModel model = GameModel.getInstance();
	private GameView view = GameView.getInstance();
	
	private static GameController game;
	
	private GameController() {}
	
	public static GameController getInstance() {
		if (game == null) {
			game = new GameController();
		}
		return game;
	}
	public void setMV(GameModel pModel, GameView pView) {
		model = pModel;
		view = pView;
	}
	public void actionUNO(Player player) {
		model.validateUNO(player);
	}
	public void actionPutCard(int posCardInHand,Player player) {
		model.validatePutCard(posCardInHand,player);
	}
	public void actionTakeCard(Player player) {
		model.giveCards(player, 1);
	}
	public void actionStart() {
		model.startGame();
	}
	public void actionAddMe(Player player) {
		model.addPlayer(player);
	}
	public void updatePlayers(List<Card> graveyard) {}
	public void updatePlayer(Player player) {}
	
}
