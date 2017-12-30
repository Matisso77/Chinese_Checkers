package pwr.edu.tp.chinesecheckers;

import java.awt.Color;

public class Players3BoardBodyBuilder implements BoardBodyBuilder {
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

		int[] fieldsNumberInRow31 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 3, 2, 1 };
		for (int y = 0; y < board[0].length; y++) {
			int tempX = ((board.length - 1) / 2) - (fieldsNumberInRow31[y] / 2) * 2 + (y % 2);
			for (int i = 0; i < fieldsNumberInRow31[y]; i++) {
				board[tempX][y] = Color.BLACK;

				tempX += 2;
			}

		}
		int[] fieldsNumberInRow32 = { 0, 0, 0, 0, 4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int temp_vector32 = 0;
		int tempX32 = 24;
		for (int y = 0; y < board[0].length; y++) {
			tempX32 -= temp_vector32;
			if (fieldsNumberInRow32[y] != 0)
				temp_vector32++;
			for (int i = 0; i < fieldsNumberInRow32[y]; i++) {
				board[tempX32][y] = Color.RED;
				tempX32 -= 2;

			}
			tempX32 = 24;

		}

		int[] fieldsNumberInRow33 = { 0, 0, 0, 0, 4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int temp_vector33 = 0;
		int tempX33 = 0;
		for (int y = 0; y < board[0].length; y++) {
			tempX33 += temp_vector33;
			if (fieldsNumberInRow33[y] != 0)
				temp_vector33++;
			for (int i = 0; i < fieldsNumberInRow33[y]; i++) {
				board[tempX33][y] = Color.PINK;
				tempX33 += 2;
			}
			tempX33 = 0;
		}
	}

	@Override
	public Color[][] getBoardBody() {
		return board;
	}
}