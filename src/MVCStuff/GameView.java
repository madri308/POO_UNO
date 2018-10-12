package MVCStuff;

import java.util.List;

public class GameView {
	private GameModel model;
	private List<PlayerView> PlayersView;
	
	public List<PlayerView> getPlayersView() {
		return PlayersView;
	}

	private static GameView view;
	
	public static GameView getInstance() {
		if (view == null) {
			view = new GameView();
		}
		return view;
	}
	
	public void setModel(GameModel pModel) {
		model = pModel;
	}
}
