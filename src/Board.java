

import java.util.Random;

public class Board {
	
	public Square[][] board;
	int size;
	
	
	public Board(int size){
		this.size = size;
		
		board = new Square[size][size];
		for(int i = 0; i<size;i++){
			for(int j = 0; j<size;j++){
				board[i][j] = new Square(i,j);
			}
		}
	}

	public Square[][] getBoard() {
		return board;
	}

	public void setBoard(Square[][] board) {
		this.board = board;
	}
	
	public void placeFood(){
		Random rand = new Random();
		
		int x = rand.nextInt(size);
		int y = rand.nextInt(size);
		while(board[x][y].getType() == Square.SNAKE){
			 x = rand.nextInt(size);
			 y = rand.nextInt(size);
		}
		
		board[x][y].setType(Square.FOOD);
		
	}
	
	


}
