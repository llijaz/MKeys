package skriptinglan;

import java.util.ArrayList;

import hotkey.Execute;

public class Compiler {

	public static String loadSkript(final String path) {
		String skript = Execute.LoadStringFromFile(path);

		return skript;
	}

	public static ArrayList<String> fromCodeToList(String code) {
		ArrayList<String> list = new ArrayList<>();

		String[] lineseparated = code.split(System.lineSeparator());

		for (String line : lineseparated) {
			for (int charindex = 0; charindex < line.length(); charindex++) {
				list.add(String.valueOf(line.charAt(charindex)));
			}
		}

		return list;
	}

	public static ArrayList<String> combineList(ArrayList<String> code) {
		ArrayList<String> list = new ArrayList<>();

		String combine = "";

		for (int i = 0; i < code.size(); i++) {
			char ch = code.get(i).charAt(0);

			if (combine.isEmpty()) {
				if (isAlphabetical(ch)) {
					combine += ch;
				} else {
					if (ch != ' ') {
						list.add(String.valueOf(ch));
					}
				}
			} else {
				if (isAlphabetical(ch)) {
					combine += ch;
				} else {
					list.add(combine);

					combine = "";
				}
			}
		}

		return list;
	}

	/**
	public static ArrayList<Instructions> fromListToInstructions(ArrayList<String> list) {
		ArrayList<Instructions> instructions = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			String currentString = list.get(i);

			for (Instructions instruction : Instructions.instructions) {
				if (instruction.compare(currentString)) {
					instructions.add(instruction);
				}
			}
		}

		return instructions;
	}
	 **/

	private static boolean isAlphabetical(char ch) {
		if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9') || ch == '_') {
			return true;
		}

		return false;
	}

}
