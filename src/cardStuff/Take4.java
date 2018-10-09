package cardStuff;

import MVCStuff.GameModel;

public class Take4 extends Card {

	public Take4() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void makeAction() {
		// Le agrega 4 cartas al jugador siguiente
		GameModel.getInstance().giveCard(GameModel.getInstance().getPlayers().get( GameModel.getInstance().getTurnoJugadorSiguiente()), 4);
		
		//Se brinca al jugador siguiente
		GameModel.getInstance().setTurnoJugadorActual(GameModel.getInstance().getDireccionJuego());

		
	}

}
