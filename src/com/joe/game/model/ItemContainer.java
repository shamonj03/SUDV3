package com.joe.game.model;

import com.joe.game.io.DataManager;
import com.joe.game.io.data.ItemData;

public class ItemContainer {

	/**
	 * Max capacity this container can hold.
	 */
	private int capacity;

	private int size;

	/**
	 * List of items in this container.
	 */
	private Item[] items;

	/**
	 * Create a new item container.
	 * 
	 * @param capacity
	 *            Max capacity this container can hold.
	 */
	public ItemContainer(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		this.items = new Item[capacity];
	}

	/**
	 * Set the slot in the container to an item with an amount.
	 * 
	 * @param slot
	 *            Slot to set.
	 * @param id
	 *            Id of item.
	 * @param amount
	 *            Amount to set to.
	 */
	public void setSlot(int slot, int id, int amount) {
		setSlot(slot, new Item(id, amount));
	}

	/**
	 * Set the slot in the container to an item
	 * 
	 * @param item
	 *            THe item to set to.
	 * @param amount
	 *            Amount to set to.
	 */
	public void setSlot(int slot, Item item) {
		items[slot] = item;
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
			int slot = getSlot(id);

			if (slot == -1) {
				if (hasRoom(1)) {
					return false;
				}
				int nextSlot = getNextOpenSlot();

				setSlot(nextSlot, id, amount);
				size++;
			} else {
				items[slot].offsetAmount(amount);
			}
		} else {
			if (hasRoom(amount)) {
				return false;
			}
			for (int amt = 0; amt < amount; amt++) {
				int nextSlot = getNextOpenSlot();

				setSlot(nextSlot, id, 1);
				size++;
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
		int slot = getSlot(id);

		if (slot == -1) {
			return false;
		}

		Item item = items[slot];
		ItemData data = item.getData();

		if (data.isStackable()) {
			int amt = item.getAmount() - amount;

			if (amt <= 0) {
				items[slot] = null;
				size--;
			} else {
				item.offsetAmount(-amount);
			}
		} else {
			for (int amt = 0; amt < amount; amt++) {
				if (slot == -1) {
					return false;
				}
				items[slot] = null;
				size--;
				slot = getSlot(id);
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
			return items[slot] != null ? items[slot] : null;
			//throw new IndexOutOfBoundsException("Slot " + slot + " is not within current container size " + getSize() 	+ ".");
		}
		throw new IndexOutOfBoundsException("Slot " + slot + " is outside containers capacity " + capacity + ".");
	}

	public int getNextOpenSlot() {
		for (int index = 0; index < capacity; index++) {
			if (items[index] == null) {
				return index;
			}
		}
		return -1;
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
		for (int index = 0; index < capacity; index++) {
			Item item = items[index];
			if (item == null) {
				continue;
			}

			if (item.getId() == id) {
				return index;
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

		for (int index = 0; index < capacity; index++) {
			Item item = items[index];
			if (item == null) {
				continue;
			}

			if (item.getId() == id) {
				found = found + item.getAmount();
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
		return size;
	}

	public boolean isFull() {
		return size > capacity;
	}

	public boolean hasRoom(int amount) {
		return size + amount > capacity;
	}

	@Override public String toString() {
		String s = "ItemContainer:\n";
		for (Item item : items) {
			if (item == null) {
				continue;
			}
			s = s + "\t" + item + "\n";
		}
		return s;
	}
}
