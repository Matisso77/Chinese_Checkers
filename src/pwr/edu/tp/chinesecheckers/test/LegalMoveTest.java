package pwr.edu.tp.chinesecheckers.test;

import static org.junit.Assert.*;
import java.awt.Color;
import org.junit.Test;
import pwr.edu.tp.chinesecheckers.BotBlue;
import pwr.edu.tp.chinesecheckers.Game;
import pwr.edu.tp.chinesecheckers.Player;

public class LegalMoveTest {
	Game game = new Game(6);
	Game game2 = new Game(2);
	Game game3 = new Game(3);
	Game game4 = new Game(4);

	@Test
	public void test1() {
		Player dummyPlayer = new BotBlue();
		dummyPlayer.setColor(Color.BLUE, "BLUE");
		boolean ans = false;
		assertEquals(game.legalMove3(11, 3, 13, 4, dummyPlayer, Color.BLUE), ans);
	}
}