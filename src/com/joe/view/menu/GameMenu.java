package com.joe.view.menu;

import java.util.ArrayList;

import com.joe.game.Game;
import com.joe.game.model.event.InputEvent;

public abstract class GameMenu {

	private String title;

	private ArrayList<String> menuItem = new ArrayList<>();

	public GameMenu(String title) {
		this.title = title;
	}

	public abstract void populate();
	
	public abstract void handle(InputEvent event);

	public void displayMenu() {
		menuItem.clear();
		populate();

		String menuDisplay = title + "\n";

		for (int index = 0; index < menuItem.size(); index++) {
			String item = menuItem.get(index);
			menuDisplay = menuDisplay + "\t" + item + "\n";
		}
		Game.getMenuMessageEncoder().clear();
		Game.getMenuMessageEncoder().print(menuDisplay);
	}
	
	public void addItem(String item) {
		menuItem.add(item);
	}

	public String getTitle() {
		return title;
	}
}
