package com.joe.game.model;

import com.joe.game.Game;
import com.joe.game.control.ZoneInstanceManager;
import com.joe.game.model.component.Position;
import com.joe.game.model.entity.Player;
import com.joe.game.model.event.EquipItemEvent;

/**
 * This is the current world visible by the game.
 * Not to be confused with a zone. A zone contains data.
 *
 */
public class World {

	private Player player;

	private Camera camera;

	private ZoneInstanceManager zoneInstanceController = new ZoneInstanceManager();

	public void initialize() {
		player = new Player();
		camera = new Camera(5, 5, player.getComponent(Position.class));
		
		player.getInventory().addItem(0, 1);
		Game.getEventDispatcher().dispatch(new EquipItemEvent(new Item(0, 1)));
		Game.getEventDispatcher().dispatch(new EquipItemEvent(new Item(0, 1)));
		Game.getEventDispatcher().dispatch(new EquipItemEvent(new Item(1, 5)));
		Game.getEventDispatcher().dispatch(new EquipItemEvent(new Item(1, 15)));

	}

	public void draw() {
		Zone zone = zoneInstanceController.getCurrentZone();
		zone.printPartialZone();
	}

	public Camera getCamera() {
		return camera;
	}

	public Player getPlayer() {
		return player;
	}

	public ZoneInstanceManager getZoneInstanceController() {
		return zoneInstanceController;
	}
}
