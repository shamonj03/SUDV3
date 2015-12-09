package com.joe.game.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonStreamParser;
import com.joe.game.io.data.Data;

public class OnDemandDataFetcher<T extends Data> {
	
	protected static final GsonBuilder builder = new GsonBuilder();

	/**
	 * Maps of the unique id of the data file to the file object.
	 */
	protected HashMap<Integer, File> fileMap;

	/**
	 * Folder containing the data.
	 */
	protected String folderPath;

	/**
	 * Class type of the data.
	 */
	protected Class<T> type;

	/**
	 * Create a new fetcher that pulls data from a specified file in the folder.
	 * 
	 * @param folderPath
	 *            Folder containing the data.
	 * @param type
	 *            Class type of the data.
	 */
	public OnDemandDataFetcher(String folderPath, Class<T> type) {
		this.folderPath = folderPath;
		this.type = type;
		this.populateFileMap();
	}

	/**
	 * Fetch data for the unique id.
	 * 
	 * @param id
	 *            Unique id to fetch data for.
	 * 
	 * @return data for the unique id.
	 */
	public T forID(int id) {
		T data = null;

		Gson gson = builder.create();

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

	/**
	 * If the fileMap is not instantiated quickly
	 * put all the files to their respective unique id.
	 * 
	 * File Name Format: index_fileName.json
	 */
	protected void populateFileMap() {
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
