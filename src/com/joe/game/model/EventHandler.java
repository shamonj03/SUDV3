package com.joe.game.model;


public abstract class EventHandler<T extends Event> {

	public abstract void handle(T event);
	
}
