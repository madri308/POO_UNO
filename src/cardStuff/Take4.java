package cardStuff;

import MVCStuff.GameModel;

public class Take4 extends Card implements iActionable{

	public Take4() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void makeAction() {
		
	}

	public void makeAction(String pColor) {
		// TODO Auto-generated method stub
		super.setColor(pColor);
		
		// Le agrega 4 cartas al jugador siguiente
		GameModel.getInstance().giveCards(GameModel.getInstance().getPlayers().get( GameModel.getInstance().getTurnoJugadorSiguiente()), 4);
				
		//Se brinca al jugador siguiente
		GameModel.getInstance().setTurnoJugadorActual();		
	}

}
