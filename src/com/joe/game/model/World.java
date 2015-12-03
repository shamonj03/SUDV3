package com.joe.game.model;

import com.joe.game.Game;
import com.joe.game.control.EntityFactory;
import com.joe.game.control.ZoneInstanceController;
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

	private ZoneInstanceController zoneInstanceController = new ZoneInstanceController();

	public void initialize() {
		player = new Player();
		camera = new Camera(5, 5, player.getComponent(Position.class));

		Zone zone = zoneInstanceController.getCurrentZone();
		zone.npcController.register(EntityFactory.createNpc(1, new Position(1, 2)));
		
		player.getInventory().addItem(0, 1);
		Game.getEventController().sendEvent(new EquipItemEvent(new Item(0, 1)));
		Game.getEventController().sendEvent(new EquipItemEvent(new Item(0, 1)));
		Game.getEventController().sendEvent(new EquipItemEvent(new Item(1, 5)));
		Game.getEventController().sendEvent(new EquipItemEvent(new Item(1, 15)));

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

	public ZoneInstanceController getZoneInstanceController() {
		return zoneInstanceController;
	}
}
