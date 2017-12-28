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
		
		a = r.nextInt(10);

		while(tabPegs[a][1]>0){
			a = r.nextInt(10);
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
		goalMoves[2]=tabPegs[a][0];
		goalMoves[3]=tabPegs[a][1];
		
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