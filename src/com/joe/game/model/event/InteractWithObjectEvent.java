package com.joe.game.model.event;

import com.joe.game.model.entity.GameObject;

public class InteractWithObjectEvent extends InteractWithEntityEvent<GameObject> {

	public InteractWithObjectEvent(int zone, GameObject entity) {
		super(zone, entity);
	}

}
