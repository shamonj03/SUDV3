package com.joe;

import com.joe.view.SUDGui;

public class LaunchGUI {

	/**
	 * Launches game with GUI.
	 */
	public static void main(String[] args) {
		// Start the game with a GUI.
		SUDGui gui = new SUDGui();
		gui.display();
		gui.startGame();
	}
}
