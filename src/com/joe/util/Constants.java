package com.joe.util;

public final class Constants {
	/**
	 * Target FPS to run at.
	 */
	public static final int TARGET_FPS = 60;

	/**
	 * How many ticks are equal to one frame in milliseconds.
	 */
	public static final double FRAMES_TO_TICKS = (1.0 / TARGET_FPS) * 1000.0;

	/**
	 * The speed at which messages stream into view.
	 */
	public static final double MESSAGE_SPEED = FRAMES_TO_TICKS * 5.0;

	private Constants() {
		// Prevents instantiation.
	}
}
