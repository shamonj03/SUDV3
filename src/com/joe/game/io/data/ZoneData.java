package com.joe.game.io.data;

import java.util.ArrayList;

import com.joe.game.io.data.zone.ZoneItem;
import com.joe.game.io.data.zone.ZoneNpc;

public class ZoneData implements Data {
	/**
	 * Name of the zone.
	 */
	private String name;

	private int id;
	
	private ArrayList<ZoneNpc> npcs;
	
	private ArrayList<ZoneItem> items;
	
	/**
	 * The objects within the zone.
	 */
	private int[][] objects;

	/**
	 * Create a new zone for the ID.
	 * 
	 * @param id
	 *            The id of the zone.
	 */
	public ZoneData(int id) {
		this.id = id;
	}
	
	public void initialize(String name, int width, int height) {
		this.name = name;
		objects = new int[height][width];
		items = new ArrayList<>();
		npcs = new ArrayList<>();
	}

	/**
	 * @return the name of the zone.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the objects in the zone.
	 */
	public int[][] getObjects() {
		return objects;
	}

	public ArrayList<ZoneItem> getItems() {
		return items;
	}

	public ArrayList<ZoneNpc> getNpcs() {
		return npcs;
	}
	
	@Override public int getID() {
		return id;
	}
}
