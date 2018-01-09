package pwr.edu.tp.chinesecheckers;

import java.awt.Color;
import java.net.Socket;
import java.util.Random;

public class PlayerHandler extends Thread {
	Socket socket;
	RealPlayer player;

	public PlayerHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		player = new RealPlayer(socket);

		Game game = null;
		int number = player.desiredNumber;

		synchronized (Server.getInstance()) {
			Server server = Server.getInstance();
			server.players.add(player);
			if (player.wantsBots) {
				game = new Game(number);
				server.games.add(game);

				if (number == 2) {
					server.players.get(server.players.size() - 1).setColor(Color.BLUE, "BLUE");
					server.players.get(server.players.size() - 1).setGame(game);
					game.players.add(server.players.get(server.players.size() - 1));

					server.players.add(new BotBlack());
					server.players.get(server.players.size() - 1).setColor(Color.BLACK, "BLACK");
					server.players.get(server.players.size() - 1).setGame(game);
					game.players.add(server.players.get(server.players.size() - 1));
				} else if (number == 3) {
					server.players.get(server.players.size() - 1).setColor(Color.RED, "RED");
					server.players.get(server.players.size() - 1).setGame(game);
					game.players.add(server.players.get(server.players.size() - 1));

					server.players.add(new BotBlack());
					server.players.get(server.players.size() - 1).setColor(Color.BLACK, "BLACK");
					server.players.get(server.players.size() - 1).setGame(game);
					game.players.add(server.players.get(server.players.size() - 1));

					server.players.add(new BotPink());
					server.players.get(server.players.size() - 1).setColor(Color.PINK, "PINK");
					server.players.get(server.players.size() - 1).setGame(game);
					game.players.add(server.players.get(server.players.size() - 1));
				} else if (number == 4) {
					server.players.get(server.players.size() - 1).setColor(Color.RED, "RED");
					server.players.get(server.players.size() - 1).setGame(game);
					game.players.add(server.players.get(server.players.size() - 1));

					server.players.add(new BotGreen());
					server.players.get(server.players.size() - 1).setColor(Color.GREEN, "GREEN");
					server.players.get(server.players.size() - 1).setGame(game);
					game.players.add(server.players.get(server.players.size() - 1));

					server.players.add(new BotOrange());
					server.players.get(server.players.size() - 1).setColor(Color.ORANGE, "ORANGE");
					server.players.get(server.players.size() - 1).setGame(game);
					game.players.add(server.players.get(server.players.size() - 1));

					server.players.add(new BotPink());
					server.players.get(server.players.size() - 1).setColor(Color.PINK, "PINK");
					server.players.get(server.players.size() - 1).setGame(game);
					game.players.add(server.players.get(server.players.size() - 1));
				} else if (number == 6) {
					server.players.get(server.players.size() - 1).setColor(Color.BLUE, "BLUE");
					server.players.get(server.players.size() - 1).setGame(game);
					game.players.add(server.players.get(server.players.size() - 1));

					server.players.add(new BotRed());
					server.players.get(server.players.size() - 1).setColor(Color.RED, "RED");
					server.players.get(server.players.size() - 1).setGame(game);
					game.players.add(server.players.get(server.players.size() - 1));

					server.players.add(new BotGreen());
					server.players.get(server.players.size() - 1).setColor(Color.GREEN, "GREEN");
					server.players.get(server.players.size() - 1).setGame(game);
					game.players.add(server.players.get(server.players.size() - 1));

					server.players.add(new BotBlack());
					server.players.get(server.players.size() - 1).setColor(Color.BLACK, "BLACK");
					server.players.get(server.players.size() - 1).setGame(game);
					game.players.add(server.players.get(server.players.size() - 1));

					server.players.add(new BotOrange());
					server.players.get(server.players.size() - 1).setColor(Color.ORANGE, "ORANGE");
					server.players.get(server.players.size() - 1).setGame(game);
					game.players.add(server.players.get(server.players.size() - 1));

					server.players.add(new BotPink());
					server.players.get(server.players.size() - 1).setColor(Color.PINK, "PINK");
					server.players.get(server.players.size() - 1).setGame(game);
					game.players.add(server.players.get(server.players.size() - 1));
				}

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
				for (Game g : server.games) {
					if (g.playersCount == number) {
						if (g.started == false) {
							game = g;
							break;
						}
					}
				}

				if (game == null) {
					game = new Game(number);
					server.games.add(game);
				}

				if (number == 2) {
					if (game.players.size() == 0)
						server.players.get(server.players.size() - 1).setColor(Color.BLUE, "BLUE");
					else if (game.players.size() == 1)
						server.players.get(server.players.size() - 1).setColor(Color.BLACK, "BLACK");
				} else if (number == 3) {
					if (game.players.size() == 0)
						server.players.get(server.players.size() - 1).setColor(Color.RED, "RED");
					else if (game.players.size() == 1)
						server.players.get(server.players.size() - 1).setColor(Color.BLACK, "BLACK");
					else if (game.players.size() == 2)
						server.players.get(server.players.size() - 1).setColor(Color.PINK, "PINK");
				} else if (number == 4) {
					if (game.players.size() == 0)
						server.players.get(server.players.size() - 1).setColor(Color.RED, "RED");
					else if (game.players.size() == 1)
						server.players.get(server.players.size() - 1).setColor(Color.GREEN, "GREEN");
					else if (game.players.size() == 2)
						server.players.get(server.players.size() - 1).setColor(Color.ORANGE, "ORANGE");
					else if (game.players.size() == 3)
						server.players.get(server.players.size() - 1).setColor(Color.PINK, "PINK");
				} else if (number == 6) {
					if (game.players.size() == 0)
						server.players.get(server.players.size() - 1).setColor(Color.BLUE, "BLUE");
					else if (game.players.size() == 1)
						server.players.get(server.players.size() - 1).setColor(Color.RED, "RED");
					else if (game.players.size() == 2)
						server.players.get(server.players.size() - 1).setColor(Color.GREEN, "GREEN");
					else if (game.players.size() == 3)
						server.players.get(server.players.size() - 1).setColor(Color.BLACK, "BLACK");
					else if (game.players.size() == 4)
						server.players.get(server.players.size() - 1).setColor(Color.ORANGE, "ORANGE");
					else if (game.players.size() == 5)
						server.players.get(server.players.size() - 1).setColor(Color.PINK, "PINK");
				}

				server.players.get(server.players.size() - 1).setGame(game);
				game.players.add(server.players.get(server.players.size() - 1));

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
}
