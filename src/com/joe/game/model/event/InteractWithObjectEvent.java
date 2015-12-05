package com.joe.game.model.event;

import com.joe.game.model.Entity;
import com.joe.game.model.entity.GameObject;

public class InteractWithObjectEvent extends InteractWithEntityEvent {
	/**
	 * Create a new interact with object event.
	 * 
	 * @param zone
	 *            The zone the entity is in.
	 * @param source
	 *            The entity interacting with the target.
	 * @param entity
	 *            The object being interacted with.
	 */
	public InteractWithObjectEvent(int zone, Entity source, GameObject entity) {
		super(zone, source, entity);
	}

}
