package com.joe.game.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonStreamParser;
import com.google.gson.JsonSyntaxException;
import com.joe.game.io.data.Data;

public class CachedDefinition<T extends Data> {
	/**
	 * Map containing all the data.
	 */
	private HashMap<Integer, T> dataMap = new HashMap<>();

	/**
	 * Load all the data into memory.
	 * 
	 * @param path
	 *            Path to json file.
	 * @param type
	 *            The type of class were loading.
	 */
	public CachedDefinition(String path, Class<T> type) {
		try {
			File file = new File(path);

			Gson g = new Gson();

			JsonStreamParser parser = new JsonStreamParser(new FileReader(file));
			while (parser.hasNext()) {
				T data = g.fromJson(parser.next(), type);
				dataMap.put(data.getID(), data);
			}
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param id
	 *            The id in the map.
	 * @return the instance of T.
	 */
	public T forID(int id) {
		return (T) dataMap.get(id);
	}
}
