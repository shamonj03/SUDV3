package com.joe.game.io.data;

public class ZoneData extends Data {
	/**
	 * Name of the zone.
	 */
	private String name;

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
		super(id);
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

}
