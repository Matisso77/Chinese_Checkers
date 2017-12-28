package pwr.edu.tp.chinesecheckers;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RealPlayer extends Player {
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	public RealPlayer(Socket socket) {
		this.socket = socket;
		try {
			out = new ObjectOutputStream(this.socket.getOutputStream());
			in = new ObjectInputStream(this.socket.getInputStream());
		} catch (IOException e) {
			System.out.println("Player died: " + e);
			game.endGame(this);
			dead = true;
		}

		Object object = null;
		try {
			object = in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Player died: " + e);
			game.endGame(this);
			dead = true;
		}
		desiredNumber = 0;
		if (object instanceof Integer) {
			desiredNumber = (int) object;
		}
	}

	@Override
	public void setColor(Color color, String colorS) {
		this.color = color;
		this.colorS = colorS;
		try {
			out.writeObject("WELCOME " + colorS);
			out.writeObject("SET_COLOR " + color.getRGB());
			out.writeObject("MESSAGE Waiting for opponents to connect");
			out.flush();
		} catch (IOException e) {
			System.out.println("Player died: " + e);
			game.endGame(this);
			dead = true;
		}		
	}

	@Override
	public void otherPlayerDone(String s) {
		try {
			out.writeObject("NEXT_PLAYER " + s);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
			game.endGame(this);
			dead = true;
		}		
	}

	@Override
	public Boolean sendBoard(Color[][] board) {
		int[][] rgb = new int[25][17];
		try {
			for (int y = 0; y < board[0].length; y++) {
				for (int x = 0; x < board.length; x++) {
					rgb[x][y] = board[x][y].getRGB();
				}
			}
			out.writeObject(rgb);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
			game.endGame(this);
			dead = true;
			return false;
		}
		return true;
	}

	@Override
	public void yourMove() {
		try {
			out.writeObject("MESSAGE Your move");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
			game.endGame(this);
			dead = true;
		}		
	}

	@Override
	public void end() {
		try {
			out.writeObject("END");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
			dead = true;
		}		
	}

	@Override
	public void youFinished() {
		try {
			out.writeObject("YOU_FINISHED");
			out.flush();
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		if(!sendBoard(game.board.board))
			return;
		try {
			out.writeObject("MESSAGE All players connected");
			out.writeObject("ENABLE_BUTTON");
			out.flush();
		} catch (IOException e) {
			System.out.println("Player died: " + e);
			game.endGame(this);
			dead = true;
		}
	
		if (this == game.currentPlayer) {
			yourMove();
		}

		while (!dead) {
			String command;
			Object obj = null;
			try {
				obj = in.readObject();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
				game.endGame(this);
				dead = true;
				break;
			} catch (IOException e1) {
				System.out.println("Player died: " + e1);
				game.endGame(this);
				dead = true;
				break;
			}
			
			if (obj instanceof String) {
				command = (String) obj;
				if (command.startsWith("MOVE")) {
					if (this == game.currentPlayer) {
						int sx;
						int sy;
						int gx;
						int gy;
						try {
							sx = (int) in.readObject();
							sy = (int) in.readObject();
							gx = (int) in.readObject();
							gy = (int) in.readObject();
						} catch (ClassNotFoundException | IOException e) {
							System.out.println("Player died: " + e);
							game.endGame(this);
							dead = true;
							break;
						}
						if (game.legalMove3(sx, sy, gx, gy, this, color)) {
							game.move(sx, sy, gx, gy);
							sendBoard(game.board.board);
							try {
								out.writeObject("MESSAGE You moved");
								out.flush();
							} catch (IOException e) {
								System.out.println("Player died: " + e);
								game.endGame(this);
								dead = true;
								break;
							}
						} else {
							try {
								out.writeObject("MESSAGE Illegal move!");
								out.flush();
							} catch (IOException e) {
								System.out.println("Player died: " + e);
								game.endGame(this);
								dead = true;
								break;
							}
						}
					}
				} else if (command.startsWith("DONE")) {
					game.playerDone(this);
				}
			}
		}
	}
}
