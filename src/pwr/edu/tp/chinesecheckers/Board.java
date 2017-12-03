package pwr.edu.tp.chinesecheckers;

public class Board {
	public enum Fields {
		NOTUSED, EMPTY, FULL;
	}
	
	Fields board[][];
	
	public Board() {
		prepareBoard();
		addPlayesPegs();
	}
	
	private void prepareBoard() {
		board = new Fields[25][17]; //First field is 0 not 1
		
		for(int y = 0; y < board[0].length; y++) {
			for(int x = 0; x < board.length; x++) {
				board[x][y] = Fields.NOTUSED;
			}
		}
		
		int[] fieldsNumberInRow = {1,2,3,4,13,12,11,10,9,10,11,12,13,4,3,2,1}; 
		for(int y = 0; y < board[0].length; y++) {
			
			int tempX = ((board.length + 1) / 2) - (fieldsNumberInRow[y] / 2) * 2 + (y%2);
			for(int i = 0; i < fieldsNumberInRow[y]; i++) {
				board[tempX][y] = Fields.EMPTY;
				tempX+=2;	
			}
		}
	}
	
	private void addPlayesPegs() {
		// TODO MON
		
	}
}