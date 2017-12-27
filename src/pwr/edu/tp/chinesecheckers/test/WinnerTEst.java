package pwr.edu.tp.chinesecheckers.test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.awt.Color;

import pwr.edu.tp.chinesecheckers.Board;
import pwr.edu.tp.chinesecheckers.Game;

public class WinnerTEst{
	
	Board board = new Board(2);
	//b2 is method, that makes the end stan of game - just for test if it real ends

	@Test
	public void test1() {
		b2();
		boolean ans= true;
		assertEquals(hasWinner(Color.BLUE), ans);
	}
	@Test
	public void test2() {
		b2();
		boolean ans= true;
		assertEquals(hasWinner(Color.BLACK), ans);	
	}
	@Test
	public void test3() {
		b2();
		board.board[12][0] = Color.ORANGE;
		boolean ans= false;
		assertEquals(hasWinner(Color.BLACK), ans);	
	}
	@Test
	public void test4() {
		b2();
		board.board[12][0] = Color.GRAY;
		boolean ans= false;
		assertEquals(hasWinner(Color.BLACK), ans);	
	}
	@Test
	public void test5() {
		b2();
		board.board[12][2] = Color.GRAY;
		boolean ans= false;
		assertEquals(hasWinner(Color.BLACK), ans);	
	}
	@Test
	public void test6() {
		b2();
		board.board[12][0] = Color.GRAY;
		boolean ans= false;
		assertEquals(hasWinner(Color.BLACK), ans);	
	}
	@Test
	public void test7() {
		b2();
		board.board[12][0] = Color.GRAY;
		boolean ans= true;
		assertEquals(hasWinner(Color.PINK), ans);	
	}
	
	@Test
	public void test8() {
		b2();
		board.board[12][2] = Color.ORANGE;
		boolean ans= false;
		assertEquals(hasWinner(Color.BLACK), ans);	
	}
	@Test
	public void test9() {
		b2();
		board.board[12][14] = Color.ORANGE;
		boolean ans= false;
		assertEquals(hasWinner(Color.BLUE), ans);	
	}
	@Test
	public void test10() {
		b2();
		board.board[3][5] = Color.BLUE;
		board.board[12][14] = Color.RED;
		boolean ans= false;
		assertEquals(hasWinner(Color.GREEN), ans);	
	}
	public void b2() {
		
			/*
		int[] fieldsNumberInRow61 = { 1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		
		for (int y = 0; y < board.board[0].length; y++) {

			int tempX = ((board.board.length - 1) / 2) - (fieldsNumberInRow61[y] / 2) * 2 + (y % 2);
			for (int i = 0; i < fieldsNumberInRow61[y]; i++) {
				*/
			
		int[] fieldsNumberInRow61 = { 1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 3, 2, 1 };
		for (int y = 0; y < board.board[0].length; y++) {

			int tempX = ((board.board.length - 1) / 2) - (fieldsNumberInRow61[y] / 2) * 2 + (y % 2);
			for (int i = 0; i < fieldsNumberInRow61[y]; i++) {
				if (y < 5) {
					board.board[tempX][y] = Color.BLACK;
				} else {
					board.board[tempX][y] = Color.BLUE;
				}
				tempX += 2;
			}
		}

		int[] fieldsNumberInRow62 = { 0, 0, 0, 0, 4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int temp_vector62 = 0;
		int tempX62 = 24;
		for (int y = 0; y < board.board[0].length; y++) {

			tempX62 -= temp_vector62;
			if (fieldsNumberInRow62[y] != 0)
				temp_vector62++;
			for (int i = 0; i < fieldsNumberInRow62[y]; i++) {
				board.board[tempX62][y] = Color.ORANGE;
				tempX62 -= 2;
			}
			tempX62 = 24;

		}

		int[] fieldsNumberInRow63 = { 0, 0, 0, 0, 4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int temp_vector63 = 0;
		int tempX63 = 0;
		for (int y = 0; y < board.board[0].length; y++) {

			tempX63 += temp_vector63;
			if (fieldsNumberInRow63[y] != 0)
				temp_vector63++;
			for (int i = 0; i < fieldsNumberInRow63[y]; i++) {
				board.board[tempX63][y] = Color.GREEN;
				tempX63 += 2;
			}
			tempX63 = 0;

		}
		int[] fieldsNumberInRow64 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0 };
		int temp_vector64 = 0;
		int tempX64 = 21;
		for (int y = 0; y < board.board[0].length; y++) {

			tempX64 -= temp_vector64;
			if (fieldsNumberInRow64[y] != 0)
				temp_vector64++;
			for (int i = 0; i < fieldsNumberInRow64[y]; i++) {
				board.board[tempX64][y] = Color.PINK;
				tempX64 += 2;
			}
			tempX64 = 21;

		}

		int[] fieldsNumberInRow65 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0 };
		int temp_vector65 = 0;
		int tempX65 = 3;
		for (int y = 0; y < board.board[0].length; y++) {

			tempX65 += temp_vector65;
			if (fieldsNumberInRow65[y] != 0)
				temp_vector65++;
			for (int i = 0; i < fieldsNumberInRow65[y]; i++) {
				board.board[tempX65][y] = Color.RED;
				tempX65 -= 2;
			}
			tempX65 = 3;

		}
			
		}
	
