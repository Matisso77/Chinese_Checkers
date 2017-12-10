package pwr.edu.tp.chinesecheckers;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Random;

public class Server {
	private static int port = 8901;
	private static int playerNumber = 2;
	ServerSocket listener;
	ArrayList<Game> games;

	public static void main(String[] args) throws Exception {
		Server server = new Server();
		server.startListening();
		server.games = new ArrayList<Game>();
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
	
	public void startMatching() throws Exception {
		try {
			while (true) {
				Game game = new Game();
				games.add(game);
				game.players.add(new Player(listener.accept(), Colors.BLUE, game));
				System.out.println(game.players.get(game.players.size() - 1).color + " player connected");
				for (int i = 1; i < playerNumber; i++) {
					game.players.add(new Player(listener.accept(), Colors.values()[i], game));
					System.out.println(game.players.get(game.players.size() - 1).color + " player connected");
				}
				
				game.players.get(0).setNextPlayer(game.players.get(1));
				for(int i = 0; i < game.players.size() - 1; i++)
					game.players.get(i).setNextPlayer(game.players.get(i + 1));
				game.players.get(game.players.size() - 1).setNextPlayer(game.players.get(0));
				
				Random generator = new Random();
				int randomIndex = generator.nextInt(game.players.size());
				game.currentPlayer = game.players.get(randomIndex);
				
				for(Player p: game.players) {
					p.start();
				}
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
