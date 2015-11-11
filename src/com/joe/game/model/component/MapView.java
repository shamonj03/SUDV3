package com.joe.game.model.component;

import com.joe.game.model.Component;

@DefinitionModuel public class MapView extends Component {

	/**
	 * The 2D array of the aerial view something has on the map.
	 */
	private String[][] view;

	/**
	 * Create a new MapView component.
	 * 
	 * @param view
	 *            The 2D array of the aerial view something has on the map.
	 */
	public MapView(String[][] view) {
		this.view = view;
	}

	/**
	 * @return The 2D array of the aerial view something has on the map.
	 */
	public String[][] getView() {
		return view;
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
