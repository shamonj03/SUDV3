package com.joe.game.io.data.zone;

import com.joe.game.model.Item;
import com.joe.game.model.component.Position;

public class ZoneItem {

	private final Position position;

	private final Item item;

	public ZoneItem(Item item, Position position) {
		this.item = item;
		this.position = position;
	}

	public Item getItem() {
		return item;
	}
	
	public Position getPosition() {
		return position;
	}

}
