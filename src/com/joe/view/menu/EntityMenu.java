package com.joe.view.menu;

import java.util.ArrayList;

import com.joe.game.Game;
import com.joe.game.control.EntityFactory;
import com.joe.game.model.DefinitionEntity;
import com.joe.game.model.Entity;
import com.joe.game.model.EntityType;
import com.joe.game.model.component.Name;
import com.joe.game.model.entity.GameObject;
import com.joe.game.model.entity.GroundItem;
import com.joe.game.model.entity.Npc;
import com.joe.game.model.event.InputEvent;
import com.joe.game.model.event.InteractWithGroundItemEvent;
import com.joe.game.model.event.InteractWithNpcEvent;
import com.joe.game.model.event.InteractWithObjectEvent;

public class EntityMenu extends GameMenu {

	public EntityMenu() {
		super("What would you like to do?");
	}

	@Override public void populate() {
		ArrayList<DefinitionEntity> list = EntityFactory.getEntitiesInRange();

		for (int i = 0; i < list.size(); i++) {
			Entity e = list.get(i);

			addItem((i + 1) + ": " + e.getComponent(Name.class).getName());
		}

		addItem("0: Back");
	}

	@Override public void handle(InputEvent event) {
		String input = event.getInput();

		if (input.equals("0")) {
			Game.getMenuController().setMenuID(0);
		} else {
			if (input.matches("[0-9]")) {
				ArrayList<DefinitionEntity> list = EntityFactory.getEntitiesInRange();

				int index = Integer.parseInt(input);

				if (index <= list.size()) {
					DefinitionEntity entity = list.get(index - 1);
					int zoneId = Game.getWorld().getZoneInstanceController().getCurrentZoneID();

					if (entity.getType() == EntityType.NPC) {
						Game.getEventController().sendEvent(new InteractWithNpcEvent(zoneId, (Npc) entity));
					} else if (entity.getType() == EntityType.OBJECT) {
						Game.getEventController().sendEvent(new InteractWithObjectEvent(zoneId, (GameObject) entity));
					} else if (entity.getType() == EntityType.GROUND_ITEM) {
						Game.getEventController().sendEvent(
								new InteractWithGroundItemEvent(zoneId, (GroundItem) entity));
					}
				}
			}
		}
	}
}
