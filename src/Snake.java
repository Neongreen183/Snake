

import java.util.LinkedList;

/**
 * @author Rene Borr
 * Snake Class for Snake Game
 * 
 * Snake keeps track of its location on the board, the score, and if its alive
 *
 */
public class Snake {
	
	//Create movement types for Snake
	public final static int UP = 0;
	public final static int DOWN = 1;
	public final static int RIGHT = 2;
	public final static int LEFT = 3;
	
	
	public Board board;
	public boolean alive = true;
	LinkedList<Square> snake;
	public int score = 0;
	
	/**
	 * Constructor method for Snake
	 * @param board
	 * @param startSize - the number of tiles the snake should take up at start of the game
	 */
	public Snake(Board board,int startSize){
		this.board = board;
		snake = new LinkedList<Square>();
		
		//add all the squares to the snake
		for(int i = 25+startSize;i>25;i--)
			snake.add(board.getBoard()[25][i]);

		//Make those squares snake tiles
		for(Square square : snake)
		    square.setType(Square.SNAKE);
		
		
	}
	
	/**
	 * Move the snake one tile in the specified direction
	 * @param direction - integer representation of a direction
	 */
	public void move(int direction){
		// get the current head of the snake
		Square head = snake.getFirst();
		
		//get the square that the snake is moving to
		Square add;
		try{
			if(direction == UP)
				add = board.getBoard()[head.x][head.y-1];
			
			else if(direction == DOWN)
				add = board.getBoard()[head.x][head.y+1];
			
			else if(direction == LEFT)
				add = board.getBoard()[head.x-1][head.y];
			
			else
				add = board.getBoard()[head.x+1][head.y];
		
			//if the next square is part of the snake, kill the snake
			if(add.getType() == Square.SNAKE){
				alive = false;
			}
			
			//of the next space is free move the snake
			if(add.getType() != Square.FOOD){
				Square tail = snake.removeLast();
				tail.setType(0);
			}
			//if the next square is food, increase the snake length and score by one
			else{
				board.placeFood();
				score++;
			}
			
			add.setType(Square.SNAKE);
			snake.addFirst(add);
			
			
			
		}
		//if there is an exception (the snake goes out of bounds), kill the snake
		catch(Exception e){
			alive = false;
		}
		
		
	}
	
	/**
	 * Getter method for Score
	 * @return score
	 */
	public int getScore(){
		return score;
	}
	

	
	

}
