package com.joe.game.model.event;

import com.joe.game.model.Entity;
import com.joe.game.model.entity.GroundItem;

public class InteractWithGroundItemEvent extends InteractWithEntityEvent {
	/**
	 * Create a new interact with ground item event.
	 * 
	 * @param zone
	 *            The zone the entity is in.
	 * @param option
	 *            The option chosen on interact.
	 * @param source
	 *            The entity interacting with the target.
	 * @param entity
	 *            The ground item being interacted with.
	 */
	public InteractWithGroundItemEvent(int zone, int option, Entity source, GroundItem entity) {
		super(zone, option, source, entity);
	}

}
