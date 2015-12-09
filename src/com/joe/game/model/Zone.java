package com.joe.game.model;

import java.util.ArrayList;

import com.joe.game.Game;
import com.joe.game.control.DataManager;
import com.joe.game.control.EntityFactory;
import com.joe.game.control.stack.BoundedMap;
import com.joe.game.control.stack.entity.MultiStackEntityControler;
import com.joe.game.control.stack.entity.SingleStackEntityController;
import com.joe.game.io.data.ZoneData;
import com.joe.game.io.data.zone.ZoneItem;
import com.joe.game.io.data.zone.ZoneNpc;
import com.joe.game.model.component.Position;
import com.joe.game.model.component.SimpleMapView;
import com.joe.game.model.entity.GameObject;
import com.joe.game.model.entity.GroundItem;
import com.joe.game.model.entity.Npc;
import com.joe.game.model.entity.Player;

public class Zone extends BoundedMap<Character> {

	protected final MultiStackEntityControler<Npc> npcController;

	protected final SingleStackEntityController<GameObject> gameObjectController;

	protected final MultiStackEntityControler<GroundItem> groundItemController;

	private final int id;

	public Zone(int id) {

		this.id = id;

		int[][] map = getData().getObjects();

		int width = map[0].length;
		int height = map.length;

		setBounds(width, height);

		npcController = new MultiStackEntityControler<>(width, height);
		gameObjectController = new SingleStackEntityController<>(width, height);
		groundItemController = new MultiStackEntityControler<>(width, height);

		initializeMap();
	}

	private void initializeMap() {
		int[][] map = getData().getObjects();

		for (int row = 0; row < getHeight(); row++) {
			for (int col = 0; col < getWidth(); col++) {
				int objId = map[row][col];

				GameObject object = EntityFactory.createGameObject(objId, new Position(col, row));

				gameObjectController.register(object);
			}
		}

		ArrayList<ZoneNpc> npcs = getData().getNpcs();
		for (ZoneNpc npcData : npcs) {
			Npc npc = EntityFactory.createNpc(npcData.getID(), npcData.getPosition());
			npcController.register(npc);
		}

		ArrayList<ZoneItem> items = getData().getItems();
		for (ZoneItem itemData : items) {
			GroundItem item = EntityFactory.createGroundItem(itemData.getItem(),
					itemData.getPosition());
			groundItemController.register(item);
		}
	}

	public void setTileCharacters() {
		clear();

		for (int row = 0; row < getHeight(); row++) {
			for (int col = 0; col < getWidth(); col++) {
				GameObject object = gameObjectController.get(col, row);
				SimpleMapView mapView = object.getComponent(SimpleMapView.class);
				if (mapView != null) {
					set(col, row, mapView.getView());
				}
			}
		}

		for (int row = 0; row < getHeight(); row++) {
			for (int col = 0; col < getWidth(); col++) {
				GroundItem item = groundItemController.get(col, row).getTop();
				if (item == null) {
					continue;
				}
				SimpleMapView mapView = item.getComponent(SimpleMapView.class);
				if (mapView != null) {
					set(col, row, mapView.getView());
				}
			}
		}

		for (int row = 0; row < getHeight(); row++) {
			for (int col = 0; col < getWidth(); col++) {
				Npc npc = npcController.get(col, row).getTop();
				if (npc == null) {
					continue;
				}
				SimpleMapView mapView = npc.getComponent(SimpleMapView.class);
				if (mapView != null) {
					set(col, row, mapView.getView());
				}
			}
		}

		Player player = Game.getWorld().getPlayer();
		Position position = player.getComponent(Position.class);
		SimpleMapView mapView = player.getComponent(SimpleMapView.class);
		if (mapView != null) {
			set(position.getX(), position.getY(), mapView.getView());
		}
	}

	public void printZone() {
		setTileCharacters();

		String mapDisplay = "";
		for (int row = 0; row < getHeight(); row++) {
			for (int col = 0; col < getWidth(); col++) {
				mapDisplay = mapDisplay + String.format("%2s", get(col, row));
			}
			mapDisplay = mapDisplay + "\n";
		}

		Game.getMapMessageEncoder().clear();
		Game.getMapMessageEncoder().printLine(mapDisplay);
	}

	public void printPartialZone() {
		setTileCharacters();
		Camera camera = Game.getWorld().getCamera();

		int camX = camera.getLocation().getX();
		int camY = camera.getLocation().getY();

		int startX = camX - (camera.getWidth() / 2);
		int startY = camY - (camera.getHeight() / 2);
		int endX = camX + (camera.getWidth() / 2);
		int endY = camY + (camera.getHeight() / 2);

		if (startY < 0) {
			startY = 0;
		}
		if (startX < 0) {
			startX = 0;
		}
		if (endY >= getHeight()) {
			endY = getHeight() - 1;
		}
		if (endX >= getWidth()) {
			endX = getWidth() - 1;
		}

		String mapDisplay = "";
		for (int y = startY; y <= endY; y++) {
			for (int x = startX; x <= endX; x++) {
				Character c = get(x, y);
				if (c == null) {
					c = ' ';
				}
				mapDisplay = mapDisplay + String.format("%2c", c);
			}
			mapDisplay = mapDisplay + "\n";
		}

		Game.getMapMessageEncoder().clear();
		Game.getMapMessageEncoder().printLine(mapDisplay);
	}

	public int getId() {
		return id;
	}

	public ZoneData getData() {
		return DataManager.getZoneFetcher().forID(id);
	}

	public SingleStackEntityController<GameObject> getGameObjectController() {
		return gameObjectController;
	}

	public MultiStackEntityControler<GroundItem> getGroundItemController() {
		return groundItemController;
	}

	public MultiStackEntityControler<Npc> getNpcController() {
		return npcController;
	}

}
