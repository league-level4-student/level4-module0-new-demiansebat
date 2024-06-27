package _04_Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class Snake {
	public static final Color SNAKE_COLOR = Color.BLUE;
	public static final int BODY_SIZE = 50;

	private SnakeSegment head;
	private ArrayList<SnakeSegment> snake;

	private Direction currentDirection;

	private boolean canMove = true;

	public Snake(Location location) {
		snake = new ArrayList<SnakeSegment>();
		head = new SnakeSegment(location, BODY_SIZE);
		snake.add(getHead());
		currentDirection = Direction.RIGHT;
	}

	public void feed() {
		snake.add(new SnakeSegment(snake.get(0).getLocation(), BODY_SIZE));
	}

	public Location getHeadLocation() {
		return getHead().getLocation();
	}

	public void update() {
		int nextX;
		int nextY;
		nextX = getHead().getLocation().getX();
		nextY = getHead().getLocation().getY();
		/*
		 * Create variables for the next X and Y location of the snake's head.
		 * Initialize them to the current X and Y locations.
		 */

		/*
		 * Use a switch statement to check on the currentDirection of the snake and
		 * calculate the head's next x and y position. Depending on the direction, the
		 * variables you created may increase or decrease by 1.
		 */
		nextX += currentDirection.x;
		nextY += currentDirection.y;
//		switch (currentDirection) {
//		case RIGHT:
//			nextX += 1;
//			break;
//
//		case LEFT:
//			nextX -= 1;
//			break;
//
//		case UP:
//			nextY += 1;
//			break;
//
//		case DOWN:
//			nextY -= 1;
//			break;
//
//		}
		/*
		 * Change the Location of each SnakeSegment in your snake ArrayList to the
		 * Location of the segment in front of it.
		 * 
		 * Use a loop starting at the end of the ArrayList and stop before the head of
		 * the snake (index 0) or you will go out of bounds.
		 */
		for (int i = snake.size() - 1; i > 0; i--) {
			snake.get(i).setLocation(snake.get(i - 1).getLocation());
		}
		/*
		 * Create a new Location object and initialize it with the values calculated in
		 * the first step. Then set the head's location equal to the new location.
		 */

		Location newThing = new Location(nextX, nextY);

		getHead().setLocation(newThing);
		// Set the canMove member variable to true.
		canMove = true;

	}

	public void setDirection(Direction direction) {
		
		Location tempLoc = new Location(head.getLocation().getX() + direction.x, head.getLocation().getY()+direction.y);
		SnakeSegment tempSeg = new SnakeSegment(tempLoc, BODY_SIZE);
		
		if (canMove && isNotOppositeDirection(direction) && !isHeadCollidingWithBody(tempSeg)) {
			currentDirection = direction;
		}
		/*
		 * If the passed in direction is not the opposite direction of currentDirection
		 * and canMove is true, set currentDirection to the passed in direction and
		 * canMove to false
		 * 
		 * Hint: Use the isNotOppositeDirection method.
		 */

	}

	private boolean isNotOppositeDirection(Direction direction) {
		if (direction == Direction.LEFT && currentDirection != Direction.RIGHT) {
			return true;
		}
		if (direction == Direction.RIGHT && currentDirection != Direction.LEFT) {
			return true;
		}
		if (direction == Direction.UP && currentDirection != Direction.DOWN) {
			return true;
		}
		if (direction == Direction.DOWN && currentDirection != Direction.UP) {
			return true;
		} else {
			return false;
		}
		/*
		 * Complete the method so it returns true if the passed in direction is not the
		 * opposite direction of currentDirection.
		 * 
		 * For example, if currentDirection is UP and the passed in direction is DOWN
		 * this method should return false.
		 */
	}

	public void resetLocation() {
		snake.clear();
		// Clear the snake.

		/*
		 * Create a new Location object for the head at SnakeGame.WIDTH / 2,
		 * SnakeGame.HEIGHT / 2.
		 */
		Location headLoc = new Location(SnakeGame.WIDTH / 2, SnakeGame.HEIGHT / 2);
		/*
		 * Set the head member variable equal to a new SnakeSegment object. Use the
		 * Location created in step 2 for the Location and the BODY_SIZE constant for
		 * the size.
		 */
		head = new SnakeSegment(headLoc, BODY_SIZE);
		// Add the head to the snake.
		snake.add(getHead());
	}

	public boolean isOutOfBounds() {
		if (getHead().getLocation().getX() > SnakeGame.WIDTH || getHead().getLocation().getY() < 0
				|| getHead().getLocation().getX() < 0 || getHead().getLocation().getY() > SnakeGame.HEIGHT) {
			return true;
		}
		/*
		 * Complete the method so it returns true if the head of the snake is outside of
		 * the window and false otherwise.
		 */

		return false;
	}

	public boolean isHeadCollidingWithBody(SnakeSegment seg) {
		for (int i = 1; i < snake.size(); i++) {
			if (seg.getLocation().equals(snake.get(i).getLocation())) {
				return true;
			}
		}
		/*
		 * Complete the method so it returns true if the head is located in the same
		 * location as any other body segment.
		 */

		return false;
	}

	public boolean isLocationOnSnake(Location loc) {
		for (int i = 0; i < snake.size(); i++) {
			if (loc.getX() == snake.get(i).getLocation().getX() && loc.getY() == snake.get(i).getLocation().getY()) {
				return true;
			}
		}
		/*
		 * Complete the method so it returns true if the passed in location is located
		 * on the snake.
		 */

		return false;
	}

	public void draw(Graphics g) {
		for (SnakeSegment s : snake) {
			s.draw(g);
		}
	}

	public SnakeSegment getHead() {
		return head;
	}
}
