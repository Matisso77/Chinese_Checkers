package pwr.edu.tp.chinesecheckers;

import java.awt.Color;
import java.util.Random;

public class BotBlack extends Player {
	int tabPegs[][];
	int goalMoves[];
	Random r = new Random(); 
	int a;
	
	public BotBlack(){
		tabPegs = new int[10][2];
		goalMoves = new int[4];
		makeTabPegs(); //Do this only once
		//searchField();
	}
	
	private void searchField() {
		
		
		System.out.println("Hello");
		if(game.board.board[12][0] != Color.BLACK){
			for(int i=0; i<10; i++){
				System.out.println(tabPegs[i][0]+ " " + tabPegs[i][1]);
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 12, 0, this, Color.BLACK)){
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
		System.out.println("Hello");
		if(game.board.board[11][1] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 11, 1, this, Color.BLACK)){
					if(tabPegs[i][1]>1){
						goalMoves[0]=tabPegs[i][0];
						goalMoves[1]=tabPegs[i][1];
						goalMoves[2]=11;
						goalMoves[3]=1;
						tabPegs[i][0]=goalMoves[2];
						tabPegs[i][1]=goalMoves[3];
						return;
						
					}
					
				}
			}
		}	
		if(game.board.board[13][1] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 13, 1, this, Color.BLACK)){
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
		if(game.board.board[14][2] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 14, 2, this, Color.BLACK)){
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
		if(game.board.board[12][2] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 12, 2, this, Color.BLACK)){
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
		if(game.board.board[10][2] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 10, 2, this, Color.BLACK)){
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
		if(game.board.board[9][3] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 9, 3, this, Color.BLACK)){
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
		if(game.board.board[15][3] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 15, 3, this, Color.BLACK)){
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
		if(game.board.board[11][3] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 11, 3, this, Color.BLACK)){
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
		if(game.board.board[13][3] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 13, 3, this, Color.BLACK)){
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
		
		while(true)
		{
			a = r.nextInt(10);

			while(tabPegs[a][1]<=3){
				a = r.nextInt(10);
			}
			System.out.println(tabPegs[a][0]+ " " + tabPegs[a][1]);
			for (int y = 4; y <= tabPegs[a][1]; y++) {
				for (int x = 9; x <= 15; x++) {
					//System.out.println(tabPegs[a][0]+ " " + tabPegs[a][1]);
				
					if (game.legalMove3(tabPegs[a][0], tabPegs[a][1], x, y, this, Color.BLACK)){
						goalMoves[0]=tabPegs[a][0];
						goalMoves[1]=tabPegs[a][1];
						goalMoves[2]=x;
						goalMoves[3]=y;
						
						//System.out.println(tabPegs[a][0]+ " " + tabPegs[a][1]);
						
						tabPegs[a][0]=x;
						tabPegs[a][1]=y;
						
						//System.out.println(tabPegs[a][0]+ " " + tabPegs[a][1]);
						
						//System.out.println(a + " " + goalMoves[0]+ " " + goalMoves[1]+ " " + goalMoves[2]+ " " + goalMoves[3]);
						
						return;
					}
					
				}
			}
			
		}
		
	}
		
	
	
	
	public void makeTabPegs(){	
		int[] fieldsNumberInRow2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 3, 2, 1};
		int peg=0;
		for (int y = 0; y <17; y++) {
	
			int tempX2 = ((25 - 1) / 2) - (fieldsNumberInRow2[y] / 2) * 2 + (y % 2);
			for (int i = 0; i < fieldsNumberInRow2[y]; i++) {
				tabPegs[peg][0]=tempX2;
				tabPegs[peg][1]=y;
				peg++;
				tempX2 += 2;
			}
		}
	}

	@Override
	public void setColor(Color color, String colorS) {
		this.color = color;
		this.colorS = colorS;
	}

	@Override
	public void otherPlayerDone(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean sendBoard(Color[][] board) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void yourMove() {
		searchField();
			/*
			for(int i=0; i<10; i++){
				System.out.println(tabPegs[i][0]+ " " + tabPegs[i][1]);
			}
				
			
			//game.move(12, 16, 10, 14);
			*/
		game.move(goalMoves[0], goalMoves[1], goalMoves[2], goalMoves[3]);
		game.playerDone(this);
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
		if (this == game.currentPlayer) {
			yourMove();
		}
		
		while(true) {
			
		}
	}
}
