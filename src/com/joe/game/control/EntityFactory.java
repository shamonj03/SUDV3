package com.joe.game.control;

import java.util.ArrayList;

import com.joe.game.Game;
import com.joe.game.control.stack.StackController;
import com.joe.game.io.data.ComponentData;
import com.joe.game.model.DefinitionEntity;
import com.joe.game.model.Item;
import com.joe.game.model.Zone;
import com.joe.game.model.component.Component;
import com.joe.game.model.component.Dimensions;
import com.joe.game.model.component.Position;
import com.joe.game.model.component.WorldSettings;
import com.joe.game.model.entity.GameObject;
import com.joe.game.model.entity.GroundItem;
import com.joe.game.model.entity.Npc;
import com.joe.game.model.entity.Player;
import com.joe.util.Constants;

/**
 * A factory to create entities.
 */
public class EntityFactory {
	/**
	 * Everything is this class is static. No instantiation.
	 */
	private EntityFactory() {
		throw new UnsupportedOperationException("Instantiation not allowed here.");
	}

	/**
	 * Create a new Ground Item.
	 * 
	 * @param id
	 *            The id given to Ground Item of the same type.
	 * @param amount
	 *            The amount of the item to spawn.
	 * @param position
	 *            The position to register the entity to.
	 * @return the Ground Item created.
	 */
	public static GroundItem createGroundItem(int id, int amount, Position position) {
		GroundItem entity = new GroundItem(new Item(id, amount), position);
		
		ComponentData data = DataManager.getItemFetcher().forID(id);

		entity.register(new Dimensions(1, 1));
		for (Component component : data.getComponents().values()) {
			entity.register(component);
		}
		entity.register(position);
		return entity;
	}
	

	public static GroundItem createGroundItem(Item item, Position position) {
		return createGroundItem(item.getId(), item.getAmount(), position);
	}

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
		ComponentData data = DataManager.getNpcFetcher().forID(id);

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
		ComponentData data = DataManager.getObjectFetcher().forID(id);

		entity.register(new Dimensions(1, 1));
		for (Component component : data.getComponents().values()) {
			entity.register(component);
		}
		entity.register(position);
		return entity;
	}

	/**
	 * Creates a list of entities that are within range of the player
	 * 
	 * @return a list of entities.
	 */
	public static ArrayList<DefinitionEntity> getInteractableEntitiesInRange() {
		ArrayList<DefinitionEntity> list = new ArrayList<>();

		Zone zone = Game.getWorld().getZoneInstanceController().getCurrentZone();

		Player player = Game.getWorld().getPlayer();
		Position position = player.getComponent(Position.class);

		for (int index = 0; index < Constants.TILE_OFFSETS.length; index++) {
			int x = position.getX() + Constants.TILE_OFFSETS[index][0];
			int y = position.getY() + Constants.TILE_OFFSETS[index][1];

			if (!zone.inBounds(x, y)) {
				continue;
			}

			GameObject object = zone.getGameObjectController().get(x, y);
			WorldSettings objectSettings = object.getComponent(WorldSettings.class);
			if (objectSettings != null && objectSettings.isInteractable()) {
				list.add(object);
			}

			StackController<Npc> npcs = zone.getNpcController().get(x, y);
			npcs.forEach(npc -> {
				WorldSettings npcSettings = npc.getComponent(WorldSettings.class);
				if (npcSettings != null && npcSettings.isInteractable()) {
					list.add(npc);
				}
			});

			StackController<GroundItem> groundItems = zone.getGroundItemController().get(x, y);
			groundItems.forEach(item -> {
				WorldSettings groundItemSettings = item.getComponent(WorldSettings.class);
				if (groundItemSettings != null && groundItemSettings.isInteractable()) {
					list.add(item);
				}
			});
		}
		return list;
	}

}
