package com.joe.util;

import java.awt.Color;

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

	/**
	 * The color of the GUI's font. Borders also match this color.
	 */
	public static final Color FONT_COLOR = Color.RED;

	/**
	 * The color of the GUIs background.
	 */
	public static final Color BG_COLOR = Color.BLACK;

	/**
	 * Adjacent tile offsets.
	 */
	public static final int[][] TILE_OFFSETS = { { -1, 0, }, { 0, -1 }, { 0, 0, }, { 1, 0 }, { 0, 1 } };

	/**
	 * Path to script folder.
	 */
	public static final String SCRIPT_FOLDER = "./data/scripts/";

	private Constants() {
		// Prevents instantiation.
		throw new UnsupportedOperationException("Instantiation not allowed here.");
	}
}
