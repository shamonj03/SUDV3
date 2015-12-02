package com.joe.game.model.event;

import com.joe.game.model.Direction;
import com.joe.game.model.Entity;

public class MovementEvent extends Event {

	private final Entity entity;

	private final Direction direction;

	public MovementEvent(Entity entity, Direction direction) {
		this.entity = entity;
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}

	public Entity getEntity() {
		return entity;
	}
}
