package com.joe.game.model.component;


@DefinitionComponent public class SimpleMapView extends Component {

	private char view;

	public SimpleMapView(char view) {
		this.view = view;
	}

	public SimpleMapView() {
		this(' ');
	}

	public char getView() {
		return view;
	}
}
