package com.joe;

import com.joe.view.SUDGui;

public class LaunchGUI {

	public static void main(String[] args) {
		// Start the game with a gui.
		SUDGui gui = new SUDGui();
		gui.display();
		gui.startGame();
	}
}
