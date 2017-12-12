package pwr.edu.tp.chinesecheckers.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pwr.edu.tp.chinesecheckers.Board;
import pwr.edu.tp.chinesecheckers.Board.Fields;

public class Peg_Test {

	@Test
	public void test_b2() {
		
		Board b2 = new Board(2);
		assertEquals(b2.board[0][0], Fields.NOTUSED);
		assertEquals(b2.board[12][0], Fields.FULL);
		assertEquals(b2.board[12][6], Fields.EMPTY);
		assertEquals(b2.board[11][1], Fields.FULL);
		assertEquals(b2.board[22][4], Fields.EMPTY);
	}
	
	@Test
	public void test_b3() {
		
		Board b3 = new Board(3);
	
		assertEquals(b3.board[0][0], Fields.NOTUSED);
		assertEquals(b3.board[12][0], Fields.EMPTY);
		assertEquals(b3.board[12][6], Fields.EMPTY);
		assertEquals(b3.board[11][1], Fields.EMPTY);
		assertEquals(b3.board[22][4], Fields.FULL);
	}
	
	@Test
	public void test_b4() {

		Board b4 = new Board(4);
		assertEquals(b4.board[0][0], Fields.NOTUSED);
		assertEquals(b4.board[11][1], Fields.EMPTY);
		assertEquals(b4.board[12][6], Fields.EMPTY);
		assertEquals(b4.board[11][1], Fields.EMPTY);
		assertEquals(b4.board[22][4], Fields.FULL);
	}
	
	@Test
	public void test_b6() {

		Board b6 = new Board(6);
		assertEquals(b6.board[0][0], Fields.NOTUSED);
		assertEquals(b6.board[12][0], Fields.FULL);
		assertEquals(b6.board[12][6], Fields.EMPTY);
		assertEquals(b6.board[11][1], Fields.FULL);
		assertEquals(b6.board[22][4], Fields.FULL);
	}
	
	

}
