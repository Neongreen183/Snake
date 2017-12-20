import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;






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

    public void settings(){
    	size(600,600);
    	
    	

    }

    public void setup(){
		frameRate(15);

		PFont font = createFont("tickerFont.ttf",32);
		textFont(font);
		
		board = new Board(size);
		board.placeFood();
		snake = new Snake(board,15);

    }

    public void draw(){
		drawBoard();
		if(openScreen == true){
			fill(0,0,255);
			textSize(32);

			text("Press any key to start.", 30, 50); 
		}
		else if(snake.alive == true){
			snake.move(direction);
			fill(0,0,255);
			textSize(15);
			text("Score: " + snake.getScore(), (size*tileSize) - 75, 30); 
		}
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
    

	public void keyPressed(){
		openScreen = false;
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

	public void drawBoard(){
		for(int i = 0; i<size;i++){
			for(int j = 0; j<size;j++){
				stroke(0);
				fill(0,0,0);
				if(board.getBoard()[i][j].getType() == Square.FOOD){
					fill(255,0,0);
				}
				if(board.getBoard()[i][j].getType() == Square.SNAKE){
					fill(0,255,0);
				}

				int x = i*tileSize;
				int y = j*tileSize;
				rect(x,y,tileSize,tileSize);
			}
		}
	}

}
