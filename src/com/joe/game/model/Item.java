package com.joe.game.model;

import com.joe.game.io.DataManager;
import com.joe.game.io.data.ItemData;

public class Item {
	/**
	 * Id of item from the definition.
	 */
	private final int id;

	/**
	 * Amount of item.
	 */
	private int amount;

	/**
	 * Create a new item.
	 * 
	 * @param id
	 *            Id of item from the definition.
	 * @param amount
	 *            The amount of the item.
	 */
	public Item(int id, int amount) {
		this.id = id;
		this.amount = amount;
	}

	/**
	 * @return the data pertaining to the item.
	 */
	public ItemData getData() {
		return DataManager.getItemDefinition().forID(id);
	}

	/**
	 * Offset the items amount.
	 * 
	 * @param offset
	 *            Amount to change.
	 */
	public void offsetAmount(int offset) {
		this.amount += offset;
	}

	/**
	 * Set the amount.
	 * 
	 * @param amount
	 *            The new amount.
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return id of item from the definition.
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the amount of item.
	 */
	public int getAmount() {
		return amount;
	}
	
	@Override public String toString() {
		return "Item(ID: " + id + ", Amount: " + amount + ", Data:[" + getData() + "])";
	}
}
