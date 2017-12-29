package pwr.edu.tp.chinesecheckers;

import java.awt.Color;
import java.util.Random;

public class BotGreen extends Player {
	int tabPegs[][];
	int goalMoves[];
	Random r = new Random();
	int a;

	public BotGreen() {
		tabPegs = new int[10][2];
		goalMoves = new int[4];
		makeTabPegs(); // Do this only once
		// searchField();
	}

	private void searchField() {

		while(true)
		{
			a = r.nextInt(10);
			
			
			//System.out.println(a+ " "+tabPegs[a][0] + " " + tabPegs[a][1]);
			for (int y = 4; y <= tabPegs[a][1] + 3; y++) {
				for (int x = 0; x<=tabPegs[a][0]; x++) {	
					
					if (game.legalMove3(tabPegs[a][0], tabPegs[a][1], x, y, this, Color.GREEN)){
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
		int[] fieldsNumberInRow64 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0 };
		int temp_vector64 = 0;
		int tempX64 = 21;
		int peg=0;
		for (int y = 0; y < 17; y++) {

			tempX64 -= temp_vector64;
			if (fieldsNumberInRow64[y] != 0)
				temp_vector64++;
			for (int i = 0; i < fieldsNumberInRow64[y]; i++) {
				tabPegs[peg][0]=tempX64;
				tabPegs[peg][1]=y;
				System.out.println(tabPegs[peg][0] + " " + tabPegs[peg][1]);
				tempX64 += 2;
				
			}
			tempX64 = 21;

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
