package elementos_juego;

public class Pruebas {

	public Pruebas() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		
		Deck deckPrueba = new Deck();
		java.util.List<Card> listaDeck = deckPrueba.getDeck();
		int sc = 0;
		int cc = 0;
		int j = 0;
		int r = 0;
		int t2 = 0;
		int t4 = 0;
		for(int i = 0; i<listaDeck.size(); i++) {
			if(listaDeck.get(i) instanceof SimpleCard) {
				sc++;
			}
			else if(listaDeck.get(i) instanceof ChangeColor) {
				cc++;
			}
			else if(listaDeck.get(i) instanceof Jump) {
				j++;
			}
			else if(listaDeck.get(i) instanceof Reverse) {
				r++;
			}
			else if(listaDeck.get(i) instanceof Take2) {
				t2++;
			}
			else {
				t4++;
			}
		}
		System.out.println("Cartas Simples: "+sc);
		System.out.println("Cambia Color: "+cc);
		System.out.println("Saltos: "+j);
		System.out.println("Reversas: "+r);
		System.out.println("Come2: "+t2);
		System.out.println("Come4: "+t4);
		System.out.println(sc+cc+j+r+t2+t4+" cartas en total");
		

	}

}
