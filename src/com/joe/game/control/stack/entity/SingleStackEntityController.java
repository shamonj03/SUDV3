package com.joe.game.control.stack.entity;

import com.joe.game.control.Controller;
import com.joe.game.control.stack.BoundedMap;
import com.joe.game.model.Entity;
import com.joe.game.model.component.Position;

public class SingleStackEntityController<E extends Entity> extends BoundedMap<E> implements Controller<E> {
	/**
	 * Creates a map with only one entity per cell.
	 * 
	 * @param width
	 *            Width of the map.
	 * @param height
	 *            Height of the map.
	 */
	public SingleStackEntityController(int width, int height) {
		super(width, height);
	}

	/**
	 * Register an entity to its position in the map.
	 */
	@Override public void register(E entity) {
		Position position = entity.getComponent(Position.class);
		set(position, entity);
	}

	/**
	 * Unregister an entity from its position in the map.
	 */
	@Override public void unregister(E entity) {
		Position position = entity.getComponent(Position.class);
		set(position, null);
	}

}
