package com.joe.game.model.event.impl;

import com.joe.game.Game;
import com.joe.game.control.EntityFactory;
import com.joe.game.model.EventHandler;
import com.joe.game.model.Zone;
import com.joe.game.model.component.Position;
import com.joe.game.model.entity.GameObject;
import com.joe.game.model.event.ReplaceObjectEvent;

public class ReplaceObjectEventHandler extends EventHandler<ReplaceObjectEvent> {

	@Override public void handle(ReplaceObjectEvent event) {
		final GameObject object = event.getEntitiy();
		final int newID = event.getNewID();
		final int zoneID = event.getZoneID();
		
		final Position position = object.getComponent(Position.class);
		
		if(position != null) {
			GameObject newObject = EntityFactory.createGameObject(newID, position);
			Zone zone = Game.getWorld().getZoneInstanceController().forID(zoneID);
			zone.getGameObjectController().set(position, newObject);
			Game.redraw();
		}
	}

}
