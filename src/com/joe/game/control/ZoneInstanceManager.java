package com.joe.game.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.joe.game.control.stack.StackController;
import com.joe.game.io.data.ZoneData;
import com.joe.game.io.data.zone.ZoneItem;
import com.joe.game.io.data.zone.ZoneNpc;
import com.joe.game.model.Zone;
import com.joe.game.model.component.Position;
import com.joe.game.model.entity.GameObject;
import com.joe.game.model.entity.GroundItem;
import com.joe.game.model.entity.Npc;

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

	public void saveZone(int id) {
		Zone zone = forID(id);

		ZoneData data = new ZoneData(id);
		data.initialize(zone.getData().getName(), zone.getWidth(), zone.getHeight());

		for (int y = 0; y < zone.getHeight(); y++) {
			for (int x = 0; x < zone.getWidth(); x++) {
				GameObject object = zone.getGameObjectController().get(x, y);

				if (object != null) {
					data.getObjects()[y][x] = object.getGlobalID();
				}

				ArrayList<Npc> npcs = zone.getNpcController().get(x, y).getList();
				for (Npc npc : npcs) {
					Position position = npc.getComponent(Position.class);
					if (position != null) {
						ZoneNpc zoneNpc = new ZoneNpc(npc.getGlobalID(), position);
						data.getNpcs().add(zoneNpc);
					}
				}

				ArrayList<GroundItem> items = zone.getGroundItemController().get(x, y).getList();
				for (GroundItem item : items) {
					Position position = item.getComponent(Position.class);
					if (position != null) {
						ZoneItem zoneItem = new ZoneItem(item.getItem(), position);
						data.getItems().add(zoneItem);
					}
				}
			}
		}

		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		String map = gson.toJson(data);

		try (FileOutputStream fOut = new FileOutputStream(new File("./test.json"));
				OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);) {
			myOutWriter.append(map);
			myOutWriter.close();
		} catch (IOException e) {

		}
		System.out.println(map);
	}
}
