package com.joe.game.model;

import com.google.gson.annotations.SerializedName;

public enum EquipmentSlot {

    @SerializedName("UNEQUIPABLE")
	UNEQUIPABLE(0),
    @SerializedName("HELMET")
	HELMET(1),
    @SerializedName("BODY")
	BODY(2),
    @SerializedName("WEAPON")
	WEAPON(3),
    @SerializedName("AMMO")
	AMMO(4);

	private final int slot;
	
	private EquipmentSlot(int slot) {
		this.slot = slot;
	}
	
	public int getSlot() {
		return slot;
	}
}
