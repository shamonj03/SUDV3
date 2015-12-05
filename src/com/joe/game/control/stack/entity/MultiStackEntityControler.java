package com.joe.game.control.stack.entity;

import com.joe.game.control.Controller;
import com.joe.game.control.stack.BoundedMap;
import com.joe.game.control.stack.StackController;
import com.joe.game.model.Entity;
import com.joe.game.model.component.Position;

public class MultiStackEntityControler<E extends Entity> extends BoundedMap<StackController<E>> implements Controller<E> {
	/**
	 * Create a map of lists that contains entities.
	 * 
	 * @param width
	 *            Width of the map.
	 * @param height
	 *            Height of the map.
	 */
	public MultiStackEntityControler(int width, int height) {
		super(width, height);

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				set(x, y, new StackController<>());
			}
		}
	}

	/**
	 * Register an entity to its position in the map.
	 */
	@Override public void register(E entity) {
		Position position = entity.getComponent(Position.class);
		StackController<E> stack = get(position);

		stack.register(entity);
		set(position, stack);
	}

	/**
	 * Unregister an entity from its position in the map.
	 */
	@Override public void unregister(E entity) {
		Position position = entity.getComponent(Position.class);
		StackController<E> stack = get(position);

		stack.unregister(entity);
		set(position, stack);
	}
}
