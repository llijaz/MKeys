package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import me.bleuzen.javux.Javux;
import me.bleuzen.javux.ProcessResult;
import me.bleuzen.javux.Script;
import me.bleuzen.javux.ScriptInterpreter;
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
			if(Javux.isLinux) {
				Script script = new Script(ScriptInterpreter.SH);
				script.addLine(command);

				ProcessResult result = script.exec();

				// TODO: add wait

				String output = result.getOutput();

				readInputSH(output, mode);

				if (result.getExitCode() == 1) {
					readErrSH(output);
				}
			} else {
				Process process = Runtime.getRuntime().exec(command);

				readInputJava(process, mode);
				readErrJava(process);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void readInputJava(Process process, boolean mode) throws IOException {
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line = null;

		while ((line = br.readLine()) != null) {
			Task.doTask(line, mode);
		}
	}

	static void readErrJava(Process process) throws IOException {
		InputStream is = process.getErrorStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line = null;

		while ((line = br.readLine()) != null) {
			System.err.println(line);
		}
	}

	static void readInputSH(String output, boolean mode) {
		String[] lines = output.split(System.lineSeparator());

		for (String line : lines) {
			Task.doTask(line, mode);
		}
	}

	static void readErrSH(String output) {
		String[] linesArray = output.split(System.lineSeparator());

		ArrayList<String> lines = new ArrayList<>();

		for (String line : linesArray) {
			lines.add(line);
		}

		for (int i = 0; i < lines.size(); i++) {
			for (Task task : Task.tasks) {
				if (lines.get(i).startsWith(task.name())) {
					lines.remove(i);
					i--;
					break;
				}
			}
		}

		String error = "";

		for (String line : lines) {
			error += line + System.lineSeparator();
		}

		System.err.print(error);
	}

}
