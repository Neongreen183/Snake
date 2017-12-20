

public class Square {
	final static int BLANK = 0;
	final static int SNAKE  = 1;
	final static int FOOD = 2;
		
	public int type;
	
	int x = 0;
	int y = 0;
	
	public Square(int x, int y){
		type = 0;	
		this.x = x;
		this.y = y;
	}
	
	public void setType(int type){
		this.type = type;
	}
	
	public int getType(){
		return type;
	}

}
