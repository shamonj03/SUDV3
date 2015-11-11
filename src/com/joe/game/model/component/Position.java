package com.joe.game.model.component;

import com.joe.game.model.Component;
import com.joe.game.model.Direction;

/**
 * A position with a standard (X, Y) coordinate system.
 * 
 */
public class Position extends Component {
	/**
	 * Standard origin of (0, 0)
	 */
	public static final Position ORIGIN = new Position(0, 0);
	
	/**
	 * The x component.
	 */
	private int x = 0;

	/**
	 * The y component.
	 */
	private int y = 0;

	/**
	 * Create a new position.
	 * 
	 * @param x
	 *            The x component.
	 * @param y
	 *            The y component.
	 */
	public Position(int x, int y) {
		set(x, y);
	}

	/**
	 * Create a new position from another position.
	 * 
	 * @param other
	 *            The position to copy.
	 */
	public Position(Position other) {
		set(other);
	}

	/**
	 * Default position at the standard origin (0, 0).
	 */
	public Position() {
		this(ORIGIN);
	}

	/**
	 * Set the position to another position.
	 * 
	 * @param other
	 *            The position to copy.
	 */
	public void set(Position other) {
		set(other.x, other.y);
	}

	/**
	 * Set the position.
	 * 
	 * @param x
	 *            The x component to change to.
	 * @param y
	 *            The y component to change to.
	 */
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Move the position in a direction.
	 * Ex: North goes north.
	 * 
	 * @param direction
	 *            The direction to move in.
	 */
	public void advance(Direction direction) {
		offset(direction.getXOffset(), direction.getYOffset());
	}

	/**
	 * Move the position away from a direction.
	 * Ex: North moves south.
	 * 
	 * @param direction
	 *            The direction to away from.
	 */
	public void retreat(Direction direction) {
		offset(direction.getXOffset() * -1, direction.getYOffset() * -1);
	}

	/**
	 * Offset a direction.
	 * 
	 * @param xOff
	 *            The x amount to offset the x component by.
	 * @param yOff
	 *            The y amount to offset the y component by.
	 */
	public void offset(int xOff, int yOff) {
		this.x += xOff;
		this.y += yOff;
	}

	/**
	 * @return The x component.
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return The y component.
	 */
	public int getY() {
		return y;
	}

	@Override public String toString() {
		return "Position[X: " + getX() + ", Y: " + getY() + "]";
	}

}
