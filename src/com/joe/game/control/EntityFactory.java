package com.joe.game.control;

import com.joe.game.Game;
import com.joe.game.io.Data;
import com.joe.game.model.Component;
import com.joe.game.model.component.Dimensions;
import com.joe.game.model.component.Position;
import com.joe.game.model.entity.GameObject;
import com.joe.game.model.entity.Npc;

public class EntityFactory {

	public static Npc createNpc(int id, Position position) {
		Npc entity = new Npc(id);
		Data data = Game.getNpcFetcher().fetch(id);

		entity.register(new Dimensions(1, 1));
		for (Component component : data.getComponents().values()) {
			entity.register(component);
		}
		entity.register(position);
		return entity;
	}

	public static GameObject createGameObject(int id, Position position) {
		GameObject entity = new GameObject(id);
		Data data = Game.getObjectFetcher().fetch(id);

		entity.register(new Dimensions(1, 1));
		for (Component component : data.getComponents().values()) {
			entity.register(component);
		}
		entity.register(position);
		return entity;
	}

}
