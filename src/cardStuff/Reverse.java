package cardStuff;

import MVCStuff.GameModel;

public class Reverse extends Card implements iActionable{

	public Reverse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void makeAction() {
		//Le cambio el signo a la direccion del juego
		GameModel.getInstance().setDireccionJuego(GameModel.getInstance().getDireccionJuego()*-1);		
	}

	public void makeAction(String pColor) {
		// TODO Auto-generated method stub
		
	}

}
