package pwr.edu.tp.chinesecheckers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Player extends Thread {
	public Colors color;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	Player nextPlayer;
	Game game;

	public Player(Socket socket, Colors color, Game game) throws Exception {
		this.color = color;
		this.game = game;
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			out.writeObject("WELCOME " + color.ordinal());
			out.writeObject("MESSAGE Waiting for opponents to connect");
			out.flush();
		} catch (IOException e) {
			System.out.println("Player died: " + e);
		}
	}

	public void setNextPlayer(Player player) {
		this.nextPlayer = player;
	}

	public void otherPlayerMoved(int start, int stop, Player player) {
		try {
			out.writeObject("OPPONENT_MOVED");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void otherPlayerDone(int i) {
		try {
			out.writeObject("NEXT_PLAYER " + i);
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
			out.writeObject("MESSAGE All players connected");
			out.flush();
			if(this == game.currentPlayer) {
				yourMove();
			}
				
			while (true) {
				String command;
				Object obj = in.readObject();
				if (obj instanceof String) {
					command = (String) obj;
					if (command.startsWith("MOVE")) {
						//handle moving peg
					} else if (command.startsWith("QUIT")) {
						return;
					}
					else if (command.startsWith("DONE")) {
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
