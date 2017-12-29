package pwr.edu.tp.chinesecheckers;

import java.awt.Color;
import java.util.Random;

public class BotOrange extends Player {
	int tabPegs[][];
	int goalMoves[];
	Random r = new Random();
	int a;

	public BotOrange() {
		tabPegs = new int[10][2];
		goalMoves = new int[4];
		makeTabPegs(); // Do this only once
		// searchField();
	}

	private void searchField() {

		while(true)
		{
			a = r.nextInt(10);
			
			
			
			for (int y = 4; y <= tabPegs[a][1] + 3; y++) {
				for (int x = 24; x>=tabPegs[a][0]; x--) {	
					
					if (game.legalMove3(tabPegs[a][0], tabPegs[a][1], x, y, this, Color.ORANGE)){
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

	public void makeTabPegs() {
		int[] fieldsNumberInRow65 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0 };
		int temp_vector65 = 0;
		int tempX65 = 3;
		int peg=0;
		for (int y = 0; y <17; y++) {

			tempX65 += temp_vector65;
			if (fieldsNumberInRow65[y] != 0)
				temp_vector65++;
			for (int i = 0; i < fieldsNumberInRow65[y]; i++) {
				tabPegs[peg][0]=tempX65;
				tabPegs[peg][1]=y;
				tempX65 -= 2;
			}
			tempX65 = 3;

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
			sleep(10);
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
