package pwr.edu.tp.chinesecheckers;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Server {
	private static int port = 8901;
	ServerSocket listener;
	ArrayList<Game> games = new ArrayList<>();
	ArrayList<Player> players = new ArrayList<>();
	private volatile static Server instance;

	public static Server getInstance() {
		if (instance == null) {
			synchronized (Server.class) {
				instance = new Server();
			}
		}
		return instance;
	}

	public static void resetInstance() {
		instance = null;
	}

	public static void main(String[] args) throws Exception {
		Server.getInstance().startListening();
		Server.getInstance().startAllocating();
	}

	public void clean() {
		ArrayList<Game> toDeleteG = new ArrayList<>();
		for (Game g : games) {
			if (g.finished)
				toDeleteG.add(g);
		}

		for (Game g : toDeleteG) {
			games.remove(g);
		}

		ArrayList<Player> toDeleteP = new ArrayList<>();
		for (Player p : players) {
			if (p.dead)
				toDeleteP.add(p);
		}

		for (Player p : toDeleteP) {
			players.remove(p);
		}
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

	public void startAllocating() {
		while (!Thread.currentThread().isInterrupted()) {
			clean();
			System.out.println("Games on the server: " + games.size() + " Players online: " + players.size());
			try {
				PlayerHandler ph = new PlayerHandler(listener.accept());
				ph.start();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}

	public void finalize() {
		try {
			if (listener != null)
				listener.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}