package com.joe.game.model.event.impl;

import com.joe.game.Game;
import com.joe.game.model.EventHandler;
import com.joe.game.model.event.InputEvent;

public class InputEventHandler extends EventHandler<InputEvent> {

	@Override public void handle(InputEvent event) {
		Game.getGameMessageEncoder().streamLine(event.getInput());
	}

}
