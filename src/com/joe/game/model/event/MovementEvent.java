package com.joe.game.model.event;

import com.joe.game.model.Direction;
import com.joe.game.model.Entity;

public class MovementEvent extends Event {
	/**
	 * The entity to move.
	 */
	private final Entity entity;

	/**
	 * The direction to move the entity in.
	 */
	private final Direction direction;

	/**
	 * Create a new movement event.
	 * 
	 * @param entity
	 *            The entity to move.
	 * @param direction
	 *            The direction to move the entity in.
	 */
	public MovementEvent(Entity entity, Direction direction) {
		this.entity = entity;
		this.direction = direction;
	}

	/**
	 * @return the entity to move.
	 */
	public Entity getEntity() {
		return entity;
	}

	/**
	 * @return the direction to move the entity in.
	 */
	public Direction getDirection() {
		return direction;
	}
}
