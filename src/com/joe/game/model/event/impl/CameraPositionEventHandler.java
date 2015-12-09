package com.joe.game.model.event.impl;

import com.joe.game.Game;
import com.joe.game.model.Camera;
import com.joe.game.model.EventHandler;
import com.joe.game.model.World;
import com.joe.game.model.event.CameraPositionEvent;

public class CameraPositionEventHandler extends EventHandler<CameraPositionEvent> {
	/**
	 * Move the camera to the new position.
	 */
	@Override public void handle(CameraPositionEvent event) {
		World world = Game.getWorld();
		Camera camera = world.getCamera();
		camera.getLocation().set(event.getPosition());
		world.draw();
	}

}
