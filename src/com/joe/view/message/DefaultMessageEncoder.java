package com.joe.view.message;

/**
 * Default message encoder uses System.out class.
 */
public class DefaultMessageEncoder implements MessageEncoder {

	@Override public void print(String message) {
		System.out.print(message);
	}
	
	@Override public void clear() {
		// Not supported.
	}
}
