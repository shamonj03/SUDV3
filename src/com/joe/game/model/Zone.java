package com.joe.game.model;

import com.joe.game.Game;
import com.joe.game.control.EntityFactory;
import com.joe.game.control.stack.BoundedMap;
import com.joe.game.control.stack.entity.StackedEntityControler;
import com.joe.game.control.stack.entity.StaticEntityController;
import com.joe.game.io.DataManager;
import com.joe.game.io.data.ZoneData;
import com.joe.game.model.component.Position;
import com.joe.game.model.component.SimpleMapView;
import com.joe.game.model.entity.GameObject;
import com.joe.game.model.entity.GroundItem;
import com.joe.game.model.entity.Npc;
import com.joe.game.model.entity.Player;

public class Zone extends BoundedMap<Character> {

	protected final StackedEntityControler<Npc> npcController;

	protected final StaticEntityController<GameObject> gameObjectController;

	protected final StackedEntityControler<GroundItem> groundItemController;

	private final int id;

	public Zone(int id) {

		this.id = id;

		int[][] map = getData().getObjects();

		int width = map[0].length;
		int height = map.length;

		setBounds(width, height);

		npcController = new StackedEntityControler<>(width, height);
		gameObjectController = new StaticEntityController<>(width, height);
		groundItemController = new StackedEntityControler<>(width, height);

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
	}

	public void setTileCharacters() {
		clear();

		for (int row = 0; row < getHeight(); row++) {
			for (int col = 0; col < getWidth(); col++) {
				GameObject object = gameObjectController.get(col, row);
				SimpleMapView mapView = object.getComponent(SimpleMapView.class);
				set(col, row, mapView.getView());
			}
		}

		for (int row = 0; row < getHeight(); row++) {
			for (int col = 0; col < getWidth(); col++) {
				Npc object = npcController.get(col, row).getTop();
				if (object == null) {
					continue;
				}
				SimpleMapView mapView = object.getComponent(SimpleMapView.class);
				set(col, row, mapView.getView());
			}
		}

		Player player = Game.getWorld().getPlayer();
		Position position = player.getComponent(Position.class);
		SimpleMapView mapView = player.getComponent(SimpleMapView.class);
		set(position.getX(), position.getY(), mapView.getView());
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
		return DataManager.getZoneFetcher().forId(id);
	}

	public StaticEntityController<GameObject> getGameObjectController() {
		return gameObjectController;
	}

	public StackedEntityControler<GroundItem> getGroundItemController() {
		return groundItemController;
	}

	public StackedEntityControler<Npc> getNpcController() {
		return npcController;
	}

}
