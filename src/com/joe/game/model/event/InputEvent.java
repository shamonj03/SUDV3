package com.joe.game.model.event;

import com.joe.game.model.Event;

public class InputEvent extends Event {

	private String input;

	public InputEvent(String input) {
		this.input = input;
	}

	public String getInput() {
		return input;
	}
}
