package com.joe.game.model;

import com.joe.game.Game;
import com.joe.game.control.entity.EntityFactory;
import com.joe.game.io.DataManager;
import com.joe.game.io.data.ZoneData;
import com.joe.game.model.component.Dimensions;
import com.joe.game.model.component.MapView;
import com.joe.game.model.component.Position;
import com.joe.game.model.entity.GameObject;

public class Zone {

	private int id;

	private char[][] visibleMap;

	private Dimensions dimensions;

	public Zone(int id) {
		this.id = id;
	}

	public void initializeMap() {
		int[][] map = getData().getObjects();

		int width = map[0].length;
		int height = map.length;
		visibleMap = new char[height][width];

		dimensions = new Dimensions(width, height);
		System.out.println(dimensions);

		for (int row = 0; row < dimensions.getHeight(); row++) {
			for (int col = 0; col < dimensions.getWidth(); col++) {
				int objId = map[row][col];

				GameObject object = EntityFactory.createGameObject(objId, new Position(col, row));

				MapView mapView = object.getComponent(MapView.class);

				char[][] view = mapView.getView();
				for (int locY = 0; locY < mapView.getHeight(); locY++) {
					for (int locX = 0; locX < mapView.getWidth(); locX++) {
						int rY = row + locY;
						int rX = col + locX;

						char c = view[locY][locX];
						setTile(rX, rY, c);
					}
				}
			}
		}
	}

	public void printZone() {
		String mapDisplay = "";
		for (int row = 0; row < dimensions.getHeight(); row++) {
			for (int col = 0; col < dimensions.getWidth(); col++) {
				mapDisplay = mapDisplay + String.format("%2s", getTile(col, row));
			}
			mapDisplay = mapDisplay + "\n";
		}

		Game.getMapMessageEncoder().printLine(mapDisplay);
	}

	public void setTile(int x, int y, char c) {
		visibleMap[y][x] = c;
	}

	public char getTile(int x, int y) {
		return visibleMap[y][x];
	}

	public char[][] getVisibleMap() {
		return visibleMap;
	}

	public ZoneData getData() {
		return DataManager.getZoneFetcher().fetch(id);
	}
}
