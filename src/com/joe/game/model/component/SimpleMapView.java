package com.joe.game.model.component;

@DefinitionComponent public class SimpleMapView extends Component {
	/**
	 * The character to see on the map.
	 */
	private char view;

	/**
	 * Create a new map view component.
	 * 
	 * @param view
	 *            The character to see on the map.
	 */
	public SimpleMapView(char view) {
		this.view = view;
	}

	/**
	 * Default map view component.
	 */
	public SimpleMapView() {
		this(' ');
	}

	/**
	 * @return the character to see on the map.
	 */
	public char getView() {
		return view;
	}
}
