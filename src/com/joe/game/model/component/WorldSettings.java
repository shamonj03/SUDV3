package com.joe.game.model.component;


/**
 * A class to define something's settings in the world.
 * Defines whether or not it can be interacted with,
 * moved through, or is visible on the map.
 */
@DefinitionComponent public class WorldSettings extends Component {
	/**
	 * Set whether or not something else move through this.
	 */
	private boolean solid = true;

	/**
	 * Set whether or not something else interact with this.
	 */
	private boolean interactable = false;

	/**
	 * Set whether or not something else see this.
	 */
	private boolean visible = true;

	/**
	 * Creates a new WorldState component for something.
	 * 
	 * @param solid
	 *            Set whether or not something else move through this.
	 * @param interactable
	 *            Set whether or not something else interact with this.
	 * @param visible
	 *            Set whether or not something else see this.
	 */
	public WorldSettings(boolean solid, boolean interactable, boolean visible) {
		this.solid = solid;
		this.interactable = interactable;
		this.visible = visible;
	}

	/**
	 * Default world state.
	 * Is solid, cannot be interacted with, and is visible.
	 */
	public WorldSettings() {
		this(true, false, true);
	}

	/**
	 * Set whether or not something else interact with this.
	 * 
	 * @param interactable
	 *            True or false.
	 */
	public void setInteractable(boolean interactable) {
		this.interactable = interactable;
	}

	/**
	 * Set whether or not something else move through this.
	 * 
	 * @param solid
	 *            True or false.
	 */
	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	/**
	 * Set whether or not something else see this.
	 * 
	 * @param visible
	 *            True or false.
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * @return whether or not something else see this.
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * @return whether or not something else interact with this.
	 */
	public boolean isInteractable() {
		return interactable;
	}

	/**
	 * @return whether or not something else move through this.
	 */
	public boolean isSolid() {
		return solid;
	}

	@Override public String toString() {
		return "WorldState[Solid: " + solid + ", Interactable: " + interactable + ", Visible: " + visible + "]";
	}
}
