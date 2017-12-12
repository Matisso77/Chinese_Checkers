package pwr.edu.tp.chinesecheckers;

public class Peg {

		
		private Colors color;
		private int x, y;


		public Peg(Colors color, int x, int y){
			this.color = color;
			this.x = x;
			this.y = y;
		}
		
	
		public void setX(int x){
			this.x = x;
		}
		
		public void setY(int y){
			this.y = y;
		}
		
		public int getX(){
			return this.x;
		}
		
		public int getY(){
			return this.y;
		}
		
	
		
	
}
