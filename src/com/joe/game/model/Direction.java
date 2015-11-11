package com.joe.game.model;

/**
 * A collection of directions to make traversing a map more easy and readable.
 */
public enum Direction {
	/**
	 * Primary InterCardinal Directions.
	 */
	NORTH(0, -1),
	SOUTH(0, 1),
	EAST(1, 0),
	WEST(-1, 0),
	NORTH_EAST(1, 1),
	NORTH_WEST(-1, 1),
	SOUTH_EAST(1, -1),
	SOUTH_WEST(-1, -1),
	NONE(0, 0);

	/**
	 * The xOffset a direction will increment a current x component by.
	 */
	private final int xOffset;

	/**
	 * The yOffset a direction will increment a current y component by.
	 */
	private final int yOffset;

	/**
	 * Create a new direction.
	 * 
	 * @param xOffset
	 *            The xOffset a direction will increment a current x component
	 *            by.
	 * @param yOffset
	 *            The yOffset a direction will increment a current y component
	 *            by.
	 */
	private Direction(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	/**
	 * @return the yOffset a direction will increment a current y component
	 *         by.
	 */
	public int getXOffset() {
		return xOffset;
	}

	/**
	 * @return the yOffset a direction will increment a current y component by.
	 */
	public int getYOffset() {
		return yOffset;
	}
}
