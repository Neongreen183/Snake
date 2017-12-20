
/**
 * 
 * @author Rene Borr
 * Square Class for Snake
 * 
 * Square is in charge of knowing its current location and type
 */
public class Square {
	
	// Create three different square types
	final static int BLANK = 0;
	final static int SNAKE  = 1;
	final static int FOOD = 2;
	
	
	public int type;
	
	int x = 0;
	int y = 0;
	
	/**
	 * Constructor method for Square
	 * @param x - The x location of the Square
	 * @param y - The y location of the Square
	 */
	public Square(int x, int y){
		type = 0;	
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Setter method for Square type
	 * @param type
	 */
	public void setType(int type){
		this.type = type;
	}
	
	/**
	 * Getter method for Square Type
	 * @return int - integer representation of the squares type
	 */
	public int getType(){
		return type;
	}

}
