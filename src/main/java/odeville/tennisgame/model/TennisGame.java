package odeville.tennisgame.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TennisGame {

	private final Player player1;
	private final Player player2;
	private final Map<Player, Integer> score;

	public TennisGame(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		score = new HashMap<>();
		score.put(player1, 0);
		score.put(player2, 0);
	}

	/**
	 * A game is won by the first player to have won at least four points in
	 * total and at least two points more than the opponent.
	 * 
	 */
	public Optional<Player> getWinner() {
		if (score.get(player1) > 3 && score.get(player1) - score.get(player2) > 1) {
			return Optional.of(player1);
		}
		if (score.get(player2) > 3 && score.get(player2) - score.get(player1) > 1) {
			return Optional.of(player2);
		}
		return Optional.empty();
	}

	/**
	 * If at least three points have been scored by each side and a player has
	 * one more point than his opponent, the score of the game is “advantage”
	 * for the player in the lead.
	 * 
	 */
	public Optional<Player> getAdvantage() {
		if (score.get(player1) > 2 && score.get(player2) > 2 && score.get(player1) > score.get(player2)) {
			return Optional.of(player1);
		}
		if (score.get(player1) > 2 && score.get(player2) > 2 && score.get(player2) > score.get(player1)) {
			return Optional.of(player2);
		}
		return Optional.empty();
	}
	/**
	 * If at least three points have been scored by each player, and the scores
	 * are equal, the score is “deuce”.
	 * 
	 **/
	public boolean isDeuce() {
		return score.get(player1) > 2 && score.get(player1) == score.get(player2);
	}

	public void scores(Player player) {
		score.put(player, score.get(player) + 1);
	}

	public int getScore(Player player) {
		return score.get(player);
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}
}
