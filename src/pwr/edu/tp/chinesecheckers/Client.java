package pwr.edu.tp.chinesecheckers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Client {
	private static int port = 8901;
	private Socket socket;
	private Colors color;
	private BufferedReader in;
	private PrintWriter out;
	private JFrame frame = new JFrame("Chinese Checkers");
	private JLabel messageLabel = new JLabel("");

	public Client(String serverAddress) {
		try {
			socket = new Socket(serverAddress, port);
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Unknown host!", "ERROR", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not establish connection with server!", "ERROR", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(1);
		}
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		frame.getContentPane().add(messageLabel, "South");
	}

	public void play() throws Exception {
		String response;
		try {
			response = in.readLine();
			if (response.startsWith("WELCOME")) {
				messageLabel.setText("Successfully connected to server");
				color = Colors.values()[Character.getNumericValue(response.charAt(8))];
				frame.setTitle("Chinese Checkers - Player " + color);
			}
			
			out.println("QUIT");
		} finally {
			socket.close();
		}
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
