package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import tasks.Task;

public class Lua {

	public static void execute(String path, String inputstring, boolean[] keys, boolean mode) {
		String command = "lua Hotkey.lua \"" + path + "\" \"" + inputstring + "\" \"";
		
		for (int i = 0; i < HotkeyListener.keys.length; i++) {
			if (HotkeyListener.keys[i]) {
				command += "1";
			} else {
				command += "0";
			}
		}
		
		command += "\"";
		
		try {
			Process process = Runtime.getRuntime().exec(command);

			readInput(process, mode);
			readErr(process, mode);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void readInput(Process process, boolean mode) throws IOException {
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line = null;

		while ((line = br.readLine()) != null) {
			Task.doTask(line, mode);
		}
	}

	static void readErr(Process process, boolean mode) throws IOException {
		InputStream is = process.getErrorStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line = null;

		while ((line = br.readLine()) != null) {
			System.err.println(line);
		}
	}

}
