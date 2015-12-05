package com.joe.game.model.event;

import com.joe.game.model.component.Position;

public class CameraPositionEvent extends Event {
	/**
	 * The new position for the camera.
	 */
	private final Position position;

	/**
	 * Create a change the camera position event.
	 * 
	 * @param position
	 *            The new position for the camera.
	 */
	public CameraPositionEvent(Position position) {
		this.position = position;
	}

	/**
	 * @return the new position for the camera.
	 */
	public Position getPosition() {
		return position;
	}
}
