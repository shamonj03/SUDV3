package com.joe.game.io;

import java.io.File;

import org.python.util.PythonInterpreter;

import com.joe.util.Constants;

public class ScriptManager {
	/**
	 * Instance of Jython Interpreter.
	 */
	private static final PythonInterpreter interpreter = new PythonInterpreter();

	/**
	 * Load the scripts in the root script folder.
	 */
	public static void loadScripts() {
		loadScripts(new File(Constants.SCRIPT_FOLDER));
	}

	/**
	 * Load all scripts in a folder. This method makes a recursive call for
	 * subfolders.
	 * 
	 * @param folder
	 *            The folder to load.
	 */
	private static void loadScripts(File folder) {
		for (File file : folder.listFiles()) {
			String name = file.getName();

			if (file.isFile()) {
				if (name.endsWith(".py")) {
					interpreter.execfile(file.getPath());
				}
			} else {
				if (file.isDirectory()) {
					loadScripts(file);
				}
			}
		}
	}
}
