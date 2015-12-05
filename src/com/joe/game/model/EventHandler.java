package com.joe.game.model;

import com.joe.game.model.event.Event;

public abstract class EventHandler<T extends Event> {
	/**
	 * Handle an event.
	 * 
	 * @param event
	 *            The event data.
	 */
	public abstract void handle(T event);

}
