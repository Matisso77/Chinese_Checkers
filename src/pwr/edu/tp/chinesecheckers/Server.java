package pwr.edu.tp.chinesecheckers;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

public class Server {
	private static int port = 8901;
	ServerSocket listener;
	ArrayList<Game> games = new ArrayList<>();
	ArrayList<Player> players = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		Server server = new Server();
		server.startListening();
		server.games = new ArrayList<Game>();
		// server.startAllocating();
		server.botBlackTest();
		// server.botBlueTest();
	}

	public void clean() {
		ArrayList<Game> toDeleteG = new ArrayList<>();
		for (Game g : games) {
			if (g.finished)
				toDeleteG.add(g);
		}

		for (Game g : toDeleteG) {
			if(games.remove(g))
				System.out.println("removed");
		}
		
		ArrayList<Player> toDeleteP = new ArrayList<>();
		for (Player p: players) {
			if(p.dead)
				toDeleteP.add(p);
		}
		
		for (Player p: toDeleteP) {
			if(players.remove(p))
				System.out.println("removed");
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

	public void botBlueTest() {
		while (true) {
			Game game = null;
			game = new Game(2);
			games.add(game);

			players.add(new BotBlue());
			players.get(players.size() - 1).setColor(Color.BLUE, "BLUE");
			players.get(players.size() - 1).setGame(game);
			game.players.add(players.get(players.size() - 1));

			try {
				players.add(new RealPlayer(listener.accept()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			players.get(players.size() - 1).setColor(Color.BLACK, "BLACK");
			players.get(players.size() - 1).setGame(game);
			game.players.add(players.get(players.size() - 1));

			for (int i = 0; i < game.players.size() - 1; i++)
				game.players.get(i).setNextPlayer(game.players.get(i + 1));
			game.players.get(game.players.size() - 1).setNextPlayer(game.players.get(0));

			Random generator = new Random();
			int randomIndex = generator.nextInt(game.players.size());
			game.currentPlayer = game.players.get(randomIndex);

			for (Player p : game.players) {
				p.start();
			}
			game.started = true;

		}
	}

	public void botBlackTest() {
		while (true) {
			clean();
			System.out.println("Gier na serwerze: " + games.size() + " graczy na serwerze: " + players.size());
			try {
				players.add(new RealPlayer(listener.accept()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			Game game = null;
			int number = players.get(players.size() - 1).desiredNumber;
			game = new Game(number);
			games.add(game);

			players.get(players.size() - 1).setColor(Color.BLUE, "BLUE");
			players.get(players.size() - 1).setGame(game);
			game.players.add(players.get(players.size() - 1));

			players.add(new BotBlack());
			players.get(players.size() - 1).setColor(Color.BLACK, "BLACK");
			players.get(players.size() - 1).setGame(game);
			game.players.add(players.get(players.size() - 1));

			for (int i = 0; i < game.players.size() - 1; i++)
				game.players.get(i).setNextPlayer(game.players.get(i + 1));
			game.players.get(game.players.size() - 1).setNextPlayer(game.players.get(0));

			Random generator = new Random();
			int randomIndex = generator.nextInt(game.players.size());
			game.currentPlayer = game.players.get(randomIndex);

			for (Player p : game.players) {
				p.start();
			}
			game.started = true;

		}
	}

	public void startAllocating() {
		while (true) {
			try {
				players.add(new RealPlayer(listener.accept()));
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}

			Game game = null;
			int number = players.get(players.size() - 1).desiredNumber;

			for (Game g : games) {
				if (g.playersCount == number) {
					if (g.started == false) {
						for (Player p : g.players) {
							if (p.dead) {
								games.remove(g);
								continue;
							}
						}
						game = g;
						break;
					}
				}
			}

			if (game == null) {
				game = new Game(number);
				games.add(game);
			}

			if (number == 2) {
				if (game.players.size() == 0)
					players.get(players.size() - 1).setColor(Color.BLUE, "BLUE");
				else if (game.players.size() == 1)
					players.get(players.size() - 1).setColor(Color.BLACK, "BLACK");
			} else if (number == 3) {
				if (game.players.size() == 0)
					players.get(players.size() - 1).setColor(Color.RED, "RED");
				else if (game.players.size() == 1)
					players.get(players.size() - 1).setColor(Color.BLACK, "BLACK");
				else if (game.players.size() == 2)
					players.get(players.size() - 1).setColor(Color.PINK, "PINK");
			} else if (number == 4) {
				if (game.players.size() == 0)
					players.get(players.size() - 1).setColor(Color.RED, "RED");
				else if (game.players.size() == 1)
					players.get(players.size() - 1).setColor(Color.GREEN, "GREEN");
				else if (game.players.size() == 2)
					players.get(players.size() - 1).setColor(Color.ORANGE, "ORANGE");
				else if (game.players.size() == 3)
					players.get(players.size() - 1).setColor(Color.PINK, "PINK");
			} else if (number == 6) {
				if (game.players.size() == 0)
					players.get(players.size() - 1).setColor(Color.BLUE, "BLUE");
				else if (game.players.size() == 1)
					players.get(players.size() - 1).setColor(Color.RED, "RED");
				else if (game.players.size() == 2)
					players.get(players.size() - 1).setColor(Color.GREEN, "GREEN");
				else if (game.players.size() == 3)
					players.get(players.size() - 1).setColor(Color.BLACK, "BLACK");
				else if (game.players.size() == 4)
					players.get(players.size() - 1).setColor(Color.ORANGE, "ORANGE");
				else if (game.players.size() == 5)
					players.get(players.size() - 1).setColor(Color.PINK, "PINK");
			} else
				continue;

			players.get(players.size() - 1).setGame(game);
			game.players.add(players.get(players.size() - 1));

			if (game.players.size() == number) {
				for (int i = 0; i < game.players.size() - 1; i++)
					game.players.get(i).setNextPlayer(game.players.get(i + 1));
				game.players.get(game.players.size() - 1).setNextPlayer(game.players.get(0));

				Random generator = new Random();
				int randomIndex = generator.nextInt(game.players.size());
				game.currentPlayer = game.players.get(randomIndex);

				for (Player p : game.players) {
					p.start();
				}
				game.started = true;
			}
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
