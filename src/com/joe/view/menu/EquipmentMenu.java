package com.joe.view.menu;

import com.joe.game.Game;
import com.joe.game.model.EquipmentSlot;
import com.joe.game.model.Item;
import com.joe.game.model.ItemContainer;
import com.joe.game.model.component.InteractOptions;
import com.joe.game.model.component.ItemSettings;
import com.joe.game.model.component.Name;
import com.joe.game.model.entity.Player;
import com.joe.game.model.event.InputEvent;
import com.joe.game.model.event.UnequipItemEvent;

public class EquipmentMenu extends GameMenu {

	public EquipmentMenu() {
		super("Equipment");
	}

	@Override public void populate() {
		Player player = Game.getWorld().getPlayer();
		ItemContainer equipment = player.getEquipment();

		for (int i = 0; i < equipment.getCapacity(); i++) {
			Item item = equipment.getItem(i);

			if (item == null) {
				EquipmentSlot slot = EquipmentSlot.values()[i + 1];
				addItem(slot + ": Empty");
				continue;
			}

			Name name = item.getData().getComponent(Name.class);
			if (name != null) {
				ItemSettings settings = item.getData().getComponent(ItemSettings.class);
				
				if(settings != null) {
					addItem(settings.getEquipmentSlot() + ": " + name.getName() + " x " + item.getAmount());
				}
			}
			addItem("\t" + (i + 1) + ".0: Unequip");
		}

		addItem("0: Exit");
	}

	@Override public void handle(InputEvent event) {
		String input = event.getInput();

		if (input.equals("0")) {
			Game.getMenuController().setMenuID(0);
		} else {
			if (input.matches("\\d+(\\.\\d+)?")) {
				String[] parts = input.split("\\.");

				int index = Integer.parseInt(parts[0]) - 1;

				int option = 0;
				if (parts.length > 1) {
					option = Integer.parseInt(parts[1]);
				}
				
				Game.getEventDispatcher().dispatch(new UnequipItemEvent(index));

				/*Player player = Game.getWorld().getPlayer();
				ItemContainer equipment = player.getEquipment();
				
				Item item = equipment.getItem(index - 1);
				System.out.println(item);*/
			}
		}
	}

}
