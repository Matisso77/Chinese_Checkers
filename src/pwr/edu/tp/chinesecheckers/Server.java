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
				players.add(new RealPlayer(listener.accept()));
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}

			Game game = null;
			int number = players.get(players.size() - 1).desiredNumber;

			if (players.get(players.size() - 1).wantsBots) {
				game = new Game(number);
				games.add(game);

				if (number == 2) {
					players.get(players.size() - 1).setColor(Color.BLUE, "BLUE");
					players.get(players.size() - 1).setGame(game);
					game.players.add(players.get(players.size() - 1));

					players.add(new BotBlack());
					players.get(players.size() - 1).setColor(Color.BLACK, "BLACK");
					players.get(players.size() - 1).setGame(game);
					game.players.add(players.get(players.size() - 1));
				} else if (number == 3) {
					players.get(players.size() - 1).setColor(Color.RED, "RED");
					players.get(players.size() - 1).setGame(game);
					game.players.add(players.get(players.size() - 1));

					players.add(new BotBlack());
					players.get(players.size() - 1).setColor(Color.BLACK, "BLACK");
					players.get(players.size() - 1).setGame(game);
					game.players.add(players.get(players.size() - 1));

					players.add(new BotPink());
					players.get(players.size() - 1).setColor(Color.PINK, "PINK");
					players.get(players.size() - 1).setGame(game);
					game.players.add(players.get(players.size() - 1));
				} else if (number == 4) {
					players.get(players.size() - 1).setColor(Color.RED, "RED");
					players.get(players.size() - 1).setGame(game);
					game.players.add(players.get(players.size() - 1));

					players.add(new BotGreen());
					players.get(players.size() - 1).setColor(Color.GREEN, "GREEN");
					players.get(players.size() - 1).setGame(game);
					game.players.add(players.get(players.size() - 1));

					players.add(new BotOrange());
					players.get(players.size() - 1).setColor(Color.ORANGE, "ORANGE");
					players.get(players.size() - 1).setGame(game);
					game.players.add(players.get(players.size() - 1));

					players.add(new BotPink());
					players.get(players.size() - 1).setColor(Color.PINK, "PINK");
					players.get(players.size() - 1).setGame(game);
					game.players.add(players.get(players.size() - 1));
				} else if (number == 6) {
					players.get(players.size() - 1).setColor(Color.BLUE, "BLUE");
					players.get(players.size() - 1).setGame(game);
					game.players.add(players.get(players.size() - 1));

					players.add(new BotRed());
					players.get(players.size() - 1).setColor(Color.RED, "RED");
					players.get(players.size() - 1).setGame(game);
					game.players.add(players.get(players.size() - 1));

					players.add(new BotGreen());
					players.get(players.size() - 1).setColor(Color.GREEN, "GREEN");
					players.get(players.size() - 1).setGame(game);
					game.players.add(players.get(players.size() - 1));

					players.add(new BotBlack());
					players.get(players.size() - 1).setColor(Color.BLACK, "BLACK");
					players.get(players.size() - 1).setGame(game);
					game.players.add(players.get(players.size() - 1));

					players.add(new BotOrange());
					players.get(players.size() - 1).setColor(Color.ORANGE, "ORANGE");
					players.get(players.size() - 1).setGame(game);
					game.players.add(players.get(players.size() - 1));

					players.add(new BotPink());
					players.get(players.size() - 1).setColor(Color.PINK, "PINK");
					players.get(players.size() - 1).setGame(game);
					game.players.add(players.get(players.size() - 1));
				} else
					continue;

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
			} else {
				for (Game g : games) {
					if (g.playersCount == number) {
						if (g.started == false) {
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