package odeville.tenisgame;

import static org.junit.Assert.assertTrue;
import odeville.tenisgame.model.Player;
import odeville.tenisgame.model.Scoreboard;
import odeville.tenisgame.model.TennisGame;

import org.junit.Test;

public class ScoreBoardTest {

	private Player nadal = new Player("Nadal");
	private Player federer = new Player("Federer");

	@Test
	public void simpleGame1() {
		TennisGame game = new TennisGame(nadal, federer);
		checkGameScore(game, "love - love");
		game.scores(nadal);
		checkGameScore(game, "fifteen - love");
		game.scores(nadal);
		checkGameScore(game, "thirty - love");
		game.scores(nadal);
		checkGameScore(game, "forty - love");
		game.scores(nadal);
		checkGameScore(game, "Nadal wins.");
	}

	@Test
	public void simpleGame2() {
		TennisGame game = new TennisGame(nadal, federer);
		checkGameScore(game, "love - love");
		game.scores(federer);
		checkGameScore(game, "love - fifteen");
		game.scores(nadal);
		checkGameScore(game, "fifteen - fifteen");
		game.scores(federer);
		checkGameScore(game, "fifteen - thirty");
		game.scores(nadal);
		checkGameScore(game, "thirty - thirty");
		game.scores(nadal);
		checkGameScore(game, "forty - thirty");
		game.scores(federer);
		checkGameScore(game, "Deuce");
		game.scores(federer);
		checkGameScore(game, "Advantage Federer");
	}

	@Test
	public void complexeGame1() {
		TennisGame game = new TennisGame(nadal, federer);
		checkGameScore(game, "love - love");
		game.scores(nadal);
		checkGameScore(game, "fifteen - love");
		game.scores(nadal);
		checkGameScore(game, "thirty - love");
		game.scores(nadal);
		checkGameScore(game, "forty - love");
		game.scores(federer);
		checkGameScore(game, "forty - fifteen");
		game.scores(federer);
		checkGameScore(game, "forty - thirty");
		game.scores(federer);
		checkGameScore(game, "Deuce");
		game.scores(nadal);
		checkGameScore(game, "Advantage Nadal");
		game.scores(federer);
		checkGameScore(game, "Deuce");
		game.scores(federer);
		checkGameScore(game, "Advantage Federer");
		game.scores(federer);
		checkGameScore(game, "Federer wins.");
	}

	private void checkGameScore(TennisGame game, String value) {
		assertTrue("Value=" + Scoreboard.getScore(game), value.equals(Scoreboard.getScore(game)));
	}
}