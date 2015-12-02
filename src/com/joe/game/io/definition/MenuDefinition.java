package com.joe.game.io.definition;

import java.util.HashMap;

import com.joe.view.menu.EntityMenu;
import com.joe.view.menu.GameMenu;
import com.joe.view.menu.MainMenu;

public class MenuDefinition {

	private static HashMap<Integer, GameMenu> dataMap = new HashMap<>();
	
	static {
		dataMap.put(0, new MainMenu());
		dataMap.put(1, new EntityMenu());
	}
	
	public static GameMenu forId(int id) {
		return dataMap.get(id);
	}
}
