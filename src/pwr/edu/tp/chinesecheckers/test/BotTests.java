package pwr.edu.tp.chinesecheckers.test;

import static org.junit.Assert.*;

import java.awt.Color;
import org.junit.Test;
import pwr.edu.tp.chinesecheckers.BotBlack;
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
}
