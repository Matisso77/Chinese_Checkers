package pwr.edu.tp.chinesecheckers;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private String color;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private JFrame frame = new JFrame("Chinese Checkers");
	private JLabel messageLabel = new JLabel("");
	private AltBoard drawingArea = new AltBoard(0);
	private JButton button = new JButton("Done");

	public Client(String serverAddress) throws IOException {
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
		int s = (int) JOptionPane.showInputDialog(frame, "How many players there should be in your game?",
				"Choose number of players", JOptionPane.PLAIN_MESSAGE, null, possibilities, 2);
		out.writeObject(s);
		out.flush();

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

	public void play() throws Exception {
		String response;
		Object obj;
		while (true) {
			obj = in.readObject();
			if (obj instanceof String) {
				response = (String) obj;
				if (response.startsWith("WELCOME")) {
					messageLabel.setText("Successfully connected to server");
					color = response.substring(8);
					frame.setTitle("Chinese Checkers - Player " + color);
				}
				if (response.startsWith("END")) {
					messageLabel.setText("Game ended");
					break;
				} else if (response.startsWith("MESSAGE")) {
					messageLabel.setText(response.substring(8));
				} else if (response.startsWith("OPPONENT_MOVED")) {
					drawingArea.repaint();
				} else if (response.startsWith("YOUR_MOVE")) {
					drawingArea.repaint();
					messageLabel.setText("Your move");
				} else if (response.startsWith("NEXT_PLAYER")) {
					String tempColor = response.substring(12);
					messageLabel.setText(tempColor + "'s move");
				} else if (response.startsWith("ENABLE_BUTTON")) {
					button.setEnabled(true);
				}
			} else if (obj instanceof AltBoard) {
				drawingArea.board = ((AltBoard) obj).board;
			}
			drawingArea.repaint();
		}
		out.writeObject("QUIT");
		out.flush();
	}

	public static void main(String[] args) throws Exception {
		String serverAddress = (args.length == 0) ? "localhost" : args[1];
		Client client = new Client(serverAddress);
		client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		client.frame.setSize(480, 240);
		client.frame.setVisible(true);
		client.frame.setResizable(true);
		client.play();
	}
}
