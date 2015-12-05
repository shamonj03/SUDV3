package com.joe.game.model.event;

import com.joe.game.model.Item;

public class EquipItemEvent extends Event {
	/**
	 * The item to equip.
	 */
	private final Item item;

	/**
	 * Create an equip item event.
	 * 
	 * @param item
	 *            The item to equip.
	 */
	public EquipItemEvent(Item item) {
		this.item = item;
	}

	/** 
	 * @return the item to equip.
	 */
	public Item getItem() {
		return item;
	}
}
