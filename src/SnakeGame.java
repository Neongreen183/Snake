import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

/**
 * 
 * @author Rene Borr
 * A Java Code implementation of the classic game Snake, using the processing library
 * 
 * Sources:
 *  Font - //http://www.myfonts.com/fonts/k-type/subway-ticker/
 *
 */
public class SnakeGame extends PApplet{

	
	public Board board;
	public Snake snake;

	public int size = 100;
	public int tileSize = 6;

	public int direction = Snake.DOWN;

	public boolean openScreen = true;
	
	
    public static void main(String[] args) {
        PApplet.main("SnakeGame");
    }
    
    /**
     * Necessary Class for Processing
     */
    public void settings(){
    	//set size of Screen
    	//size(size*tileSize,size*tileSize);
    	size(600,600);

    }
    /**
     * Necessary Class for Processing
     */
    public void setup(){
    	//set the frame rate to 15, to ensure constant speed
		frameRate(15);

		//Set up ticker font
		PFont font = createFont("tickerFont.ttf",32);
		textFont(font);
		
		//instantiate Board and Snake
		board = new Board(size);
		board.placeFood();
		snake = new Snake(board,15);

    }

    /**
     * Necessary class for Processing
     * Actively draws to screen every tick
     */
    public void draw(){
    	
    	//Draw the game board
		drawBoard();
		
		//Create opening Screen
		if(openScreen == true){
			fill(0,0,255);
			textSize(32);

			text("Press any key to start.", 30, 50); 
		}
		
		//Draw the Score and move the snake if the game is active
		else if(snake.alive == true){
			snake.move(direction);
			fill(0,0,255);
			textSize(15);
			text("Score: " + snake.getScore(), (size*tileSize) - 75, 30); 
		}
		
		//If the player is dead, draw game over screen
		else if(snake.alive == false){
			fill(0,0,255);

			PImage gameOver = loadImage("gameOver.png");
			gameOver.resize(size*tileSize, size*tileSize);
			image(gameOver,0,0);

			textSize(32);
			fill(0,0,255);
			text("Final Score: " + snake.getScore(),25, size*tileSize - 50);

		}
    }
    

    /**
     * Method From Processing activates when a key is pressed
     */
	public void keyPressed(){
		//Start the game and exit starting screen
		openScreen = false;
		
		//Change the direction of the snake depending on user selection
		if(keyCode == UP){
			if(direction != Snake.DOWN)
				direction = Snake.UP;
		}
		else if(keyCode == DOWN){
			if(direction != Snake.UP)
				direction = Snake.DOWN;
		}
		else if(keyCode == LEFT){
			if(direction != Snake.RIGHT)
				direction = Snake.LEFT;
		}
		else if(keyCode == RIGHT){
			if(direction != Snake.LEFT)
				direction = Snake.RIGHT;
		}


	}

	/**
	 * Draws the board to the frame
	 */
	public void drawBoard(){
		//Loop through each Square in Board
		for(int i = 0; i<size;i++){
			for(int j = 0; j<size;j++){
				
				//Set black outline for each square
				stroke(0);
				fill(0,0,0);
				
				//Set fill color depending on square type
				if(board.getBoard()[i][j].getType() == Square.FOOD){
					fill(255,0,0);
				}
				if(board.getBoard()[i][j].getType() == Square.SNAKE){
					fill(0,255,0);
				}

				//Draw the square in the correct location
				int x = i*tileSize;
				int y = j*tileSize;
				rect(x,y,tileSize,tileSize);
			}
		}
	}

}
