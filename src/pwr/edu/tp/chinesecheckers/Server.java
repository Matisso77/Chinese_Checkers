package pwr.edu.tp.chinesecheckers;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	private static int port = 8901;

	public static void main(String[] args) {
		ServerSocket listener;
		try {
			listener = new ServerSocket(port);
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		System.out.println("Chinese checkers server is running");
		try {
			while (true) {
			Game game = new Game();
			for(Colors n: Colors.values()) {
				Player player = new Player(listener.accept(), n);
				System.out.println(n + " player connected");
			}
			//TODO: adding players to game and setting for each next player
		}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				listener.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
