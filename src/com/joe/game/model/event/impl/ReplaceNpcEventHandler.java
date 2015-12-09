package com.joe.game.model.event.impl;

import com.joe.game.Game;
import com.joe.game.control.EntityFactory;
import com.joe.game.model.EventHandler;
import com.joe.game.model.Zone;
import com.joe.game.model.component.Position;
import com.joe.game.model.entity.GameObject;
import com.joe.game.model.entity.Npc;
import com.joe.game.model.event.ReplaceNpcEvent;
import com.joe.game.model.event.ReplaceObjectEvent;

public class ReplaceNpcEventHandler extends EventHandler<ReplaceNpcEvent> {

	@Override public void handle(ReplaceNpcEvent event) {
		final Npc npc = event.getEntitiy();
		final int newID = event.getNewID();
		final int zoneID = event.getZoneID();
		
		final Position position = npc.getComponent(Position.class);
		
		if(position != null) {
			Npc newNpc = EntityFactory.createNpc(newID, position);
			Zone zone = Game.getWorld().getZoneInstanceController().forID(zoneID);
			zone.getNpcController().get(position).unregister(npc);
			zone.getNpcController().get(position).register(newNpc);
			Game.redraw();
		}
	}

}
