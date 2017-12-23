package pwr.edu.tp.chinesecheckers;

import java.util.ArrayList;
import java.awt.Color;

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
	public synchronized boolean legalMove2(int startX, int startY, int goalX, int goalY) {
		
		if(startX + 1 == goalX && startY + 1 == goalY || startX + 1 == goalX && startY - 1 == goalY || startX -1 == goalX && startY -1 == goalY ||startX -1 == goalX && startY + 1 == goalY || startX + 2 == goalX && startY  == goalY || startX -2 == goalX && startY == goalY){
			if(goalX>=0 && goalX<25 && goalY>=0 && goalX<17){
				if(Board.board[goalX][goalY].equals("EMPTY"))
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
		        if (startX+1<25 && startY+1<17 && !Board.board[startX + 1][startY + 1].equals("EMPTY") && !Board.board[startX + 1][startY + 1].equals("NOTUSED")) {
		            if (startX+2<25 && startY+2<25 && startX + 2 == goalX && startY + 2 == goalY) {
		                return true;
		            } else if (startX+2<25 && startY+2<17 && Board.board[startX + 2][startY + 2].equals("EMPTY")) {
		                legalMove(startX + 2, startY + 2, goalX, goalY);
		            }
		        }
		        if (startX+1<25 && startY-1>=0 && !Board.board[startX + 1][startY - 1].equals("EMPTY") && !Board.board[startX + 1][startY - 1].equals("NOTUSED")) {
		            if (startX + 2 == goalX && startY - 2 == goalY) {
		                return true;
		            } else if (startX+2<25 && startY-2>=0 &&Board.board[startX + 2][startY - 2].equals("EMPTY")) {
		                legalMove(startX + 2, startY - 2, goalX, goalY);
		            }
		        }
		        if (startY+2<25 && !Board.board[startX][startY + 2].equals("EMPTY") && !Board.board[startX][startY + 2].equals("NOTUSED")) {
		            if (startX == goalX && startY + 4 == goalY) {
		                return true;
		            } else if (startY+4<25 && Board.board[startX][startY + 4].equals("EMPTY")) {
		                legalMove(startX, startY + 4, goalX, goalY);
		            }
		        }
		        if (startY-2>=0 && !Board.board[startX][startY - 2].equals("EMPTY") && !Board.board[startX][startY - 2].equals("NOTUSED")) {
		            if (startX == goalX && startY - 4 == goalY) {
		                return true;
		            } else if (startY-4>=0 && Board.board[startX][startY - 4].equals("EMPTY")) {
		                legalMove(startX, startY - 4, goalX, goalY);
		            }
		        }
		        if (startY+1<25 && startX-1>=0 &&!Board.board[startX - 1][startY + 1].equals("EMPTY") && !Board.board[startX - 1][startY + 1].equals("NOTUSED")) {
		            if (startX - 2 == goalX && startY + 2 == goalY) {
		                return true;
		            } else if (startY+2<25 && startX-2>=0 && Board.board[startX - 2][startY + 2].equals("EMPTY")) {
		                legalMove(startX - 2, startY + 2, goalX, goalY);
		            }
		        }
		        if (startX-1>=0 && startY-1>=0 &&!Board.board[startX - 1][startY - 1].equals("EMPTY") && !Board.board[startX - 1][startY - 1].equals("NOTUSED")) {
		            if (startX - 2 == goalX && startY - 2 == goalY) {
		                return true;
		            } else if (startX-2>=0 && startY-2>=0 && Board.board[startX - 2][startY - 2].equals("EMPTY")) {
		                legalMove(startX - 2, startY - 2, goalX, goalY);
		            }
		        }
		return false;
	}

	public synchronized void move(int startX, int startY, int goalX, int goalY) {
		alt.board[goalX][goalY] = alt.board[startX][startY];
		alt.board[startX][startY] = Color.GRAY;		
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
