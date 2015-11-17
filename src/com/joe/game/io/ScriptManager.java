package com.joe.game.io;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import org.python.core.Py;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import com.joe.game.model.Event;

public class ScriptManager {

	private static final String SCRIPT_FOLDER = "./data/scripts/";

	private static final PythonInterpreter interp = new PythonInterpreter();

	public static void loadScripts() {
		loadScripts(new File(SCRIPT_FOLDER));
	}

	public static void loadScripts(File folder) {
		for (File file : folder.listFiles()) {
			String name = file.getName();

			if (file.isFile()) {
				if (name.endsWith(".py")) {
					interp.execfile(file.getPath());
				}
			} else {
				if (file.isDirectory()) {
					loadScripts(file);
				}
			}
		}
	}
}