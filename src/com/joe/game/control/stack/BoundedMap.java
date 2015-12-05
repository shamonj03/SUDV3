package com.joe.game.control.stack;

import com.joe.game.model.component.Position;

public abstract class BoundedMap<E> {
	/**
	 * The width or number of columns of the map.
	 */
	private int width;

	/**
	 * The height or number of rows of the map.
	 */
	private int height;

	/**
	 * The 2D array of data.
	 */
	private E[][] map;

	/**
	 * Create a new map bounded to the width and height.
	 * 
	 * @param width
	 *            The width or number of columns of the map.
	 * @param height
	 *            The height or number of rows of the map.
	 */
	public BoundedMap(int width, int height) {
		setBounds(width, height);
	}

	/**
	 * Create an empty map to be initialized later.
	 */
	public BoundedMap() {
		setBounds(0, 0);
	}

	/**
	 * Set the bounds of the map.
	 * 
	 * @param width
	 *            The width or number of columns of the map.
	 * @param height
	 *            The height or number of rows of the map.
	 */
	public void setBounds(int width, int height) {
		this.width = width;
		this.height = height;
		this.clear();
	}

	/**
	 * Clear all data from the map.
	 */
	@SuppressWarnings("unchecked") public void clear() {
		this.map = (E[][]) new Object[height][width];
	}

	/**
	 * Set a tile in the map.
	 * 
	 * @param x
	 *            The x position.
	 * @param y
	 *            The y position.
	 * @param e
	 *            The object to set to.
	 */
	public void set(int x, int y, E e) {
		if (!inBounds(x, y)) {
			throw new IndexOutOfBoundsException();
		}
		map[y][x] = e;
	}

	/**
	 * Check if a position lies within the boundaries.
	 * 
	 * @param x
	 *            X position to check.
	 * @param y
	 *            Y position to check.
	 * @return true of the position is within the boundaries.
	 */
	public boolean inBounds(int x, int y) {
		return (y >= 0 && y < map.length) && (x >= 0 && x < map[y].length);
	}

	/**
	 * Get an object E at a position.
	 * 
	 * @param x
	 *            X position to check.
	 * @param y
	 *            Y position to check.
	 * @return object E.
	 */
	public E get(int x, int y) {
		if (!inBounds(x, y)) {
			throw new IndexOutOfBoundsException();
		}
		return map[y][x];
	}

	/**
	 * Set a tile in the map.
	 * 
	 * @param position
	 *            The position within the map.
	 * @param e
	 *            The object to set to.
	 */
	public void set(Position position, E e) {
		set(position.getX(), position.getY(), e);
	}

	/**
	 * Check if a position lies within the boundaries.
	 * 
	 * @param position
	 *            The position within the map.
	 * @return true of the position is within the boundaries.
	 */
	public boolean inBounds(Position position) {
		return inBounds(position.getX(), position.getY());
	}

	/**
	 * Get an object E at a position.
	 * 
	 * @param position
	 *            The position within the map.
	 * @return object E.
	 */
	public E get(Position position) {
		return get(position.getX(), position.getY());
	}

	/**
	 * @return The width or number of columns of the map.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return The height or number of rows of the map.
	 */
	public int getHeight() {
		return height;
	}
}
