package cardStuff;

import MVCStuff.GameModel;

public class Take2 extends Card implements iActionable{

	public Take2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void makeAction() {
		// Le agrega 2 cartas al jugador siguiente
		GameModel.getInstance().giveCards(GameModel.getInstance().getPlayers().get( GameModel.getInstance().getTurnoJugadorSiguiente()), 2);
		
	}

}
