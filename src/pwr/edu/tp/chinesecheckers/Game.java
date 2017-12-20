package pwr.edu.tp.chinesecheckers;

import java.util.ArrayList;

public class Game {
	public Player currentPlayer;
	private Board board;
	AltBoard alt;
	ArrayList<Player> players = new ArrayList<>();
	int playersCount;
	boolean started = false;

	public Game(int size) {
		players = new ArrayList<Player>();
		playersCount = size;
		board = new Board(size);
		alt = new AltBoard(size);
	}

	public boolean hasWinner() {
		// TODO
		return false;
	}

	public synchronized boolean legalMove(int startX, int startY, int goalX, int goalY) {
		        if (!Board.board[startX + 1][startY + 1].equals("EMPTY") && !Board.board[startX + 1][startY + 1].equals("BLOCKED")) {
		            if (startX + 2 == goalX && startY + 2 == goalY) {
		                return true;
		            } else if (Board.board[startX + 2][startY + 2].equals("EMPTY")) {
		                legalMove(startX + 2, startY + 2, goalX, goalY);
		            }
		        }
		        if (!Board.board[startX + 1][startY - 1].equals("EMPTY") && !Board.board[startX + 1][startY + 1].equals("BLOCKED")) {
		            if (startX + 2 == goalX && startY - 2 == goalY) {
		                return true;
		            } else if (Board.board[startX + 2][startY - 2].equals("EMPTY")) {
		                legalMove(startX + 2, startY - 2, goalX, goalY);
		            }
		        }
		        if (!Board.board[startX][startY + 2].equals("EMPTY") && !Board.board[startX + 1][startY + 1].equals("BLOCKED")) {
		            if (startX == goalX && startY + 4 == goalY) {
		                return true;
		            } else if (Board.board[startX][startY + 4].equals("EMPTY")) {
		                legalMove(startX, startY + 4, goalX, goalY);
		            }
		        }
		        if (!Board.board[startX][startY - 2].equals("EMPTY") && !Board.board[startX + 1][startY + 1].equals("BLOCKED")) {
		            if (startX == goalX && startY - 4 == goalY) {
		                return true;
		            } else if (Board.board[startX][startY - 4].equals("EMPTY")) {
		                legalMove(startX, startY - 4, goalX, goalY);
		            }
		        }
		        if (!Board.board[startX - 1][startY + 1].equals("EMPTY") && !Board.board[startX + 1][startY + 1].equals("BLOCKED")) {
		            if (startX - 2 == goalX && startY + 2 == goalY) {
		                return true;
		            } else if (Board.board[startX - 2][startY + 2].equals("EMPTY")) {
		                legalMove(startX - 2, startY + 2, goalX, goalY);
		            }
		        }
		        if (!Board.board[startX - 1][startY - 1].equals("EMPTY") && !Board.board[startX + 1][startY + 1].equals("BLOCKED")) {
		            if (startX - 2 == goalX && startY - 2 == goalY) {
		                return true;
		            } else if (Board.board[startX - 2][startY - 2].equals("EMPTY")) {
		                legalMove(startX - 2, startY - 2, goalX, goalY);
		            }
		        }
		return false;
	}

	public synchronized void playerDone(Player player) {
		if (player == currentPlayer) {
			currentPlayer = currentPlayer.nextPlayer;
			currentPlayer.yourMove();
			for (Player p : players) {
				p.sendBoard(alt);
				if (p != currentPlayer)
					p.otherPlayerDone(currentPlayer.colorS);
			}
		}
	}
}
