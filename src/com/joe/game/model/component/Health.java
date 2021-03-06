package com.joe.game.model.component;

/**
 * A health component given to a entity.
 */
@DefinitionComponent public class Health extends Component {
	/**
	 * The amount of health something has.
	 */
	private int health = 10;

	/**
	 * The initial health.
	 */
	private final int defaultHealth;

	/**
	 * Creates a new health component for something.
	 * 
	 * @param health
	 *            The amount of health something has.
	 */
	public Health(int health) {
		this.defaultHealth = health;
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

	/**
	 * @return The initial health.
	 */
	public int getDefaultHealth() {
		return defaultHealth;
	}

	@Override public String toString() {
		return "Health[" + health + " hp]";
	}
}
