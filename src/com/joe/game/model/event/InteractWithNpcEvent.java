package com.joe.game.model.event;

import com.joe.game.model.entity.Npc;

public class InteractWithNpcEvent extends InteractWithEntityEvent<Npc> {

	public InteractWithNpcEvent(int zone, Npc entity) {
		super(zone, entity);
	}

}
