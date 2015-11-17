package com.joe.game.model.event.impl;

import com.joe.game.Game;
import com.joe.game.control.event.EventController;
import com.joe.game.model.EventHandler;
import com.joe.game.model.event.MessageEvent;

public class MessageEventHandler extends EventHandler<MessageEvent> {

	@Override public void handle(MessageEvent event) {
		String message = event.getMessage();

		Game.getGameMessageEncoder().streamLine(message);
		
	}

}
