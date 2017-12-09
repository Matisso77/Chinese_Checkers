package pwr.edu.tp.chinesecheckers;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Random;

public class Server {
	private static int port = 8901;
	private static int playerNumber = 2;
	ServerSocket listener;

	public static void main(String[] args) {
		Server server = new Server();
		server.startListening();
		server.startMatching();
	}
	
	public void startListening() {
		try {
			listener = new ServerSocket(port);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(1);
		}
		System.out.println("Chinese checkers server is running");
	}
	
	public void startMatching() {
		try {
			while (true) {
				Game game = new Game();
				ArrayList<Player> players = new ArrayList<Player>();
				players.add(new Player(listener.accept(), Colors.BLUE));
				System.out.println(players.get(players.size() - 1).color + " player connected");
				for (int i = 1; i < playerNumber; i++) {
					players.add(new Player(listener.accept(), Colors.values()[i]));
					System.out.println(players.get(players.size() - 1).color + " player connected");
				}
				Random generator = new Random();
				int randomIndex = generator.nextInt(players.size());
				game.currentPlayer = players.get(randomIndex);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void finalize() {
		try {
			listener.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
