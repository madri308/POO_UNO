package MVCStuff;

public class GameView {
	private GameModel model;
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
