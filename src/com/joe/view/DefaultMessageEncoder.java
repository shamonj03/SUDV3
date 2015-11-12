package com.joe.view;

/**
 * Default message encoder uses System.out class.
 */
public class DefaultMessageEncoder implements MessageEncoder {

	@Override public void print(String message) {
		System.out.print(message);
	}
}
