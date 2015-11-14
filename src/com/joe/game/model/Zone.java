package com.joe.game.model;

public class Zone {

	private char[][] visibleMap;

	public void setTile(int x, int y, char c) {
		visibleMap[y][x] = c;
	}

	public char getTile(int x, int y) {
		return visibleMap[y][x];
	}

	public char[][] getVisibleMap() {
		return visibleMap;
	}
}
