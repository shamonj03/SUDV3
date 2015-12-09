package com.joe.game.io.data.zone;

import com.joe.game.model.component.Position;

public class ZoneNpc {

	private final Position position;
	
	private final int id;

	public ZoneNpc(int id, Position position) {
		this.id = id;
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}
	
	public int getID() {
		return id;
	}
}
