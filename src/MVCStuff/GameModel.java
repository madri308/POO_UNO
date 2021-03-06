package MVCStuff;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import cardStuff.Card;
import cardStuff.ChangeColor;
import cardStuff.Deck;
import cardStuff.SimpleCard;
import cardStuff.Take4;
import cardStuff.iActionable;
import gameStuff.Player;

public class GameModel {
	
	private List<Player> players = new ArrayList<Player>();
	private Deck actualDeck;
	public Stack<Card> graveyard;
	//private GameController controller = GameController.getInstance();
	
	private static GameModel model = null;
	private int turnoJugadorActual = 0;
	private int direccionJuego = 1;

	public int getTurnoJugadorSiguiente() {//Pone el turno del jugador siguiente. Este se usa para cuando algun jugador tiene que comer cartas gracias al +4 o +2
		if(direccionJuego == 1) {//Si la logica es positiva
			if(turnoJugadorActual == players.size()-1) {
				return 0;
			}
			else return turnoJugadorActual+1;
		}
		else {//Entonces la logica es negativa
			if (turnoJugadorActual == 0) {//
				return players.size()-1;
			}
			else {
				return turnoJugadorActual-1;
			}
		}
		
	}
	public int getTurnoJugadorActual() {
		return turnoJugadorActual;
	}
	public void setTurnoJugadorActual() {
		if(direccionJuego == 1) {//Si la logica es positiva
			if(turnoJugadorActual == players.size()-1) {
				turnoJugadorActual = 0;
			}
			else turnoJugadorActual = turnoJugadorActual+1;
		}
		else {//Entonces la logica es negativa
			if (turnoJugadorActual == 0) {//
				turnoJugadorActual = players.size()-1;
			}
			else {
				turnoJugadorActual = turnoJugadorActual-1;
			}
		}
		

	}
	public List<Player> getPlayers() {
		return players;
	}
	public int getDireccionJuego() {
		return direccionJuego;
	}
	public void setDireccionJuego(int direccion) {
		direccionJuego = direccion;
	}
	
	public static GameModel getInstance() {
		if (model == null) {
			model = new GameModel();
		}
		return model;
	}
	public void setDeck() {
		if(actualDeck == null || actualDeck.getDeck().size() == 1) {
			Deck deck = new Deck();
			actualDeck = deck;
		}
	}
	public void updatePlayers() {
		GameController.getInstance().updatePlayers(graveyard);
	}
	public void updatePlayer(Player player) {
		GameController.getInstance().updatePlayer(player);
	}
	
	public void giveCards(Player player, int cant) {
		if(player.isUNO()) {
			player.setUNO(false); 
		}
		for(int cards = 0 ; cards<cant ; cards++) {
			player.getHand().add(actualDeck.getDeck().get(0));
			actualDeck.getDeck().remove(0);
			updatePlayer(player);
		}
	}
	public void validatePutCard(int posCardInHand,Player player) {
		Card lastCard = graveyard.pop();
		Card cardInHand = player.getHand().get(posCardInHand);
		//CASOS
		if(cardInHand instanceof ChangeColor || cardInHand instanceof Take4) {//CARTA EN MANO CAMBIA COLOR
			cardInHand.setColor("User Choose");
			if(cardInHand instanceof Take4) {
				((Take4) cardInHand).makeAction();
			}
			graveyard.push(cardInHand);
			player.getHand().remove(posCardInHand);
			setTurnoJugadorActual();//AQUI se cambia el turno al del siguiente jugador, con cualquier carta que se ponga, se cambia el turno
			
			updatePlayers();//ACTUALIZA
			updatePlayer(player);
		}
		else if(cardInHand instanceof SimpleCard){//CARTA EN MANO SIMPLE
			if(cardInHand.getColor() == lastCard.getColor() || ((SimpleCard) cardInHand).getNumber() == ((SimpleCard) lastCard).getNumber()) {
				graveyard.push(cardInHand);
				player.getHand().remove(posCardInHand);
				setTurnoJugadorActual();//AQUI se cambia el turno al del siguiente jugador, con cualquier carta que se ponga, se cambia el turno
				
				updatePlayers();//ACTUALIZA
				updatePlayer(player);
			}else {
				//RETORNA QUE ESA CARTA NO ES VALIDA
			}
		}else {//CARTA EN MANO ESPECIAL
			if(cardInHand.getColor() == lastCard.getColor()) {
				((iActionable) cardInHand).makeAction();
				graveyard.push(cardInHand);
				player.getHand().remove(posCardInHand);
				setTurnoJugadorActual();//AQUI se cambia el turno al del siguiente jugador, con cualquier carta que se ponga, se cambia el turno
				
				updatePlayers();//ACTUALIZA
				updatePlayer(player);
			}else {
				//RETORNA QUE ESA CARTA NO ES VALIDA
			}
		}
	}
	public void addPlayer(Player player) {
		players.add(player);
	}
	public void startGame() {
		if(players.size() > 1) {
			setDeck();//COMIENZA EL JUEGO
			for(Player player:players) {
				giveCards(player,7);
			}
		}
	}
	
	
	public void validateUNO(Player player) {
		boolean validUNO = false;
		if(player.getHand().size() == 1) {
			player.setUNO(true);
			validUNO = true;
		}else{
			for(Player randomPlayer:players) {
				if(randomPlayer.getHand().size() == 1 && randomPlayer.isUNO() == false) {
					giveCards(randomPlayer,4);//LE DA AL PLAYER QUE TIENE UNA CARTA PERO NUNCA DIJO
					player.setUNO(true);
					validUNO = true;
				}
			}if(!validUNO) {
				giveCards(player,4);//LE DA AL PLAYER QUE DIJO UNO CARTAS
			}
		}
	}
}
