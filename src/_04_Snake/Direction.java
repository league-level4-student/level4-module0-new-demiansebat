package _04_Snake;

public enum Direction {
UP(0,-1),DOWN(0,1),LEFT(-1,0),RIGHT(1,0);
	int x;
	int y;
	private Direction(int x, int y) {
		this.x = x;
		this.y = y;
	}

 

}
