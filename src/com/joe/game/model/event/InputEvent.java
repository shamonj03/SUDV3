package com.joe.game.model.event;

public class InputEvent extends Event {
	/**
	 * The input typed by the user after hitting enter.
	 */
	private final String input;

	/**
	 * Create an input event.
	 * 
	 * @param input
	 *            The input typed by the user after hitting enter.
	 */
	public InputEvent(String input) {
		this.input = input;
	}

	/**
	 * @return the input typed by the user after hitting enter.
	 */
	public String getInput() {
		return input;
	}
}
