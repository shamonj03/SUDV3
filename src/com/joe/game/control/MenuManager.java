package com.joe.game.control;

import com.joe.view.menu.GameMenu;

public class MenuManager {
	/**
	 * The current menuID.
	 */
	private int menuID = 0;

	/**
	 * Set the menuID.
	 * 
	 * @param menuID
	 *            The ID to change to.
	 */
	public void setMenuID(int menuID) {
		this.menuID = menuID;
		this.draw();
	}

	/**
	 * Draw the current menu.
	 */
	public void draw() {
		getVisibleMenu().displayMenu();
	}

	/**
	 * @return the current menu.
	 */
	public GameMenu getVisibleMenu() {
		return MenuDefinition.forID(menuID);
	}

	/**
	 * @return the current menu ID.
	 */
	public int getMenuID() {
		return menuID;
	}
}
