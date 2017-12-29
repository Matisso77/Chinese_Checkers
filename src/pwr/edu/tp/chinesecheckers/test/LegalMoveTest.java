package pwr.edu.tp.chinesecheckers.test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import pwr.edu.tp.chinesecheckers.Game;
import pwr.edu.tp.chinesecheckers.Player;

public class LegalMoveTest extends Player {



	 Game game = new Game(6);
	 Game game2 = new Game(2);
	 Game game3 = new Game(3);
	 Game game4 = new Game(4);
	@Test
	public void test1() {
	
		boolean ans= false;
		System.out.println(game.board.board[12][6].getRGB() == Color.GRAY.getRGB());
		
		assertEquals(game.legalMove3(11,3,13,4,this,Color.BLUE), ans);
	}

	@Override
	public void setColor(Color color, String colorS) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void otherPlayerDone(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean sendBoard(Color[][] board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void yourMove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void youFinished() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
