package com.joe.game.control;

import com.joe.game.io.OnDemandDataFetcher;
import com.joe.game.io.CachedDefinition;
import com.joe.game.io.data.ItemData;
import com.joe.game.io.definition.ItemDefinition;
import com.joe.game.model.Item;

public class DataManager {

	/**
	 * Fetches npc data when needed.
	 */
	private static final OnDemandDataFetcher NPC_FETCHER = new OnDemandDataFetcher("./data/npcs/");

	/**
	 * Fetches object data when needed.
	 */
	private static final OnDemandDataFetcher OBJECT_FETCHER = new OnDemandDataFetcher("./data/objects/");

	/**
	 * Cache the all the items storing them by index.
	 */
	private static final ItemDefinition ITEM_DEFINITION = new ItemDefinition();

	/**
	 * @return the onDemand fetcher for npc data.
	 */
	public static OnDemandDataFetcher getNpcFetcher() {
		return NPC_FETCHER;
	}

	/**
	 * @return the onDemand fetcher for object data.
	 */
	public static OnDemandDataFetcher getObjectFetcher() {
		return OBJECT_FETCHER;
	}

	/**
	 * @return the item definition containing all static item data.
	 */
	public static ItemDefinition getItemDefinition() {
		return ITEM_DEFINITION;
	}
}
