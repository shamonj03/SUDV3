package com.joe.game.model.event;

import com.joe.game.model.entity.GameObject;

public class ReplaceObjectEvent extends ReplaceEntityEvent<GameObject> {

	public ReplaceObjectEvent(int zoneID, GameObject entitiy, int newID) {
		super(zoneID, entitiy, newID);
	}

}
