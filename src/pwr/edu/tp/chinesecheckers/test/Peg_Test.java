package pwr.edu.tp.chinesecheckers.test;

import static org.junit.Assert.*;
import java.awt.Color;
import org.junit.Test;
import pwr.edu.tp.chinesecheckers.*;

public class Peg_Test {

	@Test
	public void test_b2() {
		BoardAssembler assembler = new BoardAssembler();
		Board b2 = assembler.getBoard(new Players2BoardBodyBuilder());
		assertEquals(b2.board[0][0], Color.WHITE);
		assertEquals(b2.board[12][0], Color.BLUE);
		assertEquals(b2.board[12][6], Color.GRAY);
		assertEquals(b2.board[11][1], Color.BLUE);
		assertEquals(b2.board[22][4], Color.GRAY);
	}
	
	@Test
	public void test_b3() {
		BoardAssembler assembler = new BoardAssembler();
		Board b3 = assembler.getBoard(new Players3BoardBodyBuilder());
		assertEquals(b3.board[0][0], Color.WHITE);
		assertEquals(b3.board[12][0], Color.GRAY);
		assertEquals(b3.board[12][6], Color.GRAY);
		assertEquals(b3.board[11][1], Color.GRAY);
		assertEquals(b3.board[22][4], Color.RED);
	}
	
	@Test
	public void test_b4() {
		BoardAssembler assembler = new BoardAssembler();
		Board b4 = assembler.getBoard(new Players4BoardBodyBuilder());
		assertEquals(b4.board[0][0], Color.WHITE);
		assertEquals(b4.board[11][1], Color.GRAY);
		assertEquals(b4.board[12][6], Color.GRAY);
		assertEquals(b4.board[11][1], Color.GRAY);
		assertEquals(b4.board[22][4], Color.RED);
	}
	
	@Test
	public void test_b6() {
		BoardAssembler assembler = new BoardAssembler();
		Board b6 = assembler.getBoard(new Players6BoardBodyBuilder());
		assertEquals(b6.board[0][0], Color.WHITE);
		assertEquals(b6.board[12][0], Color.BLUE);
		assertEquals(b6.board[12][6], Color.GRAY);
		assertEquals(b6.board[11][1], Color.BLUE);
		assertEquals(b6.board[22][4], Color.RED);
	}
}
