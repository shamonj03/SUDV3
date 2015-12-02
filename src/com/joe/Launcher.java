package com.joe;

import com.joe.game.Game;

public class Launcher {

	/**
	 * Launches text based game. No GUI.
	 */
	public static void main(String[] args) {
		// Start the game.
		Game game = new Game();
		game.startGame();
	}
}
