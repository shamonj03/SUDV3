package com.joe.game.io.definition;

import com.joe.game.io.CachedDefinition;
import com.joe.game.io.data.ItemData;

public class ItemDefinition extends CachedDefinition<ItemData> {

	public ItemDefinition() {
		super("./data/items.json", ItemData.class);
	}

}
