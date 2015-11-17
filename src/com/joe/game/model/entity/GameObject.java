package com.joe.game.model.entity;

import com.joe.game.model.DefinitionEntity;
import com.joe.game.model.EntityType;
import com.joe.game.model.component.MapView;

/**
 * A game object entity to distinguish its instance from other entities.
 * Retrieves its default data from a json file based on it's id.
 */
public class GameObject extends DefinitionEntity {
	/**
	 * Creates a new Game Object.
	 * 
	 * @param id
	 *            The id of the object to create. This ID is unique amongst all
	 *            other objects.
	 */
	public GameObject(int id) {
		super(id);
		
		this.register(new MapView());
	}

	@Override public EntityType getType() {
		return EntityType.OBJECT;
	}

}
