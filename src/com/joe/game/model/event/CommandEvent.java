package com.joe.game.model.event;

public class CommandEvent extends Event {

	private String command;

	public CommandEvent(String command) {
		this.command = command;
	}

	public String getCommand() {
		return command;
	}
}
