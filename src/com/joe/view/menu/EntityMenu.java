package com.joe.view.menu;

import java.util.ArrayList;

import com.joe.game.Game;
import com.joe.game.control.EntityFactory;
import com.joe.game.model.DefinitionEntity;
import com.joe.game.model.Entity;
import com.joe.game.model.EntityType;
import com.joe.game.model.component.InteractOptions;
import com.joe.game.model.component.Name;
import com.joe.game.model.entity.GameObject;
import com.joe.game.model.entity.GroundItem;
import com.joe.game.model.entity.Npc;
import com.joe.game.model.entity.Player;
import com.joe.game.model.event.InputEvent;
import com.joe.game.model.event.InteractWithGroundItemEvent;
import com.joe.game.model.event.InteractWithNpcEvent;
import com.joe.game.model.event.InteractWithObjectEvent;

public class EntityMenu extends GameMenu {

	public EntityMenu() {
		super("What would you like to do?");
	}

	@Override public void populate() {
		ArrayList<DefinitionEntity> list = EntityFactory.getInteractableEntitiesInRange();

		for (int i = 0; i < list.size(); i++) {
			Entity entity = list.get(i);

			Name name = entity.getComponent(Name.class);
			if (name != null) {
				addItem((i + 1) + ": " + name.getName());
			}

			InteractOptions options = entity.getComponent(InteractOptions.class);

			if (options != null) {
				for (int index = 0; index < options.size(); index++) {
					String option = options.getOption(index);

					String menuIndex = (i + 1) + "." + index;
					addItem("\t" + menuIndex + ": " + option);
				}
			}
		}

		addItem("0: Back");
	}

	@Override public void handle(InputEvent event) {
		String input = event.getInput();

		if (input.equals("0")) {
			Game.getMenuController().setMenuID(0);
		} else {
			if (input.matches("\\d+(\\.\\d+)?")) {
				String[] parts = input.split("\\.");

				int index = Integer.parseInt(parts[0]);

				int option = 0;
				if (parts.length > 1) {
					option = Integer.parseInt(parts[1]);
				}

				Player player = Game.getWorld().getPlayer();
				ArrayList<DefinitionEntity> list = EntityFactory.getInteractableEntitiesInRange();

				if (index <= list.size()) {
					DefinitionEntity entity = list.get(index - 1);
					int zoneId = Game.getWorld().getZoneInstanceController().getCurrentZoneID();

					if (entity.getType() == EntityType.NPC) {
						Game.getEventDispatcher().dispatch(
								new InteractWithNpcEvent(zoneId, option, player, (Npc) entity));
					} else if (entity.getType() == EntityType.OBJECT) {
						Game.getEventDispatcher().dispatch(
								new InteractWithObjectEvent(zoneId, option, player, (GameObject) entity));
					} else if (entity.getType() == EntityType.GROUND_ITEM) {
						Game.getEventDispatcher().dispatch(
								new InteractWithGroundItemEvent(zoneId, option, player, (GroundItem) entity));
					}
				}
			}
		}
	}
}
