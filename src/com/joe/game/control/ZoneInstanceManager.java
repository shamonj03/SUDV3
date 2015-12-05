package com.joe.game.control;

import java.util.HashMap;

import com.joe.game.model.Zone;

public class ZoneInstanceManager {
	/**
	 * A map containing instances of a zone. Caches the zones and keeps them in
	 * memory.
	 * Only loads a zone once.
	 * 
	 * TODO: Save a zone that was changed.
	 */
	private HashMap<Integer, Zone> zoneInstanceMap = new HashMap<>();

	/**
	 * Current zone that is being displayed.
	 */
	private int currentZoneID = 0;

	/**
	 * Set the current zone to be displayed.
	 * 
	 * @param id
	 *            The ID of the new zone.
	 */
	public void setCurrentZoneID(int id) {
		this.currentZoneID = id;
	}

	/**
	 * Get an instance of a zone if it is not there, create it.
	 * 
	 * @param id
	 *            The id of the zone to search for.
	 * 
	 * @return the zones instance.
	 */
	public Zone forID(int id) {
		if (!zoneInstanceMap.containsKey(id)) {
			Zone zone = new Zone(id);
			zoneInstanceMap.put(zone.getId(), zone);
		}
		return zoneInstanceMap.get(id);
	}

	/**
	 * @return the current zone.
	 */
	public Zone getCurrentZone() {
		return forID(currentZoneID);
	}

	/**
	 * @return the current zone id.
	 */
	public int getCurrentZoneID() {
		return currentZoneID;
	}

}
