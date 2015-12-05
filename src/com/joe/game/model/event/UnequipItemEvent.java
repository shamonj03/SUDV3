package com.joe.game.model.event;

import com.joe.game.model.Item;

public class UnequipItemEvent extends Event {
	/**
	 * The item to unequip.
	 */
	private final Item item;

	/**
	 * Create a new unequip event.
	 * 
	 * @param item
	 *            The item to unequip.
	 */
	public UnequipItemEvent(Item item) {
		this.item = item;
	}

	/**
	 * @return the item to unequip.
	 */
	public Item getItem() {
		return item;
	}
}
