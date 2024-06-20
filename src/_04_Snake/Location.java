package _04_Snake;

public class Location {
private int x;
private int y;

public Location(int x, int y) {
	super();
	this.x = x;
	this.y = y;
}

public boolean equals(Location other) {
	if(x==other.getX() && y==other.getY()) {
		return true;
	}
	return false;
}

public int getX() {

	return x;
}

public int getY() {

	return y;
}
}