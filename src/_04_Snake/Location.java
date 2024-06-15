package _04_Snake;

public class Location {
private int x;
private int y;

public Location(int x, int y) {
	super();
	this.x = x;
	this.y = y;
}

public boolean equals(int locationx,int locationy) {
	if(x==locationx && y==locationy) {
		return true;
	}
	return false;
}
}