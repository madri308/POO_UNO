package MVCStuff;

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
	
	private List<Player> players;
	private Deck actualDeck;
	public Stack<Card> graveyard;
	private int turnoJugadorActual = 0;
	private int direccionJuego = 1;
	private int turnoJugadorSiguiente;

	public int getTurnoJugadorSiguiente() {
		return turnoJugadorActual;
	}
	public int getTurnoJugadorActual() {
		return turnoJugadorActual;
	}
	public void setTurnoJugadorActual(int salto) {//salto solo va a ser 1, -1 o 0
		int turnoSiguiente = turnoJugadorActual+ 1*direccionJuego; //Se fija cual va a ser el siguiente jugador 
		//Si esta en logica positiva
		if(turnoSiguiente >= players.size()) {
			turnoJugadorActual = 0 + salto;
			turnoJugadorSiguiente = turnoSiguiente +1*direccionJuego;
			return;
		}
		//Si esta en logica negativa
		if(turnoJugadorActual < 0) {
			turnoJugadorActual = players.size()-1 + salto;
			turnoJugadorSiguiente = turnoSiguiente +1*direccionJuego;
			return;
		}
		turnoJugadorActual = turnoJugadorActual + direccionJuego + salto;
		
		if(turnoSiguiente +1*direccionJuego >= players.size()) {//Son comparaciones para que el turno siguiente no se caiga en los extremos
			turnoJugadorSiguiente = 0;
			return;
		}
		if(turnoSiguiente +1*direccionJuego < 0) {//Son comparaciones para que el turno siguiente no se caiga en los extremos
			turnoJugadorSiguiente = players.size()-1;
			return;
		}
		
		turnoJugadorSiguiente = turnoSiguiente +1*direccionJuego;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public int getDireccionJuego() {
		return direccionJuego;
	}
	public void setDireccionJuego(int direccionJuego) {
		this.direccionJuego = direccionJuego;
	}
	private static GameModel game;
	
	public static GameModel getInstance() {
		if (game == null) {
			game = new GameModel();
		}
		return game;
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
	
	public void giveCard(Player player, int cant) {
		if(player.UNO) {
			player.UNO = false;
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
			
			updatePlayers();//ACTUALIZA
			updatePlayer(player);
		}
		else if(cardInHand instanceof SimpleCard){//CARTA EN MANO SIMPLE
			if(cardInHand.getColor() == lastCard.getColor() || ((SimpleCard) cardInHand).getNumber() == ((SimpleCard) lastCard).getNumber()) {
				graveyard.push(cardInHand);
				player.getHand().remove(posCardInHand);
				
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
				
				updatePlayers();//ACTUALIZA
				updatePlayer(player);
			}else {
				//RETORNA QUE ESA CARTA NO ES VALIDA
			}
		}
			
	}
	public void startGame() {
		while(players.size()<2) {
			return;
		}setDeck();//COMIENZA EL JUEGO
	}
	public void validateUNO(Player player) {
		boolean validUNO = false;
		if(player.getHand().size() == 1) {
			player.UNO = true;
			validUNO = true;
		}else{
			for(Player randomPlayer:players) {
				if(randomPlayer.getHand().size() == 1 && randomPlayer.UNO == false) {
					giveCard(randomPlayer,4);//LE DA AL PLAYER QUE TIENE UNA CARTA PERO NUNCA DIJO
					randomPlayer.UNO = true;
					validUNO = true;
				}
			}if(!validUNO) {
				giveCard(player,4);//LE DA AL PLAYER QUE DIJO UNO CARTAS
			}
		}
	}
}
