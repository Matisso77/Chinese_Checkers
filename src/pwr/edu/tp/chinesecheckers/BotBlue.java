package pwr.edu.tp.chinesecheckers;

import java.awt.Color;
import java.util.Random;

public class BotBlue extends Player {
	int tabPegs[][];
	int goalMoves[];
	Random r = new Random(); 
	int a;
	
	public BotBlue(){
		tabPegs = new int[10][2];
		goalMoves = new int[4];
		makeTabPegs();
	}
	
	private void searchField() {
		
		System.out.println("Hello");
		if(game.board.board[12][16] != Color.BLACK){
			for(int i=0; i<10; i++){
				System.out.println(tabPegs[i][0]+ " " + tabPegs[i][1]);
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 12, 16, this, Color.BLACK)){
					goalMoves[0]=tabPegs[i][0];
					goalMoves[1]=tabPegs[i][1];
					goalMoves[2]=12;
					goalMoves[3]=16;
					tabPegs[i][0]=goalMoves[2];
					tabPegs[i][1]=goalMoves[3];
					
					return;
				}
			}
		}
		System.out.println("Hello");
		if(game.board.board[11][15] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 11, 15, this, Color.BLACK)){
					if(tabPegs[i][1]<15){
						goalMoves[0]=tabPegs[i][0];
						goalMoves[1]=tabPegs[i][1];
						goalMoves[2]=11;
						goalMoves[3]=15;
						tabPegs[i][0]=goalMoves[2];
						tabPegs[i][1]=goalMoves[3];
						return;
						
					}
					
				}
			}
		}	
		if(game.board.board[13][15] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 13, 15, this, Color.BLACK)){
					if(tabPegs[i][1]<15){
						goalMoves[0]=tabPegs[i][0];
						goalMoves[1]=tabPegs[i][1];
						goalMoves[2]=13;
						goalMoves[3]=15;
						tabPegs[i][0]=goalMoves[2];
						tabPegs[i][1]=goalMoves[3];
						return;
					}
					
				}
			}
		}		
		if(game.board.board[14][14] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 14, 14, this, Color.BLACK)){
					if(tabPegs[i][1]<14){
						goalMoves[0]=tabPegs[i][0];
						goalMoves[1]=tabPegs[i][1];
						goalMoves[2]=14;
						goalMoves[3]=14;
						tabPegs[i][0]=goalMoves[2];
						tabPegs[i][1]=goalMoves[3];
						return;
					}
					
				}
			}		
		}
		if(game.board.board[12][14] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 12, 14, this, Color.BLACK)){
					if(tabPegs[i][1]<14){
						goalMoves[0]=tabPegs[i][0];
						goalMoves[1]=tabPegs[i][1];
						goalMoves[2]=12;
						goalMoves[3]=14;
						tabPegs[i][0]=goalMoves[2];
						tabPegs[i][1]=goalMoves[3];
						return;
					}
					
				}
			}		
		}
		if(game.board.board[10][14] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 10, 14, this, Color.BLACK)){
					if(tabPegs[i][1]<14){
						goalMoves[0]=tabPegs[i][0];
						goalMoves[1]=tabPegs[i][1];
						goalMoves[2]=10;
						goalMoves[3]=14;
						tabPegs[i][0]=goalMoves[2];
						tabPegs[i][1]=goalMoves[3];
						return;
					}
					
				}
			}		
		}
		if(game.board.board[9][13] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 9, 13, this, Color.BLACK)){
					if(tabPegs[i][1]<13){
						goalMoves[0]=tabPegs[i][0];
						goalMoves[1]=tabPegs[i][1];
						goalMoves[2]=9;
						goalMoves[3]=13;
						tabPegs[i][0]=goalMoves[2];
						tabPegs[i][1]=goalMoves[3];
						return;
					}
					
				}
			}		
		}
		if(game.board.board[15][13] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 15, 13, this, Color.BLACK)){
					if(tabPegs[i][1]<13){
						goalMoves[0]=tabPegs[i][0];
						goalMoves[1]=tabPegs[i][1];
						goalMoves[2]=15;
						goalMoves[3]=13;
						tabPegs[i][0]=goalMoves[2];
						tabPegs[i][1]=goalMoves[3];
						return;
					}
					
				}
			}		
		}
		if(game.board.board[11][13] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 11, 13, this, Color.BLACK)){
					if(tabPegs[i][1]<13){
						goalMoves[0]=tabPegs[i][0];
						goalMoves[1]=tabPegs[i][1];
						goalMoves[2]=11;
						goalMoves[3]=13;
						tabPegs[i][0]=goalMoves[2];
						tabPegs[i][1]=goalMoves[3];
						return;
					}
					
				}
			}		
		}
		if(game.board.board[13][13] != Color.BLACK){
			for(int i=0; i<10; i++){
				
				if (game.legalMove3(tabPegs[i][0], tabPegs[i][1], 13, 13, this, Color.BLACK)){
					if(tabPegs[i][1]<13){
						goalMoves[0]=tabPegs[i][0];
						goalMoves[1]=tabPegs[i][1];
						goalMoves[2]=13;
						goalMoves[3]=13;
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

			while(tabPegs[a][1]>17){
				a = r.nextInt(10);
				System.out.println(tabPegs[a][0]+ " " + tabPegs[a][1]);
			}
			
			for (int y = 17; y >= tabPegs[a][1]; y--) {
				for (int x = 9; x <= 15; x++) {
					if (game.legalMove3(tabPegs[a][0], tabPegs[a][1], x, y, this, Color.BLUE)){
						goalMoves[0]=tabPegs[a][0];
						goalMoves[1]=tabPegs[a][1];
						goalMoves[2]=x;
						goalMoves[3]=y;
						tabPegs[a][0]=goalMoves[2];
						tabPegs[a][1]=goalMoves[3];
						return;
					}
					
				}
			}
		}
		
	
		
	}
			
	public void makeTabPegs(){	
		int[] fieldsNumberInRow2 = { 1, 2, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int peg=0;
		for (int y = 0; y < 17; y++) {
	
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
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		game.move(goalMoves[0], goalMoves[1], goalMoves[2], goalMoves[3]);
		game.playerDone(this);
	}

	@Override
	public void end() {
		dead = true;
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
		
		while (!dead) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
