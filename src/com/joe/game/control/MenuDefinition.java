package com.joe.game.control;

import java.util.HashMap;

import com.joe.view.menu.EntityMenu;
import com.joe.view.menu.EquipmentMenu;
import com.joe.view.menu.GameMenu;
import com.joe.view.menu.InventoryMenu;
import com.joe.view.menu.MainMenu;

public class MenuDefinition {

	/**
	 * The map of menus.
	 */
	private static HashMap<Integer, GameMenu> dataMap = new HashMap<>();

	/**
	 * Initialize the menus.
	 */
	static {
		dataMap.put(0, new MainMenu());
		dataMap.put(1, new EntityMenu());
		dataMap.put(2, new InventoryMenu());
		dataMap.put(3, new EquipmentMenu());
	}

	/**
	 * @param id
	 *            The menu ID.
	 * @return the menu for the ID.
	 */
	public static GameMenu forID(int id) {
		return dataMap.get(id);
	}
}
