package cardStuff;

import MVCStuff.GameModel;

public class Jump extends Card implements iActionable{

	public Jump() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void makeAction() {
		//Para brincar al siguiente jugardor, le coloca el 1 o el -1 que tiene direccionJuego
		GameModel.getInstance().setTurnoJugadorActual();
		
	}

}
