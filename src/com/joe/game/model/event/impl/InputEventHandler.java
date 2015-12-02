package com.joe.game.model.event.impl;

import com.joe.game.Game;
import com.joe.game.model.EventHandler;
import com.joe.game.model.event.CommandEvent;
import com.joe.game.model.event.InputEvent;
import com.joe.view.menu.GameMenu;

public class InputEventHandler extends EventHandler<InputEvent> {

	@Override public void handle(InputEvent event) {
		String message = event.getInput();

		if (message.startsWith("::")) {
			Game.getEventController().sendEvent(new CommandEvent(message));
			return;
		} else {
			GameMenu menu = Game.getMenuController().getVisibleMenu();
			menu.handle(event);
		}
	}

}
