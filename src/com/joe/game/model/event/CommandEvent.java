package com.joe.game.model.event;

import com.joe.game.model.Event;

public class CommandEvent extends Event {

	private String command;

	public CommandEvent(String command) {
		this.command = command;
	}

	public String getCommand() {
		return command;
	}
}
