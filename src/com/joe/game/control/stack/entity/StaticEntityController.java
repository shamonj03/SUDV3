package com.joe.game.control.stack.entity;

import com.joe.game.control.stack.BoundedMap;
import com.joe.game.control.stack.Controller;
import com.joe.game.model.Entity;
import com.joe.game.model.component.Position;

public class StaticEntityController<E extends Entity> extends BoundedMap<E> implements Controller<E> {

	public StaticEntityController(int mapWidth, int mapHeight) {
		super(mapWidth, mapHeight);
	}

	@Override public void register(E entity) {
		Position position = entity.getComponent(Position.class);
		set(position.getX(), position.getY(), entity);
	}

	@Override public void unregister(E entity) {
		Position position = entity.getComponent(Position.class);
		set(position.getX(), position.getY(), null);
	}

	public boolean inBounds(E entity) {
		Position position = entity.getComponent(Position.class);
		return inBounds(position.getX(), position.getY());
	}

	public E get(E entity) {
		Position position = entity.getComponent(Position.class);
		return get(position.getX(), position.getY());
	}

}
