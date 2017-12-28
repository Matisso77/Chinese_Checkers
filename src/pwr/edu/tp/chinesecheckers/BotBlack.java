package pwr.edu.tp.chinesecheckers;

import java.awt.Color;
import java.util.Random;

public class BotBlack {
	int tabPegs[][];
	Board board;
	Game game;
	int goalMoves[];
	Player player;
	Random r = new Random(); 
	int a;
	
	public BotBlack(){
		
		
		
		makeTabPegs(); //Do this only once
		searchField();
	}
	
	private void searchField() {
		if(board.board[12][0] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 12, 0, player, Color.BLACK)){
					goalMoves[0]=tabPegs[i][0];
					goalMoves[1]=tabPegs[i][1];
					goalMoves[2]=12;
					goalMoves[3]=0;
					tabPegs[i][0]=goalMoves[2];
					tabPegs[i][1]=goalMoves[3];
					
					return;
				}
			}
		}
		if(board.board[11][1] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 11, 1, player, Color.BLACK)){
					if(tabPegs[i][1]>1){
						goalMoves[0]=tabPegs[i][0];
						goalMoves[1]=tabPegs[i][1];
						goalMoves[2]=12;
						goalMoves[3]=0;
						tabPegs[i][0]=goalMoves[2];
						tabPegs[i][1]=goalMoves[3];
						return;
						
					}
					
				}
			}
		}	
		if(board.board[13][1] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 13, 1, player, Color.BLACK)){
					if(tabPegs[i][1]>1){
						goalMoves[0]=tabPegs[i][0];
						goalMoves[1]=tabPegs[i][1];
						goalMoves[2]=13;
						goalMoves[3]=1;
						tabPegs[i][0]=goalMoves[2];
						tabPegs[i][1]=goalMoves[3];
						return;
					}
					
				}
			}
		}		
		if(board.board[14][2] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 14, 2, player, Color.BLACK)){
					if(tabPegs[i][1]>2){
						goalMoves[0]=tabPegs[i][0];
						goalMoves[1]=tabPegs[i][1];
						goalMoves[2]=14;
						goalMoves[3]=2;
						tabPegs[i][0]=goalMoves[2];
						tabPegs[i][1]=goalMoves[3];
						return;
					}
					
				}
			}		
		}
		if(board.board[12][2] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 12, 2, player, Color.BLACK)){
					if(tabPegs[i][1]>2){
						goalMoves[0]=tabPegs[i][0];
						goalMoves[1]=tabPegs[i][1];
						goalMoves[2]=12;
						goalMoves[3]=2;
						tabPegs[i][0]=goalMoves[2];
						tabPegs[i][1]=goalMoves[3];
						return;
					}
					
				}
			}		
		}
		if(board.board[10][2] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 10, 2, player, Color.BLACK)){
					if(tabPegs[i][1]>2){
						goalMoves[0]=tabPegs[i][0];
						goalMoves[1]=tabPegs[i][1];
						goalMoves[2]=10;
						goalMoves[3]=2;
						tabPegs[i][0]=goalMoves[2];
						tabPegs[i][1]=goalMoves[3];
						return;
					}
					
				}
			}		
		}
		if(board.board[9][3] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 9, 3, player, Color.BLACK)){
					if(tabPegs[i][1]>3){
						goalMoves[0]=tabPegs[i][0];
						goalMoves[1]=tabPegs[i][1];
						goalMoves[2]=9;
						goalMoves[3]=3;
						tabPegs[i][0]=goalMoves[2];
						tabPegs[i][1]=goalMoves[3];
						return;
					}
					
				}
			}		
		}
		if(board.board[15][3] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 15, 3, player, Color.BLACK)){
					if(tabPegs[i][1]>3){
						goalMoves[0]=tabPegs[i][0];
						goalMoves[1]=tabPegs[i][1];
						goalMoves[2]=15;
						goalMoves[3]=3;
						tabPegs[i][0]=goalMoves[2];
						tabPegs[i][1]=goalMoves[3];
						return;
					}
					
				}
			}		
		}
		if(board.board[11][3] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 11, 3, player, Color.BLACK)){
					if(tabPegs[i][1]>3){
						goalMoves[0]=tabPegs[i][0];
						goalMoves[1]=tabPegs[i][1];
						goalMoves[2]=11;
						goalMoves[3]=3;
						tabPegs[i][0]=goalMoves[2];
						tabPegs[i][1]=goalMoves[3];
						return;
					}
					
				}
			}		
		}
		if(board.board[13][3] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 13, 3, player, Color.BLACK)){
					if(tabPegs[i][1]>3){
						goalMoves[0]=tabPegs[i][0];
						goalMoves[1]=tabPegs[i][1];
						goalMoves[2]=13;
						goalMoves[3]=3;
						tabPegs[i][0]=goalMoves[2];
						tabPegs[i][1]=goalMoves[3];
						return;
					}
					
				}
			}		
		}
		
		a = r.nextInt(10);

		while(tabPegs[a][1]<4){
			a = r.nextInt(10);
		}
		
		for (int y = 4; y <= tabPegs[a][1]; y++) {
			for (int x = 9; x <= 15; x++) {
				if (game.legalMove3(tabPegs[a][0], tabPegs[a][1], x, y, player, Color.BLACK)){
					goalMoves[0]=tabPegs[a][0];
					goalMoves[1]=tabPegs[a][1];
					goalMoves[2]=13;
					goalMoves[3]=3;
					tabPegs[a][0]=goalMoves[2];
					tabPegs[a][1]=goalMoves[3];
					return;
				}
				
			}
		}
		goalMoves[2]=tabPegs[a][0];
		goalMoves[3]=tabPegs[a][1];
		
	}
	
	
	
	
	public void makeTabPegs(){	
		int[] fieldsNumberInRow2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 3, 2, 1};
		int peg=0;
		for (int y = 0; y < board.board[0].length; y++) {
	
			int tempX2 = ((board.board.length - 1) / 2) - (fieldsNumberInRow2[y] / 2) * 2 + (y % 2);
			for (int i = 0; i < fieldsNumberInRow2[y]; i++) {
				tabPegs[peg][0]=tempX2;
				tabPegs[peg][1]=y;
				peg++;
				tempX2 += 2;
			}
		}
	}
}
