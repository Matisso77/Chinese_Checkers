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
		Server.getInstance().players.add(player);

		Game game = null;
		int number = player.desiredNumber;

		synchronized (Server.getInstance()) {
			if (player.wantsBots) {
				game = new Game(number);
				Server.getInstance().games.add(game);

				if (number == 2) {
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.BLUE, "BLUE");
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setGame(game);
					game.players.add(Server.getInstance().players.get(Server.getInstance().players.size() - 1));

					Server.getInstance().players.add(new BotBlack());
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.BLACK, "BLACK");
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setGame(game);
					game.players.add(Server.getInstance().players.get(Server.getInstance().players.size() - 1));
				} else if (number == 3) {
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.RED, "RED");
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setGame(game);
					game.players.add(Server.getInstance().players.get(Server.getInstance().players.size() - 1));

					Server.getInstance().players.add(new BotBlack());
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.BLACK, "BLACK");
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setGame(game);
					game.players.add(Server.getInstance().players.get(Server.getInstance().players.size() - 1));

					Server.getInstance().players.add(new BotPink());
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.PINK, "PINK");
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setGame(game);
					game.players.add(Server.getInstance().players.get(Server.getInstance().players.size() - 1));
				} else if (number == 4) {
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.RED, "RED");
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setGame(game);
					game.players.add(Server.getInstance().players.get(Server.getInstance().players.size() - 1));

					Server.getInstance().players.add(new BotGreen());
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.GREEN, "GREEN");
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setGame(game);
					game.players.add(Server.getInstance().players.get(Server.getInstance().players.size() - 1));

					Server.getInstance().players.add(new BotOrange());
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.ORANGE, "ORANGE");
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setGame(game);
					game.players.add(Server.getInstance().players.get(Server.getInstance().players.size() - 1));

					Server.getInstance().players.add(new BotPink());
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.PINK, "PINK");
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setGame(game);
					game.players.add(Server.getInstance().players.get(Server.getInstance().players.size() - 1));
				} else if (number == 6) {
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.BLUE, "BLUE");
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setGame(game);
					game.players.add(Server.getInstance().players.get(Server.getInstance().players.size() - 1));

					Server.getInstance().players.add(new BotRed());
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.RED, "RED");
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setGame(game);
					game.players.add(Server.getInstance().players.get(Server.getInstance().players.size() - 1));

					Server.getInstance().players.add(new BotGreen());
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.GREEN, "GREEN");
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setGame(game);
					game.players.add(Server.getInstance().players.get(Server.getInstance().players.size() - 1));

					Server.getInstance().players.add(new BotBlack());
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.BLACK, "BLACK");
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setGame(game);
					game.players.add(Server.getInstance().players.get(Server.getInstance().players.size() - 1));

					Server.getInstance().players.add(new BotOrange());
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.ORANGE, "ORANGE");
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setGame(game);
					game.players.add(Server.getInstance().players.get(Server.getInstance().players.size() - 1));

					Server.getInstance().players.add(new BotPink());
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.PINK, "PINK");
					Server.getInstance().players.get(Server.getInstance().players.size() - 1).setGame(game);
					game.players.add(Server.getInstance().players.get(Server.getInstance().players.size() - 1));
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
				for (Game g : Server.getInstance().games) {
					if (g.playersCount == number) {
						if (g.started == false) {
							game = g;
							break;
						}
					}
				}

				if (game == null) {
					game = new Game(number);
					Server.getInstance().games.add(game);
				}

				if (number == 2) {
					if (game.players.size() == 0)
						Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.BLUE, "BLUE");
					else if (game.players.size() == 1)
						Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.BLACK, "BLACK");
				} else if (number == 3) {
					if (game.players.size() == 0)
						Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.RED, "RED");
					else if (game.players.size() == 1)
						Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.BLACK, "BLACK");
					else if (game.players.size() == 2)
						Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.PINK, "PINK");
				} else if (number == 4) {
					if (game.players.size() == 0)
						Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.RED, "RED");
					else if (game.players.size() == 1)
						Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.GREEN, "GREEN");
					else if (game.players.size() == 2)
						Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.ORANGE, "ORANGE");
					else if (game.players.size() == 3)
						Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.PINK, "PINK");
				} else if (number == 6) {
					if (game.players.size() == 0)
						Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.BLUE, "BLUE");
					else if (game.players.size() == 1)
						Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.RED, "RED");
					else if (game.players.size() == 2)
						Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.GREEN, "GREEN");
					else if (game.players.size() == 3)
						Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.BLACK, "BLACK");
					else if (game.players.size() == 4)
						Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.ORANGE, "ORANGE");
					else if (game.players.size() == 5)
						Server.getInstance().players.get(Server.getInstance().players.size() - 1).setColor(Color.PINK, "PINK");
				}

				Server.getInstance().players.get(Server.getInstance().players.size() - 1).setGame(game);
				game.players.add(Server.getInstance().players.get(Server.getInstance().players.size() - 1));

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
