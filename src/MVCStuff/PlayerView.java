package MVCStuff;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import cardStuff.Card;

public class PlayerView {//Esta clase es la que se va a enviar a java script
	String playerName;
	Card lastCard;
	List<Card> Hand;
	int[] numHandPlayers; //El tamaño del array es la cantidad de jugador que hay, y el array en la posicion i es la cantidad de cartas que tiene en la mano el jugador i

	public PlayerView(String pPlayerName) {
		playerName = pPlayerName;
	}
	
	public boolean convertToJson() {
		try {
			File file = new File(playerName + ".json");
			BufferedWriter bw;
			Gson json = new Gson();
			json.toJson(this);
	        bw = new BufferedWriter(new FileWriter(file));
	        bw.write(json.toJson(this));
	        bw.close();
	        return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	/*
	public static void main(String[] args) throws IOException {
		PlayerView test = new PlayerView("test");
		test.convertToJson();
	}
	*/
}
