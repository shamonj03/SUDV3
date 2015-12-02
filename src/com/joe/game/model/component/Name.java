package com.joe.game.model.component;


/**
 * A name component used for identifying something.
 */
@DefinitionComponent public class Name extends Component {

	/**
	 * The name of the thing.
	 */
	private String name = "DEAFULT_NAME";

	/**
	 * Create a new name component.
	 * 
	 * @param name
	 *            The name of the thing.
	 */
	public Name(String name) {
		this.name = name;
	}

	/**
	 * Create a default name component.
	 */
	public Name() {
		this("DEFAULT_NAME");
	}

	/**
	 * Set the name to something else.
	 * 
	 * @param name
	 *            The name to change to.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name of the thing.
	 */
	public String getName() {
		return name;
	}

	@Override public String toString() {
		return "Name[\"" + name + "\"]";
	}
}
