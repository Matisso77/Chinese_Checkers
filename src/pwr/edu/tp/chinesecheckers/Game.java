package pwr.edu.tp.chinesecheckers;

import java.util.ArrayList;
import java.awt.Color;

public class Game {
	public Player currentPlayer;
	Board board;
	boolean wasHere[][];
	ArrayList<Player> players = new ArrayList<>();
	int playersCount;
	boolean started = false;
	boolean finished = false;
	
	public Game(int size) {
		players = new ArrayList<Player>();
		playersCount = size;
		BoardAssembler assembler = new BoardAssembler();
		switch(size) {
		case 2: board = assembler.getBoard(new Players2BoardBodyBuilder());
			break;
		case 3: board = assembler.getBoard(new Players3BoardBodyBuilder());
			break;
		case 4: board = assembler.getBoard(new Players4BoardBodyBuilder());
			break;
		case 6: board = assembler.getBoard(new Players6BoardBodyBuilder());
			break;
		}
		wasHere = new boolean [25][17];
		refresh();
	}

	private void refresh() {
		for (int y = 0; y < board.board[0].length; y++) {
			for (int x = 0; x < board.board.length; x++) {
				wasHere[x][y] = false;
			}
		}
		
	}

	public boolean hasWinner(Color color) {
		int winner;
		winner = 0;
		if (color == Color.BLACK) {
			int[] fieldsNumberInRow61 = { 1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			for (int y = 0; y < board.board[0].length; y++) {

				int tempX = ((board.board.length - 1) / 2) - (fieldsNumberInRow61[y] / 2) * 2 + (y % 2);
				for (int i = 0; i < fieldsNumberInRow61[y]; i++) {
					if (board.board[tempX][y] == Color.BLACK){
						winner++;
					}
					tempX += 2;
				}
				
			}
			if (winner == 10) {
				System.out.println("Black ends");
				return true;
			}
		}

		else if (color == Color.BLUE) {
			int[] fieldsNumberInRow61 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 3, 2, 1 };
			for (int y = 0; y < board.board[0].length; y++) {

				int tempX = ((board.board.length - 1) / 2) - (fieldsNumberInRow61[y] / 2) * 2 + (y % 2);
				for (int i = 0; i < fieldsNumberInRow61[y]; i++) {
					if (board.board[tempX][y] == Color.BLUE){
						winner++;
					}
					tempX += 2;
				}
				if (winner == 10) {
					System.out.println("Blue ends");
					return true;
				}
			}
		} else if (color == Color.ORANGE) {
			int[] fieldsNumberInRow62 = { 0, 0, 0, 0, 4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			int temp_vector62 = 0;
			int tempX62 = 24;
			for (int y = 0; y < board.board[0].length; y++) {

				tempX62 -= temp_vector62;
				if (fieldsNumberInRow62[y] != 0)
					temp_vector62++;
				for (int i = 0; i < fieldsNumberInRow62[y]; i++) {
					if (board.board[tempX62][y] == Color.ORANGE)
						winner++;
					tempX62 -= 2;
				}
				tempX62 = 24;
				if (winner == 10) {
					System.out.println("Orange ends");
					return true;
				}
			}
		} else if (color == Color.GREEN) {
			int[] fieldsNumberInRow63 = { 0, 0, 0, 0, 4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			int temp_vector63 = 0;
			int tempX63 = 0;
			for (int y = 0; y < board.board[0].length; y++) {

				tempX63 += temp_vector63;
				if (fieldsNumberInRow63[y] != 0)
					temp_vector63++;
				for (int i = 0; i < fieldsNumberInRow63[y]; i++) {
					if (board.board[tempX63][y] == Color.GREEN){
						winner++;
					}
					tempX63 += 2;
				}
				tempX63 = 0;
				if (winner == 10) {
					System.out.println("Green ends");
					return true;
				}
			}
		} else if (color == Color.PINK) {
			int[] fieldsNumberInRow64 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0 };
			int temp_vector64 = 0;
			int tempX64 = 21;
			for (int y = 0; y < board.board[0].length; y++) {

				tempX64 -= temp_vector64;
				if (fieldsNumberInRow64[y] != 0)
					temp_vector64++;
				for (int i = 0; i < fieldsNumberInRow64[y]; i++) {
					if (board.board[tempX64][y] == Color.PINK){
						winner++;
					}
					tempX64 += 2;
				}
				tempX64 = 21;
				if (winner == 10) {
					System.out.println("Pink ends");
					return true;
				}
			}
		} else if (color == Color.RED) {
			int[] fieldsNumberInRow65 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0 };
			int temp_vector65 = 0;
			int tempX65 = 3;
			for (int y = 0; y < board.board[0].length; y++) {

				tempX65 += temp_vector65;
				if (fieldsNumberInRow65[y] != 0)
					temp_vector65++;
				for (int i = 0; i < fieldsNumberInRow65[y]; i++) {
					if (board.board[tempX65][y] == Color.RED){
						winner++;
					}

					tempX65 -= 2;
				}
				tempX65 = 3;
				if (winner == 10) {
					System.out.println("Red wins");
					return true;
				}
			}
		}
		return false;
	}
	public boolean pegNotInTriangle(int startX, int startY, int goalX, int goalY, Color color){
		int isThere, wantIn;
		isThere=0;
		wantIn=0;
		if (color == Color.BLACK) {
			int[] fieldsNumberInRow61 = { 1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			for (int y = 0; y < board.board[0].length; y++) {

				int tempX = ((board.board.length - 1) / 2) - (fieldsNumberInRow61[y] / 2) * 2 + (y % 2);
				for (int i = 0; i < fieldsNumberInRow61[y]; i++) {
					if (tempX == startX && y == startY){
						isThere++;
					}
					tempX += 2;
				}
				
			}
			for (int y = 0; y < board.board[0].length; y++) {

				int tempX = ((board.board.length - 1) / 2) - (fieldsNumberInRow61[y] / 2) * 2 + (y % 2);
				for (int i = 0; i < fieldsNumberInRow61[y]; i++) {
					if (tempX == goalX && y == goalY){
						wantIn++;
					}
					tempX += 2;
				}
				
			}
		}

		else if (color == Color.BLUE) {
			int[] fieldsNumberInRow61 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 3, 2, 1 };
			for (int y = 0; y < board.board[0].length; y++) {

				int tempX = ((board.board.length - 1) / 2) - (fieldsNumberInRow61[y] / 2) * 2 + (y % 2);
				for (int i = 0; i < fieldsNumberInRow61[y]; i++) {
					if (tempX == startX && y == startY){
						isThere++;
					}
					tempX += 2;
				}
			}
			for (int y = 0; y < board.board[0].length; y++) {

				int tempX = ((board.board.length - 1) / 2) - (fieldsNumberInRow61[y] / 2) * 2 + (y % 2);
				for (int i = 0; i < fieldsNumberInRow61[y]; i++) {
					if (tempX == goalX && y == goalY){
						wantIn++;
					}
					tempX += 2;
				}
			}
		} else if (color == Color.ORANGE) {
			int[] fieldsNumberInRow62 = { 0, 0, 0, 0, 4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			int temp_vector62 = 0;
			int tempX62 = 24;
			for (int y = 0; y < board.board[0].length; y++) {

				tempX62 -= temp_vector62;
				if (fieldsNumberInRow62[y] != 0)
					temp_vector62++;
				for (int i = 0; i < fieldsNumberInRow62[y]; i++) {
					if (tempX62 == startX && y == startY){
						isThere++;
					}
					tempX62 -= 2;
				}
				tempX62 = 24;
				
			}
			temp_vector62 = 0;
			tempX62 = 24;
			for (int y = 0; y < board.board[0].length; y++) {

				tempX62 -= temp_vector62;
				if (fieldsNumberInRow62[y] != 0)
					temp_vector62++;
				for (int i = 0; i < fieldsNumberInRow62[y]; i++) {
					if (tempX62 == goalX && y == goalY){
						wantIn++;
					}
					tempX62 -= 2;
				}
				tempX62 = 24;
				
			}
		} else if (color == Color.GREEN) {
			int[] fieldsNumberInRow63 = { 0, 0, 0, 0, 4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			int temp_vector63 = 0;
			int tempX63 = 0;
			for (int y = 0; y < board.board[0].length; y++) {

				tempX63 += temp_vector63;
				if (fieldsNumberInRow63[y] != 0)
					temp_vector63++;
				for (int i = 0; i < fieldsNumberInRow63[y]; i++) {
					if (tempX63 == startX && y == startY){
						isThere++;
					}
					tempX63 += 2;
				}
				tempX63 = 0;
				
			}
			temp_vector63 = 0;
			tempX63 = 0;
			for (int y = 0; y < board.board[0].length; y++) {

				tempX63 += temp_vector63;
				if (fieldsNumberInRow63[y] != 0)
					temp_vector63++;
				for (int i = 0; i < fieldsNumberInRow63[y]; i++) {
					if (tempX63 == goalX && y == goalY){
						wantIn++;
					}
					tempX63 += 2;
				}
				tempX63 = 0;
				
			}
		} else if (color == Color.PINK) {
			int[] fieldsNumberInRow64 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0 };
			int temp_vector64 = 0;
			int tempX64 = 21;
			for (int y = 0; y < board.board[0].length; y++) {

				tempX64 -= temp_vector64;
				if (fieldsNumberInRow64[y] != 0)
					temp_vector64++;
				for (int i = 0; i < fieldsNumberInRow64[y]; i++) {
					if (tempX64 == startX && y == startY){
						isThere++;
					}
					tempX64 += 2;
				}
				tempX64 = 21;
			}
			temp_vector64 = 0;
			tempX64 = 21;
			for (int y = 0; y < board.board[0].length; y++) {

				tempX64 -= temp_vector64;
				if (fieldsNumberInRow64[y] != 0)
					temp_vector64++;
				for (int i = 0; i < fieldsNumberInRow64[y]; i++) {
					if (tempX64 == goalX && y == goalY){
						wantIn++;
					}
					tempX64 += 2;
				}
				tempX64 = 21;
			}
		} else if (color == Color.RED) {
			int[] fieldsNumberInRow65 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0 };
			int temp_vector65 = 0;
			int tempX65 = 3;
			for (int y = 0; y < board.board[0].length; y++) {

				tempX65 += temp_vector65;
				if (fieldsNumberInRow65[y] != 0)
					temp_vector65++;
				for (int i = 0; i < fieldsNumberInRow65[y]; i++) {
					if (tempX65 == startX && y == startY){
						isThere++;
					}

					tempX65 -= 2;
				}
				tempX65 = 3;
				
			}
			temp_vector65 = 0;
			tempX65 = 3;
			for (int y = 0; y < board.board[0].length; y++) {

				tempX65 += temp_vector65;
				if (fieldsNumberInRow65[y] != 0)
					temp_vector65++;
				for (int i = 0; i < fieldsNumberInRow65[y]; i++) {
					if (tempX65 == goalX && y == goalY){
						wantIn++;
					}

					tempX65 -= 2;
				}
				tempX65 = 3;
				
			}
		}
		if(isThere==1 && wantIn!=1)
			return false;
		else
			return true;
	}
	public boolean legalMove3(int startX, int startY, int goalX, int goalY, Player player, Color color) {
		if (legalMove2(startX, startY, goalX, goalY, player) && pegNotInTriangle(startX, startY, goalX, goalY, color))
			return true;
		else
			return false;
		

	}
	
