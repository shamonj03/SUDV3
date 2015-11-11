package com.joe.view;

public class Messages {

	/**
	 * @return The greeting message
	 */
	public static String greetingMessage() {
		return createMessage("Hello adventurer", "My name is Merlin. How are you?");
	}

	/**
	 * Create a message.
	 * 
	 * @param lines
	 *            An array of messages, each row is another line.
	 * 
	 * @return a new message formated into a string with line separators at the
	 *         end.
	 */
	public static String createMessage(String... lines) {
		String message = "";

		for (int index = 0; index < lines.length; index++) {
			String line = lines[index];
			message = message + line;

			if (index < lines.length - 1) {
				message = message + "\n";
			}
		}
		return message;
	}
}