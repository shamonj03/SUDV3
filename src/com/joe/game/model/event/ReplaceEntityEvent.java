package com.joe.game.model.event;

import com.joe.game.model.DefinitionEntity;

public class ReplaceEntityEvent<T extends DefinitionEntity> extends Event {

	private final int zoneID;

	private final T entitiy;
	
	private final int newID;

	public ReplaceEntityEvent(int zoneID, T entitiy, int newID) {
		this.zoneID = zoneID;
		this.entitiy = entitiy;
		this.newID = newID;
	}
	
	public int getZoneID() {
		return zoneID;
	}

	public T getEntitiy() {
		return entitiy;
	}

	public int getNewID() {
		return newID;
	}

}
