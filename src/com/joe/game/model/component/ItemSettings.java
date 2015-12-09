package com.joe.game.model.component;

import com.joe.game.model.EquipmentSlot;

@DefinitionComponent public class ItemSettings extends Component {

	private final boolean stackable;

	private final EquipmentSlot equipmentSlot;
	
	private final String examine;

	public ItemSettings(boolean stackable, EquipmentSlot equipmentSlot, String examine) {
		this.stackable = stackable;
		this.equipmentSlot = equipmentSlot;
		this.examine = examine;
	}

	public ItemSettings() {
		this(false, EquipmentSlot.UNEQUIPABLE, "Nothing interesting happens.");
	}

	public EquipmentSlot getEquipmentSlot() {
		return equipmentSlot;
	}

	public boolean isStackable() {
		return stackable;
	}

	public String getExamine() {
		return examine;
	}
	
	@Override public String toString() {
		return "ItemSettings[Stackable: " + stackable + ", EquipmentSlot: " + equipmentSlot + ", Examine: " + examine + "]";
	}

}
