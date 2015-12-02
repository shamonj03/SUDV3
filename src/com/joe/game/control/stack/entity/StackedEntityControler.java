package com.joe.game.control.stack.entity;

import com.joe.game.control.stack.BoundedMap;
import com.joe.game.control.stack.Controller;
import com.joe.game.control.stack.Stack;
import com.joe.game.model.Entity;
import com.joe.game.model.component.Position;

public class StackedEntityControler<E extends Entity> extends BoundedMap<Stack<E>> implements Controller<E> {

	public StackedEntityControler(int width, int height) {
		super(width, height);

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				set(x, y, new Stack<>());
			}
		}
	}

	@Override public void register(E entity) {
		Position position = entity.getComponent(Position.class);
		Stack<E> stack = get(position.getX(), position.getY());

		stack.register(entity);
		set(position.getX(), position.getY(), stack);
	}

	@Override public void unregister(E entity) {
		Position position = entity.getComponent(Position.class);
		Stack<E> stack = get(position.getX(), position.getY());

		stack.unregister(entity);
		set(position.getX(), position.getY(), stack);
	}
}
