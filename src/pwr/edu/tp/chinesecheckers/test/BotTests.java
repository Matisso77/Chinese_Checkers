package pwr.edu.tp.chinesecheckers.test;

import static org.junit.Assert.*;



import org.junit.Test;

import pwr.edu.tp.chinesecheckers.BotBlack;
//import pwr.edu.tp.chinesecheckers.Game;

public class BotTests {

	@Test
	public void test() {
		BotBlack botBlack = new BotBlack();
		//botBlack.Game game = new Game(6);
		botBlack.searchField();
		assertNotEquals(botBlack.goalMoves[0], 1);
	}

}