	public boolean hasWinner(Color color) {
		int winner;
		winner = 0;
		
		if (color == Color.BLACK) {
			int[] fieldsNumberInRow61 = { 1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			
			for (int y = 0; y < board.board[0].length; y++) {

				int tempX = ((board.board.length - 1) / 2) - (fieldsNumberInRow61[y] / 2) * 2 + (y % 2);
				for (int i = 0; i < fieldsNumberInRow61[y]; i++) {
					if (board.board[tempX][y] == Color.BLACK){
						winner++;
						
					}
				tempX += 2;
				}
				
			}
			if (winner == 10) {
			
				return true;
			}
		}

		else if (color == Color.BLUE) {
			int[] fieldsNumberInRow61 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 3, 2, 1 };
			for (int y = 0; y < board.board[0].length; y++) {

				int tempX = ((board.board.length - 1) / 2) - (fieldsNumberInRow61[y] / 2) * 2 + (y % 2);
				for (int i = 0; i < fieldsNumberInRow61[y]; i++) {
					if (board.board[tempX][y] == Color.BLUE){
						winner++;
					}
					tempX += 2;
				}
				if (winner == 10) {
				
					return true;
				}
			}
		} else if (color == Color.ORANGE) {
			int[] fieldsNumberInRow62 = { 0, 0, 0, 0, 4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			int temp_vector62 = 0;
			int tempX62 = 24;
			for (int y = 0; y < board.board[0].length; y++) {

				tempX62 -= temp_vector62;
				if (fieldsNumberInRow62[y] != 0)
					temp_vector62++;
				for (int i = 0; i < fieldsNumberInRow62[y]; i++) {
					if (board.board[tempX62][y] == Color.ORANGE)
						winner++;
					tempX62 -= 2;
				}
				tempX62 = 24;
				if (winner == 10) {
					
					return true;
				}
			}
		} else if (color == Color.GREEN) {
			int[] fieldsNumberInRow63 = { 0, 0, 0, 0, 4, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			int temp_vector63 = 0;
			int tempX63 = 0;
			for (int y = 0; y < board.board[0].length; y++) {

				tempX63 += temp_vector63;
				if (fieldsNumberInRow63[y] != 0)
					temp_vector63++;
				for (int i = 0; i < fieldsNumberInRow63[y]; i++) {
					if (board.board[tempX63][y] == Color.GREEN)
						winner++;
					tempX63 += 2;
				}
				tempX63 = 0;
				if (winner == 10) {
					System.out.println("Green ends");
					return true;
				}
			}
		} else if (color == Color.PINK) {
			int[] fieldsNumberInRow64 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0 };
			int temp_vector64 = 0;
			int tempX64 = 21;
			for (int y = 0; y < board.board[0].length; y++) {

				tempX64 -= temp_vector64;
				if (fieldsNumberInRow64[y] != 0)
					temp_vector64++;
				for (int i = 0; i < fieldsNumberInRow64[y]; i++) {
					if (board.board[tempX64][y] == Color.PINK)
						winner++;
					tempX64 += 2;
				}
				tempX64 = 21;
				if (winner == 10) {
				
					return true;
				}
			}
		} else if (color == Color.RED) {
			int[] fieldsNumberInRow65 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0 };
			int temp_vector65 = 0;
			int tempX65 = 3;
			for (int y = 0; y < board.board[0].length; y++) {

				tempX65 += temp_vector65;
				if (fieldsNumberInRow65[y] != 0)
					temp_vector65++;
				for (int i = 0; i < fieldsNumberInRow65[y]; i++) {
					if (board.board[tempX65][y] == Color.RED)
						winner++;

					tempX65 -= 2;
				}
				tempX65 = 3;
				if (winner == 10) {
			
					return true;
				}
			}
		}
		return false;

	}
	
}

	


