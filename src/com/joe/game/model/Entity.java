package com.joe.game.model;

import java.util.UUID;

import com.joe.game.control.ComponentController;

/**
 * An entity that is made up of components.
 * An entity is anything in the game that makes up the world.
 */
public abstract class Entity extends ComponentController {
	/**
	 * Unique randomized Id give to an entity to distinguish them
	 * from entities of the same type.
	 */
	private final UUID uniqueID = UUID.randomUUID();

	/**
	 * @return type type of entity this is.
	 */
	public abstract EntityType getType();

	/**
	 * @return the unique id given to this entity.
	 */
	public UUID getUniqueID() {
		return uniqueID;
	}

	/**
	 * Prints out the entity
	 * Output:
	 * Entity_TYPE: uniqueId
	 * Components[...]
	 */
	@Override public String toString() {
		String s = "";
		s = s + "Entity_" + getType() + ": " + uniqueID + "\n";

		String[] lines = componentsToString().split("\\r?\\n");

		for (String line : lines) {
			s = s + "\t" + line + "\n";
		}
		return s;
	}
}
