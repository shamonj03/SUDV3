package com.joe.game.model.event;

import com.joe.game.model.Item;

public class EquipItemEvent extends Event {

	private final Item item;

	public EquipItemEvent(Item item) {
		this.item = item;
	}
	
	public Item getItem() {
		return item;
	}
}
