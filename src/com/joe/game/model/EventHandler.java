package com.joe.game.model;


public abstract class EventHandler<T extends Event> {

	/**
	 * Handle an event.
	 * 
	 * @param event
	 * 		The event data.
	 */
	public abstract void handle(T event);
	
}
