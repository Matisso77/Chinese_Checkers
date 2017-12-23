package pwr.edu.tp.chinesecheckers;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Player extends Thread {
	public Color color;
	String colorS;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	Player nextPlayer;
	Game game;
	int desiredNumber;

	public Player(Socket socket) throws Exception {
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("Player died: " + e);
		}

		Object object = in.readObject();
		desiredNumber = 0;
		if (object instanceof Integer) {
			desiredNumber = (int) object;
		}
	}

	public void setColor(Color color, String colorS) {
		this.color = color;
		this.colorS = colorS;
		try {
			out.writeObject("WELCOME " + colorS);
			out.writeObject("MESSAGE Waiting for opponents to connect");
			out.flush();
		} catch (IOException e) {
			System.out.println("Player died: " + e);
		}
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void setNextPlayer(Player player) {
		this.nextPlayer = player;
	}

	public void otherPlayerDone(String s) {
		try {
			out.writeObject("NEXT_PLAYER " + s);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendBoard() {
		try {
			out.writeObject(game.board);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void yourMove() {
		try {
			out.writeObject("MESSAGE Your move");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			sendBoard();
			out.writeObject("MESSAGE All players connected");
			out.writeObject("ENABLE_BUTTON");
			out.flush();
			if (this == game.currentPlayer) {
				yourMove();
			}

			while (true) {
				String command;
				Object obj = in.readObject();
				if (obj instanceof String) {
					command = (String) obj;
					if (command.startsWith("MOVE")) {
						int sx = (int) in.readObject();
						int sy = (int) in.readObject();
						int gx = (int) in.readObject();
						int gy = (int) in.readObject();
						if(game.legalMove2(sx, sy, gx, gy)) {
							game.move(sx, sy, gx, gy, this);
							out.writeObject("MESSAGE You moved");
							out.flush();
						} else {
							out.writeObject("MESSAGE You can't move there!");
							out.flush();
						}
						
						
					} else if (command.startsWith("QUIT")) {
						return;
					} else if (command.startsWith("DONE")) {
						game.playerDone(this);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Player died: " + e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
