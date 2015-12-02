package com.joe.game.model.event;

public class MessageEvent extends Event {

	private final String message;

	public MessageEvent(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
