package com.joe.game.io;

import com.joe.game.io.data.ZoneData;
import com.joe.game.io.definition.ItemDefinition;

public class DataManager {
	/**
	 * Fetches npc data when needed.
	 */
	private static final OnDemandComponentDataFetcher NPC_FETCHER = new OnDemandComponentDataFetcher("./data/npcs/");

	/**
	 * Fetches object data when needed.
	 */
	private static final OnDemandComponentDataFetcher OBJECT_FETCHER = new OnDemandComponentDataFetcher(
			"./data/objects/");

	/**
	 * Fetches zone data when needed.
	 */
	private static final OnDemandDataFetcher<ZoneData> ZONE_FETCHER = new OnDemandDataFetcher<>("./data/zones/",
			ZoneData.class);

	/**
	 * Cache the all the items storing them by index.
	 */
	private static final ItemDefinition ITEM_DEFINITION = new ItemDefinition();

	/**
	 * @return the onDemand fetcher for npc data.
	 */
	public static OnDemandComponentDataFetcher getNpcFetcher() {
		return NPC_FETCHER;
	}

	/**
	 * @return the onDemand fetcher for object data.
	 */
	public static OnDemandComponentDataFetcher getObjectFetcher() {
		return OBJECT_FETCHER;
	}

	/**
	 * @return the item definition containing all static item data.
	 */
	public static ItemDefinition getItemDefinition() {
		return ITEM_DEFINITION;
	}

	/**
	 * @return the zone definition containing all static zone data.
	 */
	public static OnDemandDataFetcher<ZoneData> getZoneFetcher() {
		return ZONE_FETCHER;
	}
}
