package com.joe.game.model;

/**
 * An entity that gets it's data from a definition/fetcher.
 * These types of entities have their most basic data
 * Predefined in json file.
 */
public abstract class DefinitionEntity extends Entity {

	/**
	 * The common id that is shared between all entities of the same type.
	 */
	private int globalId;

	/**
	 * Creates a new entity.
	 * 
	 * @param globalId
	 *            The common id that is shared between all entities of the same
	 *            type.
	 */
	public DefinitionEntity(int globalId) {
		this.globalId = globalId;
	}

	/**
	 * @return the common id that is shared between all entities of the same
	 *         type.
	 */
	public int getGlobalId() {
		return globalId;
	}
}
