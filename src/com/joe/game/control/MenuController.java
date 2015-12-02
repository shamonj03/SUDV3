package com.joe.game.control;

import com.joe.game.io.definition.MenuDefinition;
import com.joe.view.menu.GameMenu;

public class MenuController {

	private int menuID = 0;

	public void setMenuID(int menuID) {
		this.menuID = menuID;
		this.draw();
	}

	public void draw() {
		getVisibleMenu().displayMenu();
	}

	public int getMenuID() {
		return menuID;
	}

	public GameMenu getVisibleMenu() {
		return MenuDefinition.forId(menuID);
	}
}
