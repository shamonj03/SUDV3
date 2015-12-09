package com.joe.view.message;

/**
 * Default message encoder uses System.out class.
 */
public class DefaultMessageEncoder implements MessageEncoder {
	/**
	 * Print a message to the console.
	 */
	@Override public void print(String message) {
		System.out.print(message);
	}
	
	@Override public void clear() {
		// Not supported.
	}
}
