package com.joe.game.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonStreamParser;
import com.joe.game.io.data.ComponentData;

public class OnDemandDataFetcher {

	/**
	 * Maps of the unique id of the data file to the file object.
	 */
	private HashMap<Integer, File> fileMap;

	/**
	 * Folder containing the data.
	 */
	private String folderPath;

	/**
	 * Create a new fetcher that pulls data from a specified file in the folder.
	 * 
	 * @param folderPath
	 *            Folder containing the data.
	 */
	public OnDemandDataFetcher(String folderPath) {
		this.folderPath = folderPath;
	}

	/**
	 * Fetch data for the unique id.
	 * 
	 * @param id
	 *            Unique id to fetch data for.
	 * 
	 * @return data for the unique id.
	 */
	public ComponentData fetch(int id) {
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
			data = gson.fromJson(parser.next(), ComponentData.class);
			return data;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * If the fileMap is not instantiated quickly
	 * put all the files to their respective unique id.
	 * 
	 * File Name Format: index_fileName.json
	 */
	private void populateFileMap() {
		if (fileMap == null) {
			fileMap = new HashMap<>();

			File folder = new File(folderPath);
			File[] files = folder.listFiles();

			for (File file : files) {
				String name = file.getName();
				if (name.endsWith(".json")) {
					String[] parts = name.split("_");

					int index = Integer.parseInt(parts[0]);

					fileMap.put(index, file);
				}
			}
		}
	}

	/**
	 * @returnGet the folder of the data path.
	 */
	public String getFolder() {
		return folderPath;
	}
}
