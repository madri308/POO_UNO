package MVCStuff;

import java.util.List;

import cardStuff.Card;
import gameStuff.Player;

public class GameController {
	
	private GameModel model;
	private GameView view;
	private static GameController game;
	
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
		GameModel.getInstance().validateUNO(player);
	}
	public void actionPutCard(int posCardInHand,Player player) {
		GameModel.getInstance().validatePutCard(posCardInHand,player);
	}
	public void actionTakeCard(Player player) {
		GameModel.getInstance().giveCard(player, 1);
	}
	public void updatePlayers(List<Card> graveyard) {}
	public void updatePlayer(Player player) {}
	
}
