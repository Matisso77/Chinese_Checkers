package pwr.edu.tp.chinesecheckers;


public class Board {
	public enum Fields {
		NOTUSED, EMPTY, FULL;
	}
	
	public static Fields board[][];
	
	public Board(int number_players) {
		prepareBoard();
		addPlayesPegs(number_players);
	}
	
	private void prepareBoard() {
		board = new Fields[25][17]; //First field is 0 not 1
		
		for(int y = 0; y < board[0].length; y++) {
			for(int x = 0; x < board.length; x++) {
				board[x][y] = Fields.NOTUSED;
			}
		}
		
		int[] fieldsNumberInRow = {1,2,3,4,13,12,11,10,9,10,11,12,13,4,3,2,1}; 
		for(int y = 0; y < board[0].length; y++) {
		
			int tempX  = ((board.length - 1) / 2) - (fieldsNumberInRow [y] / 2) * 2 + (y%2);
			for(int i = 0; i < fieldsNumberInRow[y]; i++) {
				board[tempX][y] = Fields.EMPTY;
				tempX+=2;	
			}
		}
		
	}
	
	private void addPlayesPegs(int number_players) {
		 switch (number_players) {
         case 2: 
	        	 int[] fieldsNumberInRow2 = {1,2,3,4,0,0,0,0,0,0,0,0,0,4,3,2,1}; 
	        	 for(int y = 0; y < board[0].length; y++) {
				
				int tempX2 = ((board.length - 1) / 2) - (fieldsNumberInRow2 [y] / 2) * 2 + (y%2);
				for(int i = 0; i < fieldsNumberInRow2[y]; i++) {
					board[tempX2][y] = Fields.FULL;
					tempX2+=2;	
					//TODO: CHECK THAT IS REAL WORKS:
					new Peg(Colors.BLUE, tempX2, y);
				}
			}
	        break;          
                  
                
                  
                  
                  
         case 3:  
	        	 int[] fieldsNumberInRow31 = {0,0,0,0,0,0,0,0,0,0,0,0,0,4,3,2,1}; 
	        	 for(int y = 0; y < board[0].length; y++) {
					
					int tempX = ((board.length - 1) / 2) - (fieldsNumberInRow31 [y] / 2) * 2 + (y%2);
					for(int i = 0; i < fieldsNumberInRow31[y]; i++) {
						board[tempX][y] = Fields.FULL;
					
						tempX+=2;	
				}
				 
	        	 }
	        	 int[] fieldsNumberInRow32 = {0,0,0,0,4,3,2,1,0,0,0,0,0,0,0,0,0};
	        	 int temp_vector32=0;
	        	 int tempX32 = 24;
	        	 for(int y = 0; y < board[0].length; y++) {
	        		
	        		 	
						tempX32 -=temp_vector32;
						if(fieldsNumberInRow32 [y]!=0)
							temp_vector32++;
						for(int i = 0; i < fieldsNumberInRow32[y]; i++) {
							board[tempX32][y] = Fields.FULL;
							tempX32-=2;	

						}
						tempX32 = 24;
					
		        	 }
	        	 
	        	 int[] fieldsNumberInRow33 = {0,0,0,0,4,3,2,1,0,0,0,0,0,0,0,0,0};
	        	 int temp_vector33=0;
	        	 int tempX33 = 0;
	        	 for(int y = 0; y < board[0].length; y++) {
	        		
	        		 	
						tempX33 +=temp_vector33;
						if(fieldsNumberInRow33 [y]!=0)
							temp_vector33++;
						for(int i = 0; i < fieldsNumberInRow33[y]; i++) {
							board[tempX33][y] = Fields.FULL;
							tempX33 +=2;	
						}
						tempX33 = 0;
					
		        	 }
	        	 break;
	        	 
                  
         case 4:  
        	 int[] fieldsNumberInRow41 = {0,0,0,0,4,3,2,1,0,0,0,0,0,0,0,0,0};
	    	 int temp_vector41=0;
	    	 int tempX41 = 24;
	    	 for(int y = 0; y < board[0].length; y++) {
	    		
	    		 	
					tempX41 -=temp_vector41;
					if(fieldsNumberInRow41 [y]!=0)
						temp_vector41++;
					for(int i = 0; i < fieldsNumberInRow41[y]; i++) {
						board[tempX41][y] = Fields.FULL;
						tempX41-=2;	
					}
					tempX41 = 24;
				
	        	 }
	    	 
	    	 int[] fieldsNumberInRow42 = {0,0,0,0,4,3,2,1,0,0,0,0,0,0,0,0,0};
	    	 int temp_vector42=0;
	    	 int tempX42 = 0;
	    	 for(int y = 0; y < board[0].length; y++) {
	    		
	    		 	
					tempX42 +=temp_vector42;
					if(fieldsNumberInRow42 [y]!=0)
						temp_vector42++;
					for(int i = 0; i < fieldsNumberInRow42[y]; i++) {
						board[tempX42][y] = Fields.FULL;
						tempX42 +=2;	
					}
					tempX42 = 0;
			
        	 }
	    	 int[] fieldsNumberInRow43 = {0,0,0,0,0,0,0,0,0,1,2,3,4,0,0,0,0};
	    	 int temp_vector43=0;
	    	 int tempX43 = 21;
	    	 for(int y = 0; y < board[0].length; y++) {
	    		
	    		 	
					tempX43 -=temp_vector43;
					if(fieldsNumberInRow43 [y]!=0)
						temp_vector43++;
					for(int i = 0; i < fieldsNumberInRow43[y]; i++) {
						board[tempX43][y] = Fields.FULL;
						tempX43+=2;	
					}
					tempX43 = 21;
				
	        	 }
	    	 
	    	 int[] fieldsNumberInRow44 = {0,0,0,0,0,0,0,0,0,1,2,3,4,0,0,0,0};
	    	 int temp_vector44=0;
	    	 int tempX44 = 3;
	    	 for(int y = 0; y < board[0].length; y++) {
	    		
	    		 	
					tempX44 +=temp_vector44;
					if(fieldsNumberInRow44 [y]!=0)
						temp_vector44++;
					for(int i = 0; i < fieldsNumberInRow44[y]; i++) {
						board[tempX44][y] = Fields.FULL;
						tempX44 -=2;	
					}
					tempX44 = 3;
					
        	 }
	    	 break; 
                  
         case 6:  
        	 
	        	 int[] fieldsNumberInRow61 = {1,2,3,4,0,0,0,0,0,0,0,0,0,4,3,2,1}; 
	        	 for(int y = 0; y < board[0].length; y++) {
				
				int tempX = ((board.length - 1) / 2) - (fieldsNumberInRow61 [y] / 2) * 2 + (y%2);
				for(int i = 0; i < fieldsNumberInRow61[y]; i++) {
					board[tempX][y] = Fields.FULL;
					tempX+=2;	
					}
	        	 }
        	 
        	 int[] fieldsNumberInRow62 = {0,0,0,0,4,3,2,1,0,0,0,0,0,0,0,0,0};
	    	 int temp_vector62=0;
	    	 int tempX62 = 24;
	    	 for(int y = 0; y < board[0].length; y++) {
	    		
	    		 	
					tempX62 -=temp_vector62;
					if(fieldsNumberInRow62 [y]!=0)
						temp_vector62++;
					for(int i = 0; i < fieldsNumberInRow62[y]; i++) {
						board[tempX62][y] = Fields.FULL;
						tempX62-=2;	
					}
					tempX62 = 24;
				
	        	 }
	    	 
	    	 int[] fieldsNumberInRow63 = {0,0,0,0,4,3,2,1,0,0,0,0,0,0,0,0,0};
	    	 int temp_vector63=0;
	    	 int tempX63 = 0;
	    	 for(int y = 0; y < board[0].length; y++) {
	    		
	    		 	
					tempX63 +=temp_vector63;
					if(fieldsNumberInRow63 [y]!=0)
						temp_vector63++;
					for(int i = 0; i < fieldsNumberInRow63[y]; i++) {
						board[tempX63][y] = Fields.FULL;
						tempX63 +=2;	
					}
					tempX63 = 0;
			
        	 }
	    	 int[] fieldsNumberInRow64 = {0,0,0,0,0,0,0,0,0,1,2,3,4,0,0,0,0};
	    	 int temp_vector64=0;
	    	 int tempX64 = 21;
	    	 for(int y = 0; y < board[0].length; y++) {
	    		
	    		 	
					tempX64 -=temp_vector64;
					if(fieldsNumberInRow64 [y]!=0)
						temp_vector64++;
					for(int i = 0; i < fieldsNumberInRow64[y]; i++) {
						board[tempX64][y] = Fields.FULL;
						tempX64+=2;	
					}
					tempX64 = 21;
				
	        	 }
	    	 
	    	 int[] fieldsNumberInRow65 = {0,0,0,0,0,0,0,0,0,1,2,3,4,0,0,0,0};
	    	 int temp_vector65=0;
	    	 int tempX65 = 3;
	    	 for(int y = 0; y < board[0].length; y++) {
	    		
	    		 	
					tempX65 +=temp_vector65;
					if(fieldsNumberInRow65 [y]!=0)
						temp_vector65++;
					for(int i = 0; i < fieldsNumberInRow65[y]; i++) {
						board[tempX65][y] = Fields.FULL;
						tempX65 -=2;	
					}
					tempX65 = 3;
					
        	 }
	    	 break; 
		 }
		 }
}