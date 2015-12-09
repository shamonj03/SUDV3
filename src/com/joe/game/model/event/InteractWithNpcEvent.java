package com.joe.game.model.event;

import com.joe.game.model.Entity;
import com.joe.game.model.entity.Npc;

public class InteractWithNpcEvent extends InteractWithEntityEvent {
	/**
	 * Create a new interact with npc event.
	 * 
	 * @param zone
	 *            The zone the entity is in.
	 * @param option
	 *            The option chosen on interact.
	 * @param source
	 *            The entity interacting with the target.
	 * @param entity
	 *            The npc being interacted with.
	 */
	public InteractWithNpcEvent(int zone, int option, Entity source, Npc entity) {
		super(zone, option, source, entity);
	}

}
