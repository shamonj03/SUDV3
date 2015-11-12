package com.joe.game.control;

import com.joe.game.Game;
import com.joe.game.io.data.ComponentData;
import com.joe.game.model.Component;
import com.joe.game.model.component.Dimensions;
import com.joe.game.model.component.Position;
import com.joe.game.model.entity.GameObject;
import com.joe.game.model.entity.Npc;

/**
 * A factory to create entities.
 */
public class EntityFactory {
	/**
	 * Create a new Npc.
	 * Fetches data for the Npc based on its id.
	 * 
	 * @param id
	 *            The id given to Npcs of the same type.
	 * @param position
	 *            The position to register the entity to.
	 * @return the Npc created.
	 */
	public static Npc createNpc(int id, Position position) {
		Npc entity = new Npc(id);
		ComponentData data = Game.getNpcFetcher().fetch(id);

		entity.register(new Dimensions(1, 1));
		for (Component component : data.getComponents().values()) {
			entity.register(component);
		}
		entity.register(position);
		return entity;
	}
	
	/**
	 * Create a new GameObject.
	 * Fetches data for the GameObject based on its id.
	 * 
	 * @param id
	 *            The id given to GameObjects of the same type.
	 * @param position
	 *            The position to register the entity to.
	 * @return the GameObject created.
	 */
	public static GameObject createGameObject(int id, Position position) {
		GameObject entity = new GameObject(id);
		ComponentData data = Game.getObjectFetcher().fetch(id);

		entity.register(new Dimensions(1, 1));
		for (Component component : data.getComponents().values()) {
			entity.register(component);
		}
		entity.register(position);
		return entity;
	}

}
