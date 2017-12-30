package pwr.edu.tp.chinesecheckers;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Board extends JPanel {
	private static final long serialVersionUID = -8753997125722247972L;
	public Color board[][];
	int fieldWidth = 30;
	int activeX = -1;
	int activeY = -1;

	public void setBoardBody(Color board[][]) {
		this.board = new Color[board.length][board[0].length];
		for (int y = 0; y < this.board[0].length; y++) {
			for (int x = 0; x < this.board.length; x++) {
				this.board[x][y] = new Color(board[x][y].getRGB());
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}

	public void doDrawing(Graphics g) {
		fieldWidth = (int) Math.min((getWidth() - 20) / (13 + 12 * 0.156), (getHeight() - 20) / 17);
		Graphics2D g2d = (Graphics2D) g;

		for (int y = 0; y < board[0].length; y++) {
			for (int x = 0; x < board.length; x++) {
				Color color = board[x][y];
				if (color.getRGB() != Color.WHITE.getRGB()) {
					g2d.setPaint(color);
					g2d.fillOval((int) (10 + x * fieldWidth / 1.73), 10 + y * fieldWidth, fieldWidth, fieldWidth);
				}
			}
		}

		if ((activeX != (-1)) && (activeY != (-1))) {
			Stroke oldStroke = g2d.getStroke();
			g2d.setStroke(new BasicStroke(2));
			if (board[activeX][activeY].getRGB() == Color.BLACK.getRGB())
				g2d.setPaint(Color.YELLOW);
			else
				g2d.setPaint(Color.BLACK);
			g2d.draw(new Ellipse2D.Double((10 + activeX * fieldWidth / 1.73), 10 + activeY * fieldWidth, fieldWidth,
					fieldWidth));
			g2d.setStroke(oldStroke);
		}
	}
}