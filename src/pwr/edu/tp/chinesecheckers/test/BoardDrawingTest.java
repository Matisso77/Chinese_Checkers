package pwr.edu.tp.chinesecheckers.test;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;

import pwr.edu.tp.chinesecheckers.AltBoard;

public class BoardDrawingTest {
	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("Board Drawing Test");
		AltBoard drawingArea = new AltBoard(6);
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		drawingArea.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.BOTH;
		frame.add(drawingArea, c);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 600);
		frame.setVisible(true);
		frame.setResizable(true);
		drawingArea.repaint();
	}
}
