package com.joe.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.joe.util.Constants;

@SuppressWarnings("serial") public class GameTextArea extends JPanel implements MessageEncoder {
	/**
	 * The pane to write to.
	 */
	protected JTextPane textPane;

	/**
	 * The style the pane is using.
	 */
	private Style style;

	/**
	 * Create a text area for the game to write text to.
	 * 
	 * @param width
	 *            Width of the text area.
	 * @param height
	 *            Height of the text area.
	 */
	public GameTextArea(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		setSize(dimension);
		setPreferredSize(dimension);

		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		textPane = new JTextPane();

		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 14);
		textPane.setFont(font);
		textPane.setEditable(false);

		style = textPane.addStyle("Style", null);
		StyleConstants.setForeground(style, Constants.FONT_COLOR);
		StyleConstants.setBackground(style, Constants.BG_COLOR);

		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setPreferredSize(dimension);
		scrollPane.setBorder(BorderFactory.createLineBorder(Constants.FONT_COLOR));
		textPane.setBackground(Constants.BG_COLOR);
		setBorder(BorderFactory.createEmptyBorder());

		add(scrollPane);
	}

	/**
	 * Clear the text of the pane.
	 */
	public void clearText() {
		setText("");
	}

	/**
	 * Set the text of the pane.
	 * 
	 * @param text
	 *            Text to set to.
	 */
	public void setText(String text) {
		textPane.setText(text);
		textPane.setCaretPosition(textPane.getDocument().getLength());
	}

	/**
	 * Append a string of text to the pane.
	 * 
	 * @param text
	 *            Text to append.
	 */
	private void append(String text) {
		StyledDocument doc = textPane.getStyledDocument();
		try {
			doc.insertString(doc.getLength(), text, style);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		textPane.setCaretPosition(textPane.getDocument().getLength());
	}

	/**
	 * Define how to handle printing to the text area.
	 */
	@Override public void print(String message) {
		append(message);
	}

}
