package com.joe.game.model;

import com.joe.game.model.component.Dimensions;

public class Zone {

	private final Dimensions dimensions;

	public Zone(int width, int height) {
		dimensions = new Dimensions(width, height);
	}

	public Dimensions getDimensions() {
		return dimensions;
	}
}
