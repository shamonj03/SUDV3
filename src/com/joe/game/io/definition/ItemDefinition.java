package com.joe.game.io.definition;

import com.joe.game.io.CachedDefinition;
import com.joe.game.io.data.ItemData;

public class ItemDefinition extends CachedDefinition<ItemData> {
	/**
	 * Load items from items.json and caches them.
	 */
	public ItemDefinition() {
		super("./data/items.json", ItemData.class);
	}

}
