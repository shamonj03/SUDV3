package com.joe.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import com.joe.game.control.EventController;
import com.joe.util.Constants;
import com.joe.game.model.event.InputEvent;

@SuppressWarnings("serial") public class GameInputArea extends JTextField {

	/**
	 * Create a new input area that listens for a players decision.
	 * 
	 * @param width
	 *            Width of the area.
	 * @param height
	 *            Height of the area.
	 */
	public GameInputArea(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		setSize(dimension);
		setPreferredSize(dimension);

		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		setPreferredSize(dimension);

		addActionListener(e -> {
			String text = getText().trim();
			EventController.sendEvent(new InputEvent(text));
			setText("");
		});

		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 14);
		setFont(font);

		setForeground(Constants.FONT_COLOR);
		setBackground(Constants.BG_COLOR);
		setBorder(BorderFactory.createLineBorder(Constants.FONT_COLOR));
	}
}
