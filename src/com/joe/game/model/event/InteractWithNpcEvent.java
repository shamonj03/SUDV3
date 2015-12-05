package com.joe.game.model.event;

import com.joe.game.model.Entity;
import com.joe.game.model.entity.Npc;

public class InteractWithNpcEvent extends InteractWithEntityEvent {
	/**
	 * Create a new interact with npc event.
	 * 
	 * @param zone
	 *            The zone the entity is in.
	 * @param source
	 *            The entity interacting with the target.
	 * @param entity
	 *            The npc being interacted with.
	 */
	public InteractWithNpcEvent(int zone, Entity source, Npc entity) {
		super(zone, source, entity);
	}

}
