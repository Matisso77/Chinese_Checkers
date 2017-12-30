package pwr.edu.tp.chinesecheckers;

import java.awt.Color;

public class Players4BoardBodyBuilder implements BoardBodyBuilder {
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

		int[] fieldsNumberInRow41 = { 0, 0, 0, 0, 4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int temp_vector41 = 0;
		int tempX41 = 24;
		for (int y = 0; y < board[0].length; y++) {
			tempX41 -= temp_vector41;
			if (fieldsNumberInRow41[y] != 0)
				temp_vector41++;
			for (int i = 0; i < fieldsNumberInRow41[y]; i++) {
				board[tempX41][y] = Color.RED;
				tempX41 -= 2;
			}
			tempX41 = 24;
		}

		int[] fieldsNumberInRow42 = { 0, 0, 0, 0, 4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int temp_vector42 = 0;
		int tempX42 = 0;
		for (int y = 0; y < board[0].length; y++) {
			tempX42 += temp_vector42;
			if (fieldsNumberInRow42[y] != 0)
				temp_vector42++;
			for (int i = 0; i < fieldsNumberInRow42[y]; i++) {
				board[tempX42][y] = Color.PINK;
				tempX42 += 2;
			}
			tempX42 = 0;
		}
		int[] fieldsNumberInRow43 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0 };
		int temp_vector43 = 0;
		int tempX43 = 21;
		for (int y = 0; y < board[0].length; y++) {
			tempX43 -= temp_vector43;
			if (fieldsNumberInRow43[y] != 0)
				temp_vector43++;
			for (int i = 0; i < fieldsNumberInRow43[y]; i++) {
				board[tempX43][y] = Color.GREEN;
				tempX43 += 2;
			}
			tempX43 = 21;
		}

		int[] fieldsNumberInRow44 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0 };
		int temp_vector44 = 0;
		int tempX44 = 3;
		for (int y = 0; y < board[0].length; y++) {
			tempX44 += temp_vector44;
			if (fieldsNumberInRow44[y] != 0)
				temp_vector44++;
			for (int i = 0; i < fieldsNumberInRow44[y]; i++) {
				board[tempX44][y] = Color.ORANGE;
				tempX44 -= 2;
			}
			tempX44 = 3;
		}
	}

	@Override
	public Color[][] getBoardBody() {
		return board;
	}
}