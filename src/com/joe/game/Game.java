package com.joe.game;

import com.joe.game.control.MenuManager;
import com.joe.game.control.event.EventDispatcher;
import com.joe.game.io.ScriptManager;
import com.joe.game.model.World;
import com.joe.view.message.DefaultMessageEncoder;
import com.joe.view.message.MessageEncoder;

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
	 * Handles events being processed by the game.
	 */
	private static EventDispatcher eventDispatcher = new EventDispatcher();

	/**
	 * Handles menu being displayed by game.
	 */
	private static MenuManager menuController = new MenuManager();

	/**
	 * The world the game is seeing.
	 */
	private static World world;
	/**
	 * Initialize any pregame data.
	 */
	public void initialize() {
		mapMessageEncoder.printLine();
		mapMessageEncoder.printLine();
		mapMessageEncoder.printLine("Loading game please wait...");
		ScriptManager.loadScripts();
		mapMessageEncoder.clear();
	}

	/**
	 * Start the game.
	 */
	public void startGame() {
		initialize();

		world = new World();
		world.initialize();

		Game.getWorld().draw();
		Game.getMenuController().draw();
		
		startGameThread();
	}

	/**
	 * Update the game every game tick.
	 */
	@Override public void onTick() {
		eventDispatcher.handleEvents();
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

	/**
	 * @return The handler for events in the game.
	 */
	public static EventDispatcher getEventDispatcher() {
		return eventDispatcher;
	}

	/**
	 * @return The controller for visible menus.
	 */
	public static MenuManager getMenuController() {
		return menuController;
	}

	/**
	 * @return The world visible by the game.
	 */
	public static World getWorld() {
		return world;
	}
}
