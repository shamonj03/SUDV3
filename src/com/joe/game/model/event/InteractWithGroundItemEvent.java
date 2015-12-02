package com.joe.game.model.event;

import com.joe.game.model.entity.GroundItem;

public class InteractWithGroundItemEvent extends InteractWithEntityEvent<GroundItem> {

	public InteractWithGroundItemEvent(int zone, GroundItem entity) {
		super(zone, entity);
	}

}
