package elementos_juego;

public class Card {
	private String color;
	private int number;
	
	public String getColor() {
		return color;
	}


	public int getNumber() {
		return number;
	}


	public Card(String pColor, int pNumber){
		color = pColor;
		number = pNumber;
	}

}
