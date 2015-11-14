package com.joe.game.io.data;

import java.util.HashMap;

import com.joe.game.model.Component;

public class ComponentData extends Data {

	public ComponentData(int id) {
		super(id);
	}

	/**
	 * The components registered to the data.
	 */
	private HashMap<Class<?>, Component> components = new HashMap<>();

	/**
	 * @return the components of the data class.
	 */
	public HashMap<Class<?>, Component> getComponents() {
		return components;
	}
}
