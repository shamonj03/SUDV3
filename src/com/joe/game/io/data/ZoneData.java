package com.joe.game.io.data;

import com.joe.game.io.Data;

public class ZoneData extends Data {

	private String name;

	private int[][] objects;

	public ZoneData(int id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public int[][] getObjects() {
		return objects;
	}

}
