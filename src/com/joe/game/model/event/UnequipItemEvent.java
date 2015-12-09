package com.joe.game.model.event;

import com.joe.game.model.Item;

public class UnequipItemEvent extends Event {
	/**
	 * The slot to unequip.
	 */
	private final int slot;

	/**
	 * Create a new unequip event.
	 * 
	 * @param slot
	 *            The slot to unequip.
	 */
	public UnequipItemEvent(int slot) {
		this.slot = slot;
	}

	/**
	 * @return the slot to unequip.
	 */
	public int getSlot() {
		return slot;
	}
}
