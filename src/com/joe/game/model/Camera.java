package com.joe.game.model;

import com.joe.game.model.component.Position;

public class Camera {

	/**
	 * Position of the camera.
	 */
	private Position location = new Position(0, 0);

	/**
	 * View width of the camera.
	 */
	private int width;

	/**
	 * View height of the camera.
	 */
	private int height;

	/**
	 * Creates a new camera. The camera is used to display
	 * the map that is within visible range of the camera bounds.
	 * 
	 * @param width
	 *            View width of the camera.
	 * @param height
	 *            View height of the camera.
	 * @param location
	 *            Position of the camera is focused on.
	 */
	public Camera(int width, int height, Position location) {
		this.width = width;
		this.height = height;
		this.location.set(location);
	}

	/**
	 * @return the view height.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return the view width.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the focused location.
	 */
	public Position getLocation() {
		return location;
	}

}
