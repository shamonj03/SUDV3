package com.joe.game.model.component;

import com.joe.game.model.Component;

/**
 * A dimension class for defining how much 2D space something uses.
 */
@DefinitionModuel public class Dimensions extends Component {

	/**
	 * Width of the object.
	 */
	private int width = 1;

	/**
	 * Height of the object.
	 */
	private int height = 1;

	/**
	 * Creates a new dimension component with a width and a height.
	 * 
	 * @param width
	 *            Width of the object.
	 * @param height
	 *            Height of the object.
	 */
	public Dimensions(int width, int height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * Default dimensions of 1x1.
	 */
	public Dimensions() {
		this(1, 1);
	}

	/**
	 * Set both the width and height.
	 * 
	 * @param width
	 *            New width of the object.
	 * @param height
	 *            New height of the object.
	 */
	public void setDimensions(int width, int height) {
		setWidth(width);
		setHeight(height);
	}

	/**
	 * Set the height of the object.
	 * 
	 * @param height
	 *            New height of the object.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Set the width of the object.
	 * 
	 * @param width
	 *            New width of the object.
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height of the object.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return the width of the object.
	 */
	public int getWidth() {
		return width;
	}

	@Override public String toString() {
		return "Dimensions[Width: " + width + ", Height: " + height + "]";
	}
}
