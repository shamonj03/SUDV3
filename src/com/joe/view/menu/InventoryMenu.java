package com.joe.view.menu;

import com.joe.game.Game;
import com.joe.game.model.Item;
import com.joe.game.model.ItemContainer;
import com.joe.game.model.component.InteractOptions;
import com.joe.game.model.component.ItemSettings;
import com.joe.game.model.component.Name;
import com.joe.game.model.entity.Player;
import com.joe.game.model.event.EquipItemEvent;
import com.joe.game.model.event.InputEvent;

public class InventoryMenu extends GameMenu {

	public InventoryMenu() {
		super("Inventroy");
	}

	@Override public void populate() {
		Player player = Game.getWorld().getPlayer();
		ItemContainer inventory = player.getInventory();

		int pos = 1;

		for (int slot = 0; slot < inventory.getCapacity(); slot++) {
			Item item = inventory.getItem(slot);

			if (item == null) {
				continue;
			}

			Name name = item.getData().getComponent(Name.class);
			if (name != null) {
				addItem(pos + ": " + name.getName() + " x " + item.getAmount());
			}

			InteractOptions interact = item.getData().getComponent(InteractOptions.class);

			if (interact != null) {
				String[] options = interact.getOptions();

				for (int index = 0; index < options.length; index++) {
					String option = options[index];
					addItem("\t" + pos + "." + index + ": " + option);
				}
			}
			pos++;
		}
		addItem("0: Exit");
	}

	@Override public void handle(InputEvent event) {
		String input = event.getInput();

		if (input.equals("0")) {
			Game.getMenuController().setMenuID(0);
		} else if (input.matches("\\d+(\\.\\d+)?")) {
			String[] parts = input.split("\\.");

			int index = Integer.parseInt(parts[0]);

			int option = 0;
			if (parts.length > 1) {
				option = Integer.parseInt(parts[1]);
			}

			Player player = Game.getWorld().getPlayer();
			ItemContainer inventory = player.getInventory();

			int pos = 1;

			for (int slot = 0; slot < inventory.getCapacity(); slot++) {
				Item item = inventory.getItem(slot);

				if (item == null) {
					continue;
				}

				if (pos == index) {
					InteractOptions interact = item.getData().getComponent(InteractOptions.class);
					String opt = interact.getOption(option);

					if (opt.equalsIgnoreCase("equip")) {
						Game.getEventDispatcher().dispatch(new EquipItemEvent(item));
					}
					return;
				}
				pos++;
			}
		}
	}

}
