package pwr.edu.tp.chinesecheckers.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pwr.edu.tp.chinesecheckers.OldBoard;
import pwr.edu.tp.chinesecheckers.OldBoard.Fields;

public class Peg_Test {

	@Test
	public void test_b2() {
		
		OldBoard b2 = new OldBoard(2);
		assertEquals(b2.board[0][0], Fields.NOTUSED);
		assertEquals(b2.board[12][0], Fields.FULL);
		assertEquals(b2.board[12][6], Fields.EMPTY);
		assertEquals(b2.board[11][1], Fields.FULL);
		assertEquals(b2.board[22][4], Fields.EMPTY);
	}
	
	@Test
	public void test_b3() {
		
		OldBoard b3 = new OldBoard(3);
	
		assertEquals(b3.board[0][0], Fields.NOTUSED);
		assertEquals(b3.board[12][0], Fields.EMPTY);
		assertEquals(b3.board[12][6], Fields.EMPTY);
		assertEquals(b3.board[11][1], Fields.EMPTY);
		assertEquals(b3.board[22][4], Fields.FULL);
	}
	
	@Test
	public void test_b4() {

		OldBoard b4 = new OldBoard(4);
		assertEquals(b4.board[0][0], Fields.NOTUSED);
		assertEquals(b4.board[11][1], Fields.EMPTY);
		assertEquals(b4.board[12][6], Fields.EMPTY);
		assertEquals(b4.board[11][1], Fields.EMPTY);
		assertEquals(b4.board[22][4], Fields.FULL);
	}
	
	@Test
	public void test_b6() {

		OldBoard b6 = new OldBoard(6);
		assertEquals(b6.board[0][0], Fields.NOTUSED);
		assertEquals(b6.board[12][0], Fields.FULL);
		assertEquals(b6.board[12][6], Fields.EMPTY);
		assertEquals(b6.board[11][1], Fields.FULL);
		assertEquals(b6.board[22][4], Fields.FULL);
	}
	
	

}
