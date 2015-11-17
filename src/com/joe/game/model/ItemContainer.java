package com.joe.game.model;

import java.util.ArrayList;

import com.joe.game.io.DataManager;
import com.joe.game.io.data.ItemData;

public class ItemContainer {

	/**
	 * Max capacity this container can hold.
	 */
	private int capacity;

	/**
	 * List of items in this container.
	 */
	private ArrayList<Item> items;

	/**
	 * Create a new item container.
	 * 
	 * @param capacity
	 *            Max capacity this container can hold.
	 */
	public ItemContainer(int capacity) {
		this.capacity = capacity;
		this.items = new ArrayList<>(capacity);
	}

	/**
	 * Set the slot in the contianer to an item with an amount.
	 * 
	 * @param slot
	 *            Slot to set.
	 * @param id
	 *            Id of item.
	 * @param amount
	 *            Amount to set to.
	 */
	public void setSlot(int slot, int id, int amount) {
		items.set(slot, new Item(id, amount));
	}

	/**
	 * Add an item to the container.
	 * 
	 * @param id
	 *            Id of item.
	 * @param amount
	 *            Amount to add.
	 * 
	 * @return false if was unable to add.
	 */
	public boolean addItem(int id, int amount) {
		ItemData data = DataManager.getItemDefinition().forId(id);

		if (data.isStackable()) {
			if ((getSize() + 1) > capacity) {
				return false;
			}
			int slot = getSlot(id);
			boolean contiansItem = slot != -1;

			if (contiansItem) {
				Item currentItem = items.get(slot);
				currentItem.offsetAmount(amount);
			} else {
				items.add(new Item(id, amount));
			}
		} else {
			if ((getSize() + amount) > capacity) {
				return false;
			}
			for (int i = 0; i < amount; i++) {
				items.add(new Item(id, 1));
			}
		}
		return true;
	}

	/**
	 * Remove an item to the container.
	 * 
	 * @param id
	 *            Id of item.
	 * @param amount
	 *            Amount to remove.
	 * 
	 * @return false if was unable to find item.
	 */
	public boolean remove(int id, int amount) {
		ItemData data = DataManager.getItemDefinition().forId(id);

		if (data.isStackable()) {
			int slot = getSlot(id);

			if (slot == -1) {
				return false;
			}

			Item slotItem = items.get(slot);
			int newAmount = slotItem.getAmount() - amount;

			if (newAmount > 0) {
				slotItem.setAmount(newAmount);
			} else {
				items.remove(slot);
			}
		} else {
			for (int i = 0; i < amount; i++) {
				int slot = getSlot(id);

				if (slot == -1) {
					break;
				}
				items.remove(slot);
			}
		}
		return true;
	}

	/**
	 * Get the item at a current slot.
	 * 
	 * @param slot
	 *            The slot the item is in.
	 * 
	 * @return the item if it is within the capacity and within the current size
	 *         of the container.
	 */
	public Item getItem(int slot) {
		if (slot < capacity) {
			if (slot < getSize()) {
				return items.get(slot);
			}
			throw new IndexOutOfBoundsException("Slot " + slot + " is not within current container size " + getSize()
					+ ".");
		}
		throw new IndexOutOfBoundsException("Slot " + slot + " is outside containers capacity " + capacity + ".");
	}

	/**
	 * Get the slot an item is at.
	 * 
	 * @param id
	 *            The id of the item to look for.
	 * 
	 * @return the slot if the item exists else -1.
	 */
	public int getSlot(int id) {
		for (int slot = 0; slot < getSize(); slot++) {
			Item currentItem = items.get(slot);

			if (currentItem.getId() == id) {
				return slot;
			}
		}
		return -1;
	}

	/**
	 * Find a specified amount of an item.
	 * 
	 * @param id
	 *            The id of the item to look for.
	 * @param amount
	 *            The amount required.
	 * 
	 * @return true if the amount of item is found.
	 */
	public boolean containsAmount(int id, int amount) {
		int found = 0;

		for (int slot = 0; slot < getSize(); slot++) {
			Item currentItem = items.get(slot);

			if (currentItem.getId() == id) {
				found += currentItem.getAmount();
			}
		}
		return found >= amount;
	}

	/**
	 * Checks if the item id is apart of the container.
	 * 
	 * @param id
	 *            The id of the item to look for.
	 * 
	 * @return true if item exists.
	 */
	public boolean containsItem(int id) {
		return getSlot(id) != -1;
	}

	/**
	 * @return the capacity of the container.
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @return the amount of items currently in the container.
	 */
	public int getSize() {
		return items.size();
	}
}
