package com.joe.game.io.data;

import com.joe.game.model.EquipmentSlot;

public class ItemData extends Data {
	/**
	 * The name of the item.
	 */
	private String name = "Default Item";

	/**
	 * The stackability of the item.
	 */
	private boolean stackable = false;

	/**
	 * The slot the item goes in.
	 */
	private EquipmentSlot equipmentSlot = EquipmentSlot.UNEQUIPABLE;

	/**
	 * Create a new set of item data for the ID.
	 * 
	 * @param id
	 *            The id of the item.
	 */
	public ItemData(int id) {
		super(id);
	}

	/**
	 * @return the slot the item goes in.
	 */
	public EquipmentSlot getEquipmentSlot() {
		return equipmentSlot;
	}

	/**
	 * @return the name of the item.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the stackability of the item.
	 */
	public boolean isStackable() {
		return stackable;
	}

	@Override public String toString() {
		return "Name: " + name + ", Stackable: " + stackable + ", EquipmentSlot: " + equipmentSlot;
	}
}
