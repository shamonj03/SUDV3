package com.joe.game.model.component;

import com.joe.game.model.Component;

/**
 * A health component given to a entity.
 */
@DefinitionModuel public class Health extends Component {

	/**
	 * The amount of health something has.
	 */
	private int health = 10;

	/**
	 * Creates a new health component for something.
	 * 
	 * @param health
	 *            The amount of health something has.
	 */
	public Health(int health) {
		this.health = health;
	}

	/**
	 * Set the default health component to 10.
	 */
	public Health() {
		this(10);
	}

	/**
	 * Offset the health of something.
	 * 
	 * @param offset
	 *            The amount of health to change by.
	 */
	public void offsetHealth(int offset) {
		this.health += offset;
	}

	/**
	 * Set the health of something.
	 * 
	 * @param health
	 *            The amount of health to change to.
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @return the amount of health something has.
	 */
	public int getHealth() {
		return health;
	}

	@Override public String toString() {
		return "Health[" + health + " hp]";
	}
}
