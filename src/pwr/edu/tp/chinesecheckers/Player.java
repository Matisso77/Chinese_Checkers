package pwr.edu.tp.chinesecheckers;

import java.awt.Color;

public abstract class Player extends Thread {
	public Color color;
	String colorS;
	Player nextPlayer;
	Game game;
	public boolean dead = false;
	int desiredNumber;
	boolean wantsBots = false;
	
	public abstract void setColor(Color color, String colorS);
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public void setNextPlayer(Player player) {
		this.nextPlayer = player;
	}
	
	public abstract void otherPlayerDone(String s);
	
	public abstract Boolean sendBoard(Color[][] board);
	
	public abstract void yourMove();
	
	public abstract void end();
	
	public abstract void youFinished();
	
	public abstract void run();
}