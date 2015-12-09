package com.joe.game.model.component;

@DefinitionComponent public class InteractOptions extends Component {

	private final String[] options;

	public InteractOptions(String[] options) {
		this.options = options;
	}

	public String getOption(int index) {
		return options[index];
	}

	public int size() {
		return options.length;
	}

	public String[] getOptions() {
		return options;
	}

	@Override public String toString() {
		String s = "";

		for (int index = 0; index < options.length; index++) {
			s = s + " " + options[index];

			if (index < options.length - 1) {
				s = s + ",";
			}
		}
		return "InteractOptions[" + s + "]";
	}
}
