package pwr.edu.tp.chinesecheckers;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Client {
	private static int port = 8901;
	private Socket socket;
	private String colorS;
	private Color color;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private JFrame frame = new JFrame("Chinese Checkers");
	private JLabel messageLabel = new JLabel("");
	private Board drawingArea;
	private JButton button = new JButton("Done");

	public Client(String serverAddress) {
		try {
			socket = new Socket(serverAddress, port);
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Unknown host!", "ERROR", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not establish connection with server!", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(1);
		}
		try {
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not establish connection with server!", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(1);
		}
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not establish connection with server!", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(1);
		}
		
		Object[] possibilities = { 2, 3, 4, 6 };
		int s;
		Object o = null;
		do {
			o = JOptionPane.showInputDialog(frame, "How many players there should be in your game?",
					"Choose number of players", JOptionPane.PLAIN_MESSAGE, null, possibilities, 2);
		} while (o == null);
		s = (int) o;
		
		String bots = "NO";
		if (JOptionPane.showConfirmDialog(frame, "Do you want to play with bots?", "How about bots?",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		    bots = "YES";
		} 
		
		try {
			out.writeObject(s);
			out.writeObject(bots);
			out.flush();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Lost connection!", "ERROR", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(1);
		}

		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 1;
		frame.add(messageLabel, c);
		c.gridx = 1;
		c.gridy = 0;
		frame.add(button, c);
		button.setEnabled(false);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					out.writeObject("DONE");
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
					end();
				}
			}
		});

		BoardAssembler assembler = new BoardAssembler();
		drawingArea = assembler.getBoard(new EmptyBoardBodyBuilder());
		
		drawingArea.addMouseListener(new MouseAdapter() {
			int clickCounter = 0;
			int startX, startY, goalX, goalY;
			boolean missClick = true;

			@Override
			public void mousePressed(MouseEvent e) {
				missClick = true;
				clickCounter++;
				int mX, mY;

				if (clickCounter == 1) {
					mX = e.getX();
					mY = e.getY();

					for (int y = 0; y < drawingArea.board[0].length; y++) {
						for (int x = 0; x < drawingArea.board.length; x++) {
							Color tmpcolor = drawingArea.board[x][y];
							if (tmpcolor.getRGB() == color.getRGB()) {
								if ((Math.hypot(
										(int) (10 + drawingArea.fieldWidth / 2 + x * drawingArea.fieldWidth / 1.73
												- mX),
										10 + drawingArea.fieldWidth / 2 + y * drawingArea.fieldWidth
												- mY) <= drawingArea.fieldWidth / 2)) {
									drawingArea.activeX = x;
									drawingArea.activeY = y;
									startX = x;
									startY = y;
									drawingArea.repaint();
									missClick = false;
								}
							}
						}
					}

					if (missClick) {
						drawingArea.activeX = -1;
						drawingArea.activeY = -1;
						clickCounter--;
						drawingArea.repaint();
					}

				} else if (clickCounter == 2) {
					mX = e.getX();
					mY = e.getY();

					for (int y = 0; y < drawingArea.board[0].length; y++) {
						for (int x = 0; x < drawingArea.board.length; x++) {
							Color color = drawingArea.board[x][y];
							if (color.getRGB() == Color.GRAY.getRGB()) {
								if ((Math.hypot(
										(int) (10 + drawingArea.fieldWidth / 2 + x * drawingArea.fieldWidth / 1.73
												- mX),
										10 + drawingArea.fieldWidth / 2 + y * drawingArea.fieldWidth
												- mY) <= drawingArea.fieldWidth / 2)) {
									goalX = x;
									goalY = y;
									missClick = false;
								}
							}
						}
					}

					drawingArea.activeX = -1;
					drawingArea.activeY = -1;
					clickCounter = 0;

					if (!missClick) {
						try {
							out.writeObject("MOVE");
							out.writeObject(startX);
							out.writeObject(startY);
							out.writeObject(goalX);
							out.writeObject(goalY);
							out.flush();
						} catch (IOException e1) {
							e1.printStackTrace();
							end();
						}
					}
					drawingArea.repaint();
				}
			}
		});

		drawingArea.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.BOTH;
		frame.add(drawingArea, c);
	}

	public void play() {
		String response;
		Object obj = null;
		while (true) {
			try {
				obj = in.readObject();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
				end();
				break;
			}
			if (obj instanceof String) {
				response = (String) obj;
				if (response.startsWith("WELCOME")) {
					messageLabel.setText("Successfully connected to server");
					colorS = response.substring(8);
					frame.setTitle("Chinese Checkers - Player " + colorS);
				} else if (response.startsWith("SET_COLOR")) {
					color = new Color(Integer.parseInt(response.substring(10)));
				} else if (response.startsWith("END")) {
					end();
					break;
				} else if (response.startsWith("MESSAGE")) {
					messageLabel.setText(response.substring(8));
					if(messageLabel.getText().equals("You moved"))
						button.doClick();
				} else if (response.startsWith("YOUR_MOVE")) {
					drawingArea.repaint();
					messageLabel.setText("Your move");
				} else if (response.startsWith("NEXT_PLAYER")) {
					String tempColor = response.substring(12);
					messageLabel.setText(tempColor + "'s move");
				} else if (response.startsWith("ENABLE_BUTTON")) {
					button.setEnabled(true);
				}else if (response.startsWith("YOU_FINISHED")) {
					button.setEnabled(false);
					messageLabel.setText("you finished");
					try {
						out.close();
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}				
			} else if (obj instanceof int[][]) {
				for (int y = 0; y < drawingArea.board[0].length; y++) {
					for (int x = 0; x < drawingArea.board.length; x++) {
						drawingArea.board[x][y] = new Color(((int[][]) obj)[x][y]);
					}
				}
				drawingArea.repaint();
			}
		}
	}
	
	public void end() {
		JOptionPane.showMessageDialog(null, "Game ended!", "ERROR", JOptionPane.ERROR_MESSAGE);
		try {
			out.close();
			in.close();
		} catch (IOException e) {
		}
		System.exit(1);
	}

	public static void main(String[] args) throws Exception {
		String serverAddress = (args.length == 0) ? "localhost" : args[1];
		Client client = new Client(serverAddress);
		client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		client.frame.setVisible(true);
		client.frame.setResizable(true);
		client.frame.setSize(590, 628);
		client.play();
	}
}
