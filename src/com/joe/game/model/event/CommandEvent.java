package com.joe.game.model.event;

public class CommandEvent extends Event {
	/**
	 * The command entered.
	 */
	private final String command;

	/**
	 * Create a command event.
	 * 
	 * @param command
	 *            The command entered.
	 */
	public CommandEvent(String command) {
		this.command = command;
	}

	/**
	 * @return the command entered.
	 */
	public String getCommand() {
		return command;
	}
}
