import model.OlympicGames;

public class Main {
	
	private OlympicGames games;
	
	public Main() {
		games = new OlympicGames();
		games.loadCountries();
	}

	public static void main(String[] args) {
		Main m = new Main();
		System.out.println(m.getGames().toString());
	}


	public OlympicGames getGames() {
		return games;
	}

}
