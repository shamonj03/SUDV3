package com.joe.game.io.data;

import com.joe.game.model.EquipmentSlot;

public class ItemData extends Data {

	private String name = "Default Item";

	private boolean stackable = false;

	private EquipmentSlot equipmentSlot = EquipmentSlot.UNEQUIPABLE;

	public ItemData(int id) {
		super(id);
	}

	public EquipmentSlot getEquipmentSlot() {
		return equipmentSlot;
	}

	public String getName() {
		return name;
	}

	public boolean isStackable() {
		return stackable;
	}

	@Override public String toString() {
		return "Name: " + name + ", Stackable: " + stackable + ", EquipmentSlot: " + equipmentSlot;
	}
}
