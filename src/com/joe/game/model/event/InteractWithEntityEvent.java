package com.joe.game.model.event;

import com.joe.game.model.Entity;

public class InteractWithEntityEvent extends Event {
	/**
	 * The zone the entity is in.
	 */
	private final int zone;

	/**
	 * The option chosen on interact.
	 */
	private final int option;

	/**
	 * The entity interacting with the target.
	 */
	private final Entity source;

	/**
	 * The entity being interacted with.
	 */
	private final Entity target;

	/**
	 * Create a new interact with entity event.
	 * 
	 * @param zone
	 *            The zone the entity is in.
	 * @param option
	 *            The option chosen on interact.
	 * @param source
	 *            The entity interacting with the target.
	 * @param target
	 *            The entity being interacted with.
	 */
	public InteractWithEntityEvent(int zone, int option, Entity source, Entity target) {
		this.zone = zone;
		this.option = option;
		this.source = source;
		this.target = target;
	}

	/**
	 * @return the zone the entity is in.
	 */
	public int getZone() {
		return zone;
	}
	
	/**
	 * @return the option chosen on interact.
	 */
	public int getOption() {
		return option;
	}

	/**
	 * @return the entity interacting with the target.
	 */
	public Entity getSource() {
		return source;
	}

	/**
	 * @return the entity being interacted with.
	 */
	public Entity getTarget() {
		return target;
	}
}
