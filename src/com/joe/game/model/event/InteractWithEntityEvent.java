package com.joe.game.model.event;

import com.joe.game.model.Entity;

public class InteractWithEntityEvent<T extends Entity> extends Event {

	private final T entity;

	private final int zone;

	public InteractWithEntityEvent(int zone, T entity) {
		this.zone = zone;
		this.entity = entity;
	}

	public int getZone() {
		return zone;
	}

	public Entity getEntity() {
		return entity;
	}
}
