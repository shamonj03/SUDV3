package com.joe.game;

import com.joe.game.control.entity.EntityFactory;
import com.joe.game.control.event.EventController;
import com.joe.game.io.OnDemandComponentDataFetcher;
import com.joe.game.io.ScriptManager;
import com.joe.game.model.Item;
import com.joe.game.model.ItemContainer;
import com.joe.game.model.Zone;
import com.joe.game.model.component.Position;
import com.joe.game.model.entity.Npc;
import com.joe.game.model.event.MessageEvent;
import com.joe.view.DefaultMessageEncoder;
import com.joe.view.MessageEncoder;

public class Game extends GameThread {
	/**
	 * This message encoder handles printing of game messages.
	 */
	private static MessageEncoder gameMessageEncoder = new DefaultMessageEncoder();

	/**
	 * This message encoder handles printing to the map.
	 */
	private static MessageEncoder mapMessageEncoder = new DefaultMessageEncoder();

	/**
	 * This message encoder handles printing of the menus.
	 */
	private static MessageEncoder menuMessageEncoder = new DefaultMessageEncoder();

	/**
	 * Initialize any pregame data.
	 */
	public void initialize() {
		ScriptManager.loadScripts();
	}

	/**
	 * Start the game.
	 */
	public void startGame() {
		initialize();

		startGameThread();
		
		Zone zone = new Zone(0);
		zone.initializeMap();
		zone.printZone();
	}

	/**
	 * Update the game every game tick.
	 */
	@Override public void onTick() {
		EventController.handleEvents();
	}

	/**
	 * Sets the message encoder handles printing of the game messages.
	 * 
	 * @param gameMessageEncoder
	 *            The encoder to use.
	 */
	protected static void setGameMessageEncoder(MessageEncoder gameMessageEncoder) {
		Game.gameMessageEncoder = gameMessageEncoder;
	}

	/**
	 * Sets the message encoder handles printing to the map.
	 * 
	 * @param mapMessageEncoder
	 *            The encoder to use.
	 */
	protected static void setMapMessageEncoder(MessageEncoder mapMessageEncoder) {
		Game.mapMessageEncoder = mapMessageEncoder;
	}

	/**
	 * Sets the message encoder handles printing of the menus.
	 * 
	 * @param menuMessageEncoder
	 *            The encoder to use.
	 */
	protected static void setMenuMessageEncoder(MessageEncoder menuMessageEncoder) {
		Game.menuMessageEncoder = menuMessageEncoder;
	}

	/**
	 * @retrn The message encoder handles printing of game messages.
	 */
	public static MessageEncoder getGameMessageEncoder() {
		return gameMessageEncoder;
	}

	/**
	 * @return The message encoder handles printing to the map.
	 */
	public static MessageEncoder getMapMessageEncoder() {
		return mapMessageEncoder;
	}

	/**
	 * @return The message encoder handles printing of the menus.
	 */
	public static MessageEncoder getMenuMessageEncoder() {
		return menuMessageEncoder;
	}

}
