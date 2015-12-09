package com.joe.game.model.event;

import com.joe.game.model.Entity;
import com.joe.game.model.entity.GameObject;

public class InteractWithObjectEvent extends InteractWithEntityEvent {
	/**
	 * Create a new interact with object event.
	 * 
	 * @param zone
	 *            The zone the entity is in.
	 * @param option
	 *            The option chosen on interact.
	 * @param source
	 *            The entity interacting with the target.
	 * @param entity
	 *            The object being interacted with.
	 */
	public InteractWithObjectEvent(int zone, int option, Entity source, GameObject entity) {
		super(zone, option, source, entity);
	}

}
