package com.joe.game.model.entity;

import com.joe.game.model.Entity;
import com.joe.game.model.EntityType;
import com.joe.game.model.Item;
import com.joe.game.model.component.MapView;
import com.joe.game.model.component.Position;

public class GroundItem extends Entity {
	/**
	 * The item registered to this ground item.
	 */
	private Item item;

	/**
	 * Create a new ground item at a position.
	 * 
	 * @param item
	 *            The item registered to this ground item.
	 * @param position
	 *            The position the item is.
	 */
	public GroundItem(Item item, Position position) {
		this.item = item;
		this.register(position);
		this.register(new MapView(new char[][] {
				{ 'I' }
		}));
	}

	/**
	 * @return the item registered to this ground item.
	 */
	public Item getItem() {
		return item;
	}

	@Override public EntityType getType() {
		return EntityType.GROUND_ITEM;
	}
}
