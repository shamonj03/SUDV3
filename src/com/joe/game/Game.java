package com.joe.game;

import com.joe.game.control.EntityFactory;
import com.joe.game.io.OnDemandFetcher;
import com.joe.game.model.component.Position;
import com.joe.game.model.entity.Npc;

public class Game {

	/**
	 * Fetches npc data when needed.
	 */
	private static final OnDemandFetcher npcFethcer = new OnDemandFetcher("./data/npcs/");

	/**
	 * Fetches object data when needed.
	 */
	private static final OnDemandFetcher objectFetcher = new OnDemandFetcher("./data/objects/");

	/**
	 * Initialize any pregame data.
	 */
	public static void initializeGame() {
		Npc npc = EntityFactory.createNpc(0, new Position(1, 1));
		Npc npc2 = EntityFactory.createNpc(1, new Position(3, 3));
		System.out.println(npc);
		System.out.println(npc2);
	}

	/**
	 * Start the main game loop.
	 */
	public static void startGame() {
		initializeGame();
	}

	/**
	 * @return the onDemand fetcher for npc data.
	 */
	public static OnDemandFetcher getNpcFetcher() {
		return npcFethcer;
	}

	/**
	 * @return the onDemand fetcher for object data.
	 */
	public static OnDemandFetcher getObjectFetcher() {
		return objectFetcher;
	}

}
