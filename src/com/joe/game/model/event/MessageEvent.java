package com.joe.game.model.event;

import com.joe.game.model.Event;

public class MessageEvent extends Event {

	private String message;

	public MessageEvent(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
