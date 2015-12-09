package com.joe.game.model.event;

import com.joe.game.model.entity.GameObject;
import com.joe.game.model.entity.Npc;

public class ReplaceNpcEvent extends ReplaceEntityEvent<Npc> {

	public ReplaceNpcEvent(int zoneID, Npc entitiy, int newID) {
		super(zoneID, entitiy, newID);
	}

}
