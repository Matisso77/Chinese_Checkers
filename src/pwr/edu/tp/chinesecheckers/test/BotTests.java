package pwr.edu.tp.chinesecheckers.test;

import static org.junit.Assert.*;

import java.awt.Color;
import org.junit.Test;
import pwr.edu.tp.chinesecheckers.BotBlack;
import pwr.edu.tp.chinesecheckers.BotBlue;
import pwr.edu.tp.chinesecheckers.BotGreen;
import pwr.edu.tp.chinesecheckers.BotOrange;
import pwr.edu.tp.chinesecheckers.BotPink;
import pwr.edu.tp.chinesecheckers.BotRed;
import pwr.edu.tp.chinesecheckers.Game;

public class BotTests {

	@Test
	public void test() {
		Game game = new Game(6);
		BotBlack botBlack = new BotBlack();
		botBlack.setColor(Color.BLACK, "BLACK");
		botBlack.setGame(game);
		botBlack.searchField();
		assertNotEquals(botBlack.goalMoves[0], 1);
	}
	@Test
	public void test2() {
		Game game = new Game(6);
		BotBlue botBlue = new BotBlue();
		botBlue.setColor(Color.BLUE, "BLUE");
		botBlue.setGame(game);
		botBlue.searchField();
		assertNotEquals(botBlue.goalMoves[0], 1);
	}
	@Test
	public void test3() {
		Game game = new Game(6);
		BotOrange botOrange = new BotOrange();
		botOrange.setColor(Color.ORANGE, "ORANGE");
		botOrange.setGame(game);
		botOrange.searchField();
		assertNotEquals(botOrange.goalMoves[0], 1);
	}
	@Test
	public void test4() {
		Game game = new Game(6);
		BotGreen botGreen = new BotGreen();
		botGreen.setColor(Color.GREEN, "GREEN");
		botGreen.setGame(game);
		botGreen.searchField();
		assertNotEquals(botGreen.goalMoves[0], 1);
	}
	@Test
	public void test5() {
		Game game = new Game(6);
		BotRed botRed = new BotRed();
		botRed.setColor(Color.RED, "RED");
		botRed.setGame(game);
		botRed.searchField();
		assertNotEquals(botRed.goalMoves[0], 1);
	}
	@Test
	public void test6() {
		Game game = new Game(6);
		BotPink botPink = new BotPink();
		botPink.setColor(Color.PINK, "PINK");
		botPink.setGame(game);
		botPink.searchField();
		assertNotEquals(botPink.goalMoves[0], 1);
	}
}
