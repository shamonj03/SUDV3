package com.joe.game.model.event;

import com.joe.game.model.Item;

public class UnequipItemEvent extends Event {

	private final Item item;

	public UnequipItemEvent(Item item) {
		this.item = item;
	}
	
	public Item getItem() {
		return item;
	}
}
