package com.joe.game.io.data;

import com.joe.game.control.ComponentController;

public class ComponentData extends ComponentController implements Data {

	private int id;

	/**
	 * Create a new data component with a unique ID.
	 * 
	 * @param id
	 *            The id to set to.
	 */
	public ComponentData(int id) {
		this.id = id;
	}

	@Override public int getID() {
		return id;
	}
}
