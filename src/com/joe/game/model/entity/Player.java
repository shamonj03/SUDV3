package com.joe.game.model.entity;

import com.joe.game.model.Entity;
import com.joe.game.model.EntityType;
import com.joe.game.model.ItemContainer;
import com.joe.game.model.component.Name;
import com.joe.game.model.component.Position;
import com.joe.game.model.component.SimpleMapView;

/**
 * A unique player entity from all the other entities.
 * This player is the person playing in the game.
 */
public class Player extends Entity {
	/**
	 * The players inventory.
	 */
	private ItemContainer inventory = new ItemContainer(28);

	/**
	 * The players equipped items.
	 */
	private ItemContainer equipment = new ItemContainer(4);

	/**
	 * Create a new player.
	 * Default name is player.
	 * Default location is 1, 2.
	 */
	public Player() {
		register(new Name("player"));
		register(new Position(2, 2));
		register(new SimpleMapView('@'));
	}

	@Override public EntityType getType() {
		return EntityType.PLAYER;
	}

	/**
	 * @return the player inventory.
	 */
	public ItemContainer getEquipment() {
		return equipment;
	}

	/**
	 * @return the players inventory.
	 */
	public ItemContainer getInventory() {
		return inventory;
	}
}
