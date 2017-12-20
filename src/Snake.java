

import java.util.LinkedList;


public class Snake {
	public final static int UP = 0;
	public final static int DOWN = 1;
	public final static int RIGHT = 2;
	public final static int LEFT = 3;
	
	public Board board;
	
	public boolean alive = true;
	
	LinkedList<Square> snake;
	
	public int score = 0;
	
	public Snake(Board board,int startSize){
		this.board = board;
		snake = new LinkedList<Square>();
		
		for(int i = 25+startSize;i>25;i--)
			snake.add(board.getBoard()[25][i]);

		for(Square square : snake)
		    square.setType(Square.SNAKE);
		
		
	}
	
	public void move(int direction){
		
		Square head = snake.getFirst();
		
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
		
			if(add.getType() == Square.SNAKE){
				alive = false;
			}
			
			if(add.getType() != Square.FOOD){
				Square tail = snake.removeLast();
				tail.setType(0);
			}
			else{
				board.placeFood();
				score++;
			}
			
			add.setType(Square.SNAKE);
			snake.addFirst(add);
			
			
			
		}
		catch(Exception e){
			alive = false;
		}
		
		
	}
	
	public int getScore(){
		return score;
	}
	

	
	

}
