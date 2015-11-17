package com.joe.game.model.entity;

import com.joe.game.model.Entity;
import com.joe.game.model.EntityType;
import com.joe.game.model.component.MapView;
import com.joe.game.model.component.Name;
import com.joe.game.model.component.Position;

/**
 * A unique player entity from all the other entities.
 * This player is the person playing in the game.
 */
public class Player extends Entity {
	/**
	 * Create a new player.
	 * Default name is player.
	 * Default location is 1, 2.
	 */
	public Player() {
		register(new Name("player"));
		register(new Position(1, 2));
		register(new MapView(new char[][] {
				{ '@' }
		}));
	}

	@Override public EntityType getType() {
		return EntityType.PLAYER;
	}
}
