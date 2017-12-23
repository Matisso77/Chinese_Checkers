package pwr.edu.tp.chinesecheckers;

import java.util.ArrayList;
import java.awt.Color;

public class Game {
	public Player currentPlayer;
	Board board;
	ArrayList<Player> players = new ArrayList<>();
	int playersCount;
	boolean started = false;

	public Game(int size) {
		players = new ArrayList<Player>();
		playersCount = size;
		board = new Board(size);
	}

	public boolean hasWinner() {
		// TODO
		return false;
	}
	public synchronized boolean legalMove2(int startX, int startY, int goalX, int goalY) {
		
		if(startX + 1 == goalX && startY + 1 == goalY || startX + 1 == goalX && startY - 1 == goalY || startX -1 == goalX && startY -1 == goalY ||startX -1 == goalX && startY + 1 == goalY || startX + 2 == goalX && startY  == goalY || startX -2 == goalX && startY == goalY){
			if(goalX>=0 && goalX<25 && goalY>=0 && goalX<17){
				if(board.board[goalX][goalY].getRGB() == Color.GRAY.getRGB())
							return true;
					else 
						return false;
			}
			else 
				return false;
		}else	
			return legalMove(startX, startY, goalX, goalY);
	
	}
	public synchronized boolean legalMove(int startX, int startY, int goalX, int goalY) {
		        if (startX+1<25 && startY+1<17 && !(board.board[startX + 1][startY + 1].getRGB() == Color.GRAY.getRGB()) && !(board.board[startX + 1][startY + 1].getRGB() == Color.WHITE.getRGB())) {
		            if (startX+2<25 && startY+2<25 && startX + 2 == goalX && startY + 2 == goalY) {
		                return true;
		            } else if (startX+2<25 && startY+2<17 && board.board[startX + 2][startY + 2].getRGB() == Color.GRAY.getRGB()) {
		                legalMove(startX + 2, startY + 2, goalX, goalY);
		            }
		        }
		        if (startX+1<25 && startY-1>=0 && !(board.board[startX + 1][startY - 1].getRGB() == Color.GRAY.getRGB()) && !(board.board[startX + 1][startY - 1].getRGB() == Color.WHITE.getRGB())) {
		            if (startX + 2 == goalX && startY - 2 == goalY) {
		                return true;
		            } else if (startX+2<25 && startY-2>=0 &&board.board[startX + 2][startY - 2].getRGB() == Color.GRAY.getRGB()) {
		                legalMove(startX + 2, startY - 2, goalX, goalY);
		            }
		        }
		        if (startY+2<25 && !(board.board[startX][startY + 2].getRGB() == Color.GRAY.getRGB()) && !(board.board[startX][startY + 2].getRGB() == Color.WHITE.getRGB())) {
		            if (startX == goalX && startY + 4 == goalY) {
		                return true;
		            } else if (startY+4<25 && board.board[startX][startY + 4].getRGB() == Color.GRAY.getRGB()) {
		                legalMove(startX, startY + 4, goalX, goalY);
		            }
		        }
		        if (startY-2>=0 && !(board.board[startX][startY - 2].getRGB() == Color.GRAY.getRGB()) && !(board.board[startX][startY - 2].getRGB() == Color.WHITE.getRGB())) {
		            if (startX == goalX && startY - 4 == goalY) {
		                return true;
		            } else if (startY-4>=0 && board.board[startX][startY - 4].getRGB() == Color.GRAY.getRGB()) {
		                legalMove(startX, startY - 4, goalX, goalY);
		            }
		        }
		        if (startY+1<25 && startX-1>=0 &&!(board.board[startX - 1][startY + 1].getRGB() == Color.GRAY.getRGB()) && !(board.board[startX - 1][startY + 1].getRGB() == Color.WHITE.getRGB())) {
		            if (startX - 2 == goalX && startY + 2 == goalY) {
		                return true;
		            } else if (startY+2<25 && startX-2>=0 && board.board[startX - 2][startY + 2].getRGB() == Color.GRAY.getRGB()) {
		                legalMove(startX - 2, startY + 2, goalX, goalY);
		            }
		        }
		        if (startX-1>=0 && startY-1>=0 &&!(board.board[startX - 1][startY - 1].getRGB() == Color.GRAY.getRGB()) && !(board.board[startX - 1][startY - 1].getRGB() == Color.WHITE.getRGB())) {
		            if (startX - 2 == goalX && startY - 2 == goalY) {
		                return true;
		            } else if (startX-2>=0 && startY-2>=0 && board.board[startX - 2][startY - 2].getRGB() == Color.GRAY.getRGB()) {
		                legalMove(startX - 2, startY - 2, goalX, goalY);
		            }
		        }
		return false;
	}

	public synchronized void move(int startX, int startY, int goalX, int goalY, Player player) {
		board.move( startX, startY, goalX, goalY);	
		player.sendBoard();
	}
	
	public synchronized void playerDone(Player player) {
		if (player == currentPlayer) {
			currentPlayer = currentPlayer.nextPlayer;
			currentPlayer.yourMove();
			for (Player p : players) {
				p.sendBoard();
				if (p != currentPlayer)
					p.otherPlayerDone(currentPlayer.colorS);
			}
		}
	}
}
