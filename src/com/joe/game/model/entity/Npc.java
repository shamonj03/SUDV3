package com.joe.game.model.entity;

import com.joe.game.model.DefinitionEntity;
import com.joe.game.model.EntityType;

/**
 * A NPC entity to distinguish its instance from other entities.
 * Retrieves its default data from a json file based on it's id.
 */
public class Npc extends DefinitionEntity {
	/**
	 * Creates a new Npc.
	 * 
	 * @param id
	 *            The id of the npc to create. This ID is unique amongst all
	 *            other objects.
	 */
	public Npc(int id) {
		super(id);
	}

	@Override public EntityType getType() {
		return EntityType.NPC;
	}
}
