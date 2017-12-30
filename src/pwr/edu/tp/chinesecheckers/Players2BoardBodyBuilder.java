package pwr.edu.tp.chinesecheckers;

import java.awt.Color;

public class Players2BoardBodyBuilder implements BoardBodyBuilder {
	Color[][] board;

	@Override
	public void generate() {
		board = new Color[25][17]; // First field is 0 not 1

		for (int y = 0; y < board[0].length; y++) {
			for (int x = 0; x < board.length; x++) {
				board[x][y] = Color.WHITE;
			}
		}

		int[] fieldsNumberInRow = { 1, 2, 3, 4, 13, 12, 11, 10, 9, 10, 11, 12, 13, 4, 3, 2, 1 };
		for (int y = 0; y < board[0].length; y++) {
			int tempX = ((board.length - 1) / 2) - (fieldsNumberInRow[y] / 2) * 2 + (y % 2);
			for (int i = 0; i < fieldsNumberInRow[y]; i++) {
				board[tempX][y] = Color.GRAY;
				tempX += 2;
			}
		}

		int[] fieldsNumberInRow2 = { 1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 3, 2, 1 };
		for (int y = 0; y < board[0].length; y++) {
			int tempX2 = ((board.length - 1) / 2) - (fieldsNumberInRow2[y] / 2) * 2 + (y % 2);
			for (int i = 0; i < fieldsNumberInRow2[y]; i++) {
				if (y < 5) {
					board[tempX2][y] = Color.BLUE;
				} else
					board[tempX2][y] = Color.BLACK;
				tempX2 += 2;
			}
		}
	}

	@Override
	public Color[][] getBoardBody() {
		return board;
	}
}