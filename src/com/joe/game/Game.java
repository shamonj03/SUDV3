package com.joe.game;

import com.joe.game.control.EntityFactory;
import com.joe.game.control.EventController;
import com.joe.game.io.OnDemandDataFetcher;
import com.joe.game.model.Item;
import com.joe.game.model.ItemContainer;
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
		Npc npc = EntityFactory.createNpc(0, new Position(1, 1));
		Npc npc2 = EntityFactory.createNpc(1, new Position(3, 3));
		gameMessageEncoder.printLine(npc);
		gameMessageEncoder.printLine(npc2);

		EventController.sendEvent(new MessageEvent("Testing 123 lol hi"));
		
		ItemContainer inventory = new ItemContainer(28);

		System.out.println(inventory.addItem(1, 1));
		System.out.println(inventory.remove(1, 50));
		System.out.println(inventory.addItem(1, 200));
		System.out.println(inventory.remove(1, 50));
		
		System.out.println(inventory.addItem(0, 2));
		System.out.println(inventory.remove(0, 2));
		System.out.println(inventory.addItem(0, 5));
		System.out.println(inventory.remove(0, 3));

		for(int i = 0; i < inventory.getSize(); i++) {
			Item item = inventory.getItem(i);
			System.out.println(i + " " + item.getData().getName() + " " + item.getAmount());
		}
	}

	/**
	 * Start the game.
	 */
	public void startGame() {
		initialize();

		startGameThread();
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
	public static void setGameMessageEncoder(MessageEncoder gameMessageEncoder) {
		Game.gameMessageEncoder = gameMessageEncoder;
	}

	/**
	 * Sets the message encoder handles printing to the map.
	 * 
	 * @param mapMessageEncoder
	 *            The encoder to use.
	 */
	public static void setMapMessageEncoder(MessageEncoder mapMessageEncoder) {
		Game.mapMessageEncoder = mapMessageEncoder;
	}

	/**
	 * Sets the message encoder handles printing of the menus.
	 * 
	 * @param menuMessageEncoder
	 *            The encoder to use.
	 */
	public static void setMenuMessageEncoder(MessageEncoder menuMessageEncoder) {
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
