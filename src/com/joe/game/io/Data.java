package com.joe.game.io;

import java.util.HashMap;

import com.joe.game.model.Component;

public class Data {

	/**
	 * The unique ID of the data class.
	 */
	private int id;

	/**
	 * The components registered to the data.
	 */
	private HashMap<Class<?>, Component> components = new HashMap<>();

	/**
	 * Creates a new Data instance.
	 * 
	 * @param id
	 *            The unique id of the data class.
	 */
	public Data(int id) {
		this.id = id;
	}

	/**
	 * @return the components of the data class.
	 */
	public HashMap<Class<?>, Component> getComponents() {
		return components;
	}

	/**
	 * @return the unique id of the data class.
	 */
	public int getId() {
		return id;
	}

}