	public boolean legalMove2(int startX, int startY, int goalX, int goalY, Player player) {
		if (player.color.getRGB() != board.board[startX][startY].getRGB())
			return false;

		if (startX + 1 == goalX && startY + 1 == goalY || startX + 1 == goalX && startY - 1 == goalY
				|| startX - 1 == goalX && startY - 1 == goalY || startX - 1 == goalX && startY + 1 == goalY
				|| startX + 2 == goalX && startY == goalY || startX - 2 == goalX && startY == goalY) {
			if(goalX<25&&goalX>=0&&goalY<17&&goalY>=0){
				if (board.board[goalX][goalY].getRGB() == Color.GRAY.getRGB())
					return true;
				else
					return false;
			}else
				return false;
		
			
		} else{
			refresh();
			return legalMove(startX, startY, goalX, goalY);
		}
			

	}

	public boolean legalMove(int startX, int startY, int goalX, int goalY) {
		wasHere[startX][startY]=true;
		if (startX + 1 < 25 && startY + 1 < 17 && !(board.board[startX + 1][startY + 1].getRGB() == Color.GRAY.getRGB())
				&& !(board.board[startX + 1][startY + 1].getRGB() == Color.WHITE.getRGB())) {
			if (startX + 2 < 25 && startY + 2 < 17 && startX + 2 == goalX && startY + 2 == goalY
					&& board.board[startX + 2][startY + 2].getRGB() == Color.GRAY.getRGB()) {
				return true;
			} else if (startX + 2 < 25 && startY + 2 < 17 && !(wasHere[startX+2][startY+2])
					&& board.board[startX + 2][startY + 2].getRGB() == Color.GRAY.getRGB()) {
				
				if (legalMove(startX + 2, startY + 2, goalX, goalY))
					return true;
			}
		}
		if (startX + 1 < 25 && startY - 1 >= 0 && !(board.board[startX + 1][startY - 1].getRGB() == Color.GRAY.getRGB())
				&& !(board.board[startX + 1][startY - 1].getRGB() == Color.WHITE.getRGB())) {
			if (startX + 2 == goalX && startY - 2 == goalY 
					&& board.board[startX + 2][startY - 2].getRGB() == Color.GRAY.getRGB()) {
				return true;
			} else if (startX + 2 < 25 && startY - 2 >= 0 && !((wasHere[startX+2][startY-2])
					&& board.board[startX + 2][startY - 2].getRGB() == Color.GRAY.getRGB()))
			{
				
				if (legalMove(startX + 2, startY - 2, goalX, goalY))
					return true;
			}
		}
		if (startX + 2 < 25 && !(board.board[startX + 2][startY].getRGB() == Color.GRAY.getRGB())
				&& !(board.board[startX + 2][startY].getRGB() == Color.WHITE.getRGB())) {
			if (startX + 4 == goalX && startY == goalY
					&& board.board[startX + 4][startY].getRGB() == Color.GRAY.getRGB()) {
				return true;
			} else if (startX + 4 < 25 && !(wasHere[startX +4] [startY])
					&& board.board[startX + 4][startY].getRGB() == Color.GRAY.getRGB()) {
				
				if (legalMove(startX + 4, startY, goalX, goalY))
					return true;
			}
		}
		if (startX - 2 >= 0 && !(board.board[startX - 2][startY].getRGB() == Color.GRAY.getRGB())
				&& !(board.board[startX - 2][startY].getRGB() == Color.WHITE.getRGB())) {
			if (startX - 4 == goalX && startY == goalY
					&& board.board[startX - 4][startY].getRGB() == Color.GRAY.getRGB()) {
				return true;
			} else if (startX - 4 >= 0 && !(wasHere[startX -4] [startY])
					&& board.board[startX - 4][startY].getRGB() == Color.GRAY.getRGB()) {
				if (legalMove(startX - 4, startY, goalX, goalY))
					return true;
			}
		}
		if (startY + 1 < 17 && startX - 1 >= 0 && !(board.board[startX - 1][startY + 1].getRGB() == Color.GRAY.getRGB())
				&& !(board.board[startX - 1][startY + 1].getRGB() == Color.WHITE.getRGB())) {
			if (startX - 2 == goalX && startY + 2 == goalY
					&& board.board[startX - 2][startY + 2].getRGB() == Color.GRAY.getRGB()) {
				return true;
			} else if (startY + 2 < 17 && startX - 2 >= 0 && !(wasHere[startX -2] [startY+2])
					&& board.board[startX - 2][startY + 2].getRGB() == Color.GRAY.getRGB()) {
				if (legalMove(startX - 2, startY + 2, goalX, goalY))
					return true;
			}
		}
		if (startX - 1 >= 0 && startY - 1 >= 0 && !(board.board[startX - 1][startY - 1].getRGB() == Color.GRAY.getRGB())
				&& !(board.board[startX - 1][startY - 1].getRGB() == Color.WHITE.getRGB())) {
			if (startX - 2 == goalX && startY - 2 == goalY
					&& board.board[startX - 2][startY - 2].getRGB() == Color.GRAY.getRGB()) {
				return true;
			} else if (startX - 2 >= 0 && startY - 2 >= 0 && !(wasHere[startX -2] [startY-2])
					&& board.board[startX - 2][startY - 2].getRGB() == Color.GRAY.getRGB()
		) {
				if (legalMove(startX - 2, startY - 2, goalX, goalY))
					return true;
			}
		}
		return false;
	}

	public synchronized void move(int startX, int startY, int goalX, int goalY) {
		board.board[goalX][goalY] = board.board[startX][startY];
		board.board[startX][startY] = Color.GRAY;
	}

	public synchronized void playerDone(Player player) {
		if (player == currentPlayer) {
			if (hasWinner(player.color)) {
				player.youFinished();
				for (Player p : players) {
					if (p.nextPlayer == player) {
						p.nextPlayer = player.nextPlayer;
						break;
					}
				}
				players.remove(player);
				if (players.isEmpty()) {
					finished = true;
					return;
				}
				
				boolean flag = true;
				for (Player p: players) {
					if(p instanceof RealPlayer) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					endGame(player);
					return;
				}				
			}
			currentPlayer = currentPlayer.nextPlayer;
			for (Player p : players) {
				p.sendBoard(board.board);
				if (p != currentPlayer)
					p.otherPlayerDone(currentPlayer.colorS);
			}
			currentPlayer.yourMove();

		}
	}
	
	public synchronized void endGame(Player player) {
		for (Player p : players) {
			if(p != player) {
				p.end();
			}
		}
		players.clear();
		finished = true;
	}
}
