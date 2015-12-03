package com.joe.game.model.event.impl;

import com.joe.game.Game;
import com.joe.game.model.EventHandler;
import com.joe.game.model.event.DrawGameScreenEvent;

public class DrawGameScreenEventHandler extends EventHandler<DrawGameScreenEvent> {

	@Override public void handle(DrawGameScreenEvent event) {
		Game.getWorld().draw();
		Game.getMenuController().draw();
	}

}
