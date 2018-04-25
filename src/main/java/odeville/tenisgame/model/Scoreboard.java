package odeville.tenisgame.model;

import java.io.IOException;
import java.util.Properties;

public class Scoreboard {

	final private static Properties translations;

	static {
		translations = new Properties();
		try {
			translations.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("translations_EN.properties"));
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}

	public static String getScore(TennisGame game) {
		Player p1 = game.getPlayer1();
		Player p2 = game.getPlayer2();
		String score;
		if (game.getWinner().isPresent()) {
			score = String.format(translations.getProperty("victory"), game.getWinner().get());
		} else if (game.isDeuce()) {
			score = translations.getProperty("deuce");
		} else if (game.getAdvantage().isPresent()) {
			score = String.format(translations.getProperty("advantage"), game.getAdvantage().get());
		} else {
			score = translations.getProperty("score." + game.getScore(p1)) + " - " + translations.getProperty("score." + game.getScore(p2));
		}
		return score;
	}

}
