package odeville.tennisgame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import odeville.tennisgame.model.Player;
import odeville.tennisgame.model.Scoreboard;
import odeville.tennisgame.model.TennisGame;

public class App {

	public static void main(String[] args) {
		Player p1 = new Player(args[0]);
		Player p2 = new Player(args[1]);
		TennisGame game = new TennisGame(p1, p2);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (!game.getWinner().isPresent()) {
			System.out.println(String.format("Who wins the point ? Enter 1 for %s or 2 for %s:", p1, p2));
			try {
				int player = Integer.parseInt(br.readLine());
				if (player == 1) {
					game.scores(p1);
				} else if (player == 2) {
					game.scores(p2);
				} else {
					throw new IllegalArgumentException("Input should be 1 or 2.");
				}
			} catch (Exception e) {
				System.out.println("Input should be '1' or '2'...");
			}
			System.out.println(Scoreboard.getScore(game));
		}
	}

}
