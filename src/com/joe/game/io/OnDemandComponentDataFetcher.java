package com.joe.game.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonStreamParser;
import com.joe.game.io.data.ComponentData;

public class OnDemandComponentDataFetcher extends OnDemandDataFetcher<ComponentData> {
	/**
	 * Fetches data on demand. Does not cache data.
	 * 
	 * @param folderPath
	 *            Path to folder of data.
	 */
	public OnDemandComponentDataFetcher(String folderPath) {
		super(folderPath, ComponentData.class);
	}

	/**
	 * Fetch data for the unique id.
	 * 
	 * @param id
	 *            Unique id to fetch data for.
	 * 
	 * @return data for the unique id.
	 */
	@Override public ComponentData forId(int id) {
		ComponentData data = null;

		GsonBuilder builder = new GsonBuilder();
		builder = new GsonBuilder();
		builder.registerTypeAdapter(ComponentData.class, new DataComponentAdapter());
		Gson gson = builder.create();

		populateFileMap();

		try {
			File file = fileMap.get(id);
			JsonStreamParser parser;
			parser = new JsonStreamParser(new FileReader(file));
			data = gson.fromJson(parser.next(), type);
			return data;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return data;
	}
}
