package com.joe.util;

public class MessageUtil {

	/**
	 * Stream text across the screen. Splits the message into each character and
	 * displays them one by one for every game tick.
	 * 
	 * @param message
	 *            Message to display.
	 */
	public static void stream(String message) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < message.length();) {
			if ((System.currentTimeMillis() - start) > Constants.MESSAGE_SPEED) {
				System.out.print(message.charAt(i++));
				start = System.currentTimeMillis();
			}
		}
		System.out.println();
	}
}
