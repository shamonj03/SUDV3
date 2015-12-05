package com.joe.game.model;

import com.google.gson.annotations.SerializedName;

public enum EquipmentSlot {

	@SerializedName("UNEQUIPABLE") UNEQUIPABLE(-1),
	@SerializedName("HELMET") HELMET(0),
	@SerializedName("BODY") BODY(1),
	@SerializedName("WEAPON") WEAPON(2),
	@SerializedName("AMMO") AMMO(3);

	/**
	 * The slot the item goes in.
	 */
	private final int slot;

	/**
	 * Create a new Equipment Slot.
	 * 
	 * @param slot
	 *            The slot the item goes in.
	 */
	private EquipmentSlot(int slot) {
		this.slot = slot;
	}

	/**
	 * @return the slot the item goes in.
	 */
	public int getSlot() {
		return slot;
	}
}
