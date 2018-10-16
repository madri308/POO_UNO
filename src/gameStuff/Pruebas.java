package gameStuff;

import cardStuff.Card;

import cardStuff.SimpleCard;

public class Pruebas {

	public static void main(String[] args) {
		/*
		Deck deckPrueba = new Deck();
		
		java.util.List<Card> listaDeck = deckPrueba.getDeck();
		for(Card card:listaDeck) {
			if(card instanceof SimpleCard) {System.out.print(((SimpleCard) card).getNumber()+card.getColor()+" ");
			}else{System.out.print(card.getClass().getSimpleName()+" ");
			}
		}
		int sc = 0, cc = 0, j = 0, r = 0, t2 = 0, t4 = 0;
		for(int i = 0; i<listaDeck.size(); i++) {
			if(listaDeck.get(i) instanceof SimpleCard) {sc++;}
			else if(listaDeck.get(i) instanceof ChangeColor) {cc++;}
			else if(listaDeck.get(i) instanceof Jump) {j++;}
			else if(listaDeck.get(i) instanceof Reverse) {r++;}
			else if(listaDeck.get(i) instanceof Take2) {t2++;}
			else {t4++;}
		}
		System.out.println("Cartas Simples: "+sc);
		System.out.println("Cambia Color: "+cc);
		System.out.println("Saltos: "+j);
		System.out.println("Reversas: "+r);
		System.out.println("Come2: "+t2);
		System.out.println("Come4: "+t4);
		System.out.println(sc+cc+j+r+t2+t4+" cartas en total");
		*/
		
		
				
		Player player1 = new Player("jugador1");
		player1.start();
		//System.out.println(player1.getHand());
		@SuppressWarnings("unused")
		Player player2 = new Player("jugador2");
		player1.start();
		for(Card card:player1.getHand()) {
			if(card instanceof SimpleCard) {System.out.print(((SimpleCard) card).getNumber()+card.getColor()+" ");
			}else{System.out.print(card.getClass().getSimpleName()+" ");
			}
		}
	}
}
