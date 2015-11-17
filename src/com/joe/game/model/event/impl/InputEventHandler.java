package com.joe.game.model.event.impl;

import com.joe.game.Game;
import com.joe.game.control.event.EventController;
import com.joe.game.model.EventHandler;
import com.joe.game.model.event.CommandEvent;
import com.joe.game.model.event.InputEvent;
import com.joe.game.model.event.MessageEvent;

public class InputEventHandler extends EventHandler<InputEvent> {

	@Override public void handle(InputEvent event) {
		String message = event.getInput();

		if (message.startsWith("::")) {
			EventController.sendEvent(new CommandEvent(message));
			return;
		}
		Game.getGameMessageEncoder().streamLine(message);
	}

}
