package com.joe.game.model.event.impl;

import com.joe.game.Game;
import com.joe.game.io.data.ItemData;
import com.joe.game.model.EquipmentSlot;
import com.joe.game.model.EventHandler;
import com.joe.game.model.Item;
import com.joe.game.model.ItemContainer;
import com.joe.game.model.entity.Player;
import com.joe.game.model.event.EquipItemEvent;

public class EquipItemEventHandler extends EventHandler<EquipItemEvent> {

	@Override public void handle(EquipItemEvent event) {
		Item item = event.getItem();

		Player player = Game.getWorld().getPlayer();
		ItemContainer equipment = player.getEquipment();
		ItemContainer inventory = player.getInventory();

		EquipmentSlot equipmentSlot = item.getData().getEquipmentSlot();
		int slot = equipmentSlot.getSlot() - 1;

		Item currentSlotItem = equipment.getItem(slot);

		if (currentSlotItem == null) {
			inventory.remove(item.getId(), item.getAmount());
			equipment.setSlot(slot, item);
		} else {
			ItemData currentItemData = currentSlotItem.getData();

			if (currentSlotItem.getId() == item.getId()) {
				if (currentItemData.isStackable()) {
					inventory.remove(item.getId(), item.getAmount());
					currentSlotItem.offsetAmount(item.getAmount());
				} else {
					if (inventory.isFull()) {
						return;
					}
					inventory.remove(item.getId(), item.getAmount());
					inventory.addItem(currentSlotItem.getId(), currentSlotItem.getAmount());
					equipment.setSlot(slot, item);
				}
			}
		}
	}

}
