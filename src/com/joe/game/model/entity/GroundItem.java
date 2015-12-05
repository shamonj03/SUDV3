package com.joe.game.model.entity;

import com.joe.game.model.DefinitionEntity;
import com.joe.game.model.EntityType;
import com.joe.game.model.Item;
import com.joe.game.model.component.Dimensions;
import com.joe.game.model.component.Position;
import com.joe.game.model.component.SimpleMapView;
import com.joe.game.model.component.WorldSettings;

public class GroundItem extends DefinitionEntity {
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
		super(item.getId());
		this.item = item;
		this.register(position);
		this.register(new SimpleMapView('I'));
		this.register(new Dimensions(1, 1));
		this.register(new WorldSettings(false, true, true));
	}

	/**
	 * Create a new ground item at a position.
	 * 
	 * @param id
	 *            The id of the item to spawn.
	 * @param amount
	 *            The amount of the item.
	 * @param position
	 *            The position the item is.
	 */
	public GroundItem(int id, int amount, Position position) {
		this(new Item(id, amount), position);
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
