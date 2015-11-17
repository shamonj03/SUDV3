package com.joe.view;

import com.joe.util.Constants;

/**
 * Handles what to do when a message is printed.
 */
public interface MessageEncoder {
	/**
	 * Print a message on a single line.
	 * No line break on the end.
	 * 
	 * @param message
	 *            The message to print.
	 */
	public void print(String message);

	/**
	 * Print a message on a character by character.
	 * Ends the line when finished.
	 * 
	 * @param message
	 *            The message to print.
	 */
	public default void streamLine(String message) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < message.length();) {
			if ((System.currentTimeMillis() - start) > Constants.MESSAGE_SPEED) {
				print(String.valueOf(message.charAt(i++)));
				start = System.currentTimeMillis();
			}
		}
		printLine();
	}

	/**
	 * Print a message on a single line.
	 * Ends the line when finished.
	 * 
	 * @param message
	 *            The message to print.
	 */
	public default void printLine(String message) {
		print(message + "\n");
	}

	/**
	 * Print an object on a single line.
	 * Ends the line when finished.
	 * 
	 * @param object
	 *            The object to print.
	 */
	public default void printLine(Object object) {
		print(object + "\n");
	}

	/**
	 * Prints a blank empty line.
	 */
	public default void printLine() {
		printLine("");
	}
	
	public default void printFormat(String text, Object... args) {
		print(String.format(text, args));
	}
	
	public default void printFormatLine(String text, Object... args) {
		printFormat(text, args);
		printLine();
	}
}
