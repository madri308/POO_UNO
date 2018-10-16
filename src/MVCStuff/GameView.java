package MVCStuff;

import java.util.ArrayList;
import java.util.List;

public class GameView {
	//private GameModel model = GameModel.getInstance();
	private List<PlayerView> PlayersView = new ArrayList<PlayerView>();
	
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
}
