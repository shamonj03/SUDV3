package com.joe.game.model.event;

import com.joe.game.model.component.Position;

public class CameraPositionEvent extends Event {

	private final Position position;

	public CameraPositionEvent(Position position) {
		this.position = position;
	}
	
	public Position getPosition() {
		return position;
	}
}
