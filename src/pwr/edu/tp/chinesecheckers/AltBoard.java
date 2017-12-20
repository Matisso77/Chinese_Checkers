package pwr.edu.tp.chinesecheckers;

import java.awt.*;
import javax.swing.JPanel;

public class AltBoard extends JPanel {
	private static final long serialVersionUID = -8753997125722247972L;
	public Color board[][];

	public AltBoard(int number_players) {
		prepareBoard();
		addPlayesPegs(number_players);
	}

	private void prepareBoard() {
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

	}

	private void addPlayesPegs(int number_players) {
		switch (number_players) {
		case 2:
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
			break;

		case 3:
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
			break;

		case 4:
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
			break;

		case 6:

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
			break;
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}

	public void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		for (int y = 0; y < board[0].length; y++) {
			for (int x = 0; x < board.length; x++) {
				Color color = board[x][y];
				if (color.getRGB() != Color.WHITE.getRGB()) {
					g2d.setPaint(color);
					int szer = 30;
					g2d.fillOval((int) (10 + x * szer / 1.73), 10 + y * szer, szer, szer);
				}
			}
		}
	}
}
