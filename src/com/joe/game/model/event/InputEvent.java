package com.joe.game.model.event;

public class InputEvent extends Event {

	private final String input;

	public InputEvent(String input) {
		this.input = input;
	}

	public String getInput() {
		return input;
	}
}
