package com.joe.game.model.event.impl;

import com.joe.game.Game;
import com.joe.game.model.Direction;
import com.joe.game.model.Entity;
import com.joe.game.model.EntityType;
import com.joe.game.model.EventHandler;
import com.joe.game.model.Zone;
import com.joe.game.model.component.Position;
import com.joe.game.model.component.WorldSettings;
import com.joe.game.model.entity.GameObject;
import com.joe.game.model.event.MovementEvent;

public class MovementEventHandler extends EventHandler<MovementEvent> {
	/**
	 * Move an entity in a direction if it can.
	 */
	@Override public void handle(MovementEvent event) {
		Direction direction = event.getDirection();
		Entity entity = event.getEntity();

		Position position = entity.getComponent(Position.class);
		if (position != null) {

			position.advance(direction);

			Zone zone = Game.getWorld().getZoneInstanceController().getCurrentZone();
			GameObject object = zone.getGameObjectController().get(position);

			WorldSettings settings = object.getComponent(WorldSettings.class);
			if (settings != null && settings.isSolid()) {
				position.retreat(direction);
			}

			if (entity.getType() == EntityType.PLAYER) {
				Game.getWorld().getCamera().getLocation().set(position);
			}

			zone.printPartialZone();
		}
	}

}
