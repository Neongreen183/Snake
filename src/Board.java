

import java.util.Random;

/**
 * @author Rene Borr
 * Board Class for Snake Game
 * 
 * Board is in charge of keeping track of all of the squares it contains
 */
public class Board {
	
	public Square[][] board;
	int size;
	
	/**
	 * Constructor method for Board
	 * @param size - The number of tiles in the x and y direction
	 */
	public Board(int size){
		this.size = size;
		
		board = new Square[size][size];
		for(int i = 0; i<size;i++){
			for(int j = 0; j<size;j++){
				board[i][j] = new Square(i,j);
			}
		}
	}

	/**
	 * Getter method for Board
	 * @return board - 2D array of Squares
	 */ 
	public Square[][] getBoard() {
		return board;
	}
	
	/**
	 * Randomly places a new food square on the board
	 */
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
