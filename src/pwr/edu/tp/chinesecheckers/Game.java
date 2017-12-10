package pwr.edu.tp.chinesecheckers;

import java.util.ArrayList;

public class Game {
	public Player currentPlayer;
	private Board board;
	ArrayList<Player> players;

	public Game() {
		players = new ArrayList<Player>();
	}

	public boolean hasWinner() {
		// TODO
		return false;
	}

	public synchronized boolean legalMove(int start, int end, Player player) {
		// TODO
		return false;
	}

	public synchronized void playerDone(Player player) {
		if (player == currentPlayer) {
			currentPlayer = currentPlayer.nextPlayer;
			currentPlayer.yourMove();
			for (Player p : players) {
				if (p != currentPlayer)
					p.otherPlayerDone(currentPlayer.color.ordinal());
			}
		}
	}
}
