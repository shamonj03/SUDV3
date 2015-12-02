package com.joe.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.joe.game.Game;

public class SUDGui extends Game {

	public void display() {
		JFrame frame = new JFrame("SUD - Joe Resch");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GameTextArea mapTextArea = new CenteredGameTextArea(600, 148);
		GameTextArea gameTextArea = new GameTextArea(250, 200);
		GameTextArea menuTextArea = new GameTextArea(350, 200);
		GameInputArea inputArea = new GameInputArea(500, 24);

		setMapMessageEncoder(mapTextArea);
		setGameMessageEncoder(gameTextArea);
		setMenuMessageEncoder(menuTextArea);

		frame.add(mapTextArea, BorderLayout.NORTH);
		frame.add(gameTextArea, BorderLayout.CENTER);
		frame.add(menuTextArea, BorderLayout.WEST);
		frame.add(inputArea, BorderLayout.SOUTH);
		frame.setResizable(false);

		frame.pack();
		frame.setVisible(true);

		inputArea.requestFocusInWindow();
	}
}
