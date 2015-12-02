package com.joe.view;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

@SuppressWarnings("serial") public class CenteredGameTextArea extends GameTextArea {

	/**
	 * Create a text area for the game where the text is centered.
	 * 
	 * @param width
	 *            Width of the text area.
	 * @param height
	 *            Height of the text area.
	 */
	public CenteredGameTextArea(int width, int height) {
		super(width, height);

		StyledDocument doc = textPane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
	}

}
