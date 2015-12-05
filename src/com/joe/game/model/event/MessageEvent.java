package com.joe.game.model.event;

public class MessageEvent extends Event {
	/**
	 * The message to display to the message screen.
	 */
	private final String message;

	/**
	 * Create a new message event.
	 * 
	 * @param message
	 *            The message to display to the message screen.
	 */
	public MessageEvent(String message) {
		this.message = message;
	}

	/**
	 * @return the message to display to the message screen.
	 */
	public String getMessage() {
		return message;
	}
}
