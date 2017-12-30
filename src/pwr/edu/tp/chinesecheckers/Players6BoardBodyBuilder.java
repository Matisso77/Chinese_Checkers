package pwr.edu.tp.chinesecheckers;

import java.awt.Color;

public class Players6BoardBodyBuilder implements BoardBodyBuilder {
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

		int[] fieldsNumberInRow61 = { 1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 3, 2, 1 };
		for (int y = 0; y < board[0].length; y++) {
			int tempX = ((board.length - 1) / 2) - (fieldsNumberInRow61[y] / 2) * 2 + (y % 2);
			for (int i = 0; i < fieldsNumberInRow61[y]; i++) {
				if (y < 5) {
					board[tempX][y] = Color.BLUE;
				} else {
					board[tempX][y] = Color.BLACK;
				}
				tempX += 2;
			}
		}

		int[] fieldsNumberInRow62 = { 0, 0, 0, 0, 4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int temp_vector62 = 0;
		int tempX62 = 24;
		for (int y = 0; y < board[0].length; y++) {
			tempX62 -= temp_vector62;
			if (fieldsNumberInRow62[y] != 0)
				temp_vector62++;
			for (int i = 0; i < fieldsNumberInRow62[y]; i++) {
				board[tempX62][y] = Color.RED;
				tempX62 -= 2;
			}
			tempX62 = 24;
		}

		int[] fieldsNumberInRow63 = { 0, 0, 0, 0, 4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int temp_vector63 = 0;
		int tempX63 = 0;
		for (int y = 0; y < board[0].length; y++) {
			tempX63 += temp_vector63;
			if (fieldsNumberInRow63[y] != 0)
				temp_vector63++;
			for (int i = 0; i < fieldsNumberInRow63[y]; i++) {
				board[tempX63][y] = Color.PINK;
				tempX63 += 2;
			}
			tempX63 = 0;
		}
		int[] fieldsNumberInRow64 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0 };
		int temp_vector64 = 0;
		int tempX64 = 21;
		for (int y = 0; y < board[0].length; y++) {
			tempX64 -= temp_vector64;
			if (fieldsNumberInRow64[y] != 0)
				temp_vector64++;
			for (int i = 0; i < fieldsNumberInRow64[y]; i++) {
				board[tempX64][y] = Color.GREEN;
				tempX64 += 2;
			}
			tempX64 = 21;

		}

		int[] fieldsNumberInRow65 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0 };
		int temp_vector65 = 0;
		int tempX65 = 3;
		for (int y = 0; y < board[0].length; y++) {
			tempX65 += temp_vector65;
			if (fieldsNumberInRow65[y] != 0)
				temp_vector65++;
			for (int i = 0; i < fieldsNumberInRow65[y]; i++) {
				board[tempX65][y] = Color.ORANGE;
				tempX65 -= 2;
			}
			tempX65 = 3;
		}
	}

	@Override
	public Color[][] getBoardBody() {
		return board;
	}
}