package com.joe.game.model.event.impl;

import com.joe.game.Game;
import com.joe.game.control.MenuDefinition;
import com.joe.game.model.EventHandler;
import com.joe.game.model.Item;
import com.joe.game.model.ItemContainer;
import com.joe.game.model.entity.Player;
import com.joe.game.model.event.UnequipItemEvent;

public class UnequipItemEventHandler extends EventHandler<UnequipItemEvent> {

	@Override public void handle(UnequipItemEvent event) {
		int slot = event.getSlot();

		Player player = Game.getWorld().getPlayer();
		ItemContainer equipment = player.getEquipment();
		ItemContainer inventory = player.getInventory();

		if (!inventory.isFull() && equipment.getItem(slot) != null) {
			Item item = equipment.getItem(slot);
			equipment.setSlot(slot, null);
			inventory.addItem(item.getId(), item.getAmount());
		}
		
		if(Game.getMenuController().getMenuID() == 3) {
			Game.getMenuController().draw();
		}
	}

}
