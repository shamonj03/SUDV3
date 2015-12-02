package com.joe.game.io.data;

public class ItemData extends Data {

	private String name;

	private boolean stackable;

	public ItemData(int id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public boolean isStackable() {
		return stackable;
	}

}
