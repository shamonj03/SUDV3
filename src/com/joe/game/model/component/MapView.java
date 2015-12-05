package com.joe.game.model.component;


@DefinitionComponent public class MapView extends Component {
	/**
	 * The 2D array of the aerial view something has on the map.
	 */
	private char[][] view;

	/**
	 * Create a new MapView component.
	 * 
	 * @param view
	 *            The 2D array of the aerial view something has on the map.
	 */
	public MapView(char[][] view) {
		this.view = view;
	}

	/**
	 * Default blank map view.
	 */
	public MapView() {
		this.view = new char[][] { { ' ' } };
	}

	/**
	 * @return The 2D array of the aerial view something has on the map.
	 */
	public char[][] getView() {
		return view;
	}

	public int getWidth() {
		return view[0].length;
	}

	public int getHeight() {
		return view.length;
	}

	@Override public String toString() {
		String s = "\n";

		for (int y = 0; y < view.length; y++) {
			s = s + "\t";
			for (int x = 0; x < view[y].length; x++) {
				s = s + view[y][x];
				if (x < view[y].length - 1) {
					s = s + ", ";
				}
			}
			if (y < view.length - 1)
				s = s + "\n";
		}
		return "MapView\n[" + s + "\n]";
	}

}
