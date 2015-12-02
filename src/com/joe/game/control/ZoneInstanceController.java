package com.joe.game.control;

import java.util.HashMap;

import com.joe.game.model.Zone;

public class ZoneInstanceController {

	private HashMap<Integer, Zone> zoneMap = new HashMap<>();

	private int currentZoneID = 0;
	
	public void setCurrentZoneID(int id) {
		this.currentZoneID = id;
	}

	public Zone forID(int id) {
		if (!zoneMap.containsKey(id)) {
			Zone zone = new Zone(id);
			register(zone);
		}
		return zoneMap.get(id);
	}

	private void register(Zone zone) {
		zoneMap.put(zone.getId(), zone);
	}

	public Zone getCurrentZone() {
		return forID(currentZoneID);
	}

	public int getCurrentZoneID() {
		return currentZoneID;
	}

}
