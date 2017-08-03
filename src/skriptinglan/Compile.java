package skriptinglan;

import java.util.ArrayList;

import hotkey.Execute;
import hotkey.Hotkey;
import hotkey.Hotkeys;
import tasks.Task;

public class Compile {

	public static void compileSkript(final String path) {
		// Loading the document

		String skript = Execute.LoadStringFromFile(path);

		// Compiling the script

		compile(skript);
	}

	public static void compile(final String str) {
		// Sorts from string to arraylist array.

		ArrayList<String>[] sorted = getSortedList(str);

		Hotkey hotkey = new Hotkey();

		sorted = removeComments(sorted);

		// printAll(sorted);

		for (ArrayList<String> list : sorted) {
			Command command = new Command();

			if (list.size() != 0) {
				switch (list.get(0)) {
				case "inps":
					String s = "";
					if (list.size() > 1) {
						for (int i = 1; i < list.size(); i++) {
							if (list.get(i).startsWith("\"")) {
								s += list.get(i).substring(1);
							}
						}
					}
					hotkey.inputString = s;
					break;

				case "onlyonce":
					hotkey.onlyonce = true;
					break;

				case "req":
					if (list.size() > 1) {
						for (int i = 1; i < list.size(); i++) {
							String cs = list.get(i);

							if (cs.equalsIgnoreCase("key")) {
								i++;
								cs = list.get(i);

								hotkey.conditions.add("key:" + cs);
							}

							// TODO: remove

							if (cs.equalsIgnoreCase("#")) {
								break;
							}
						}
					}
					break;

				default:
					for (Task task : Task.tasks) {
						if (task.name().equalsIgnoreCase(list.get(0))) {
							command.task = task;
						}
					}
					break;
				}

				if (list.size() > 1) {
					for (int i = 1; i < list.size(); i++) {
						if (!list.get(i).isEmpty() && !list.get(i).equalsIgnoreCase(" ")) {
							command.parameters.add(list.get(i));
						}
					}
				}

				hotkey.commandList.add(command);
			}
		}

		Hotkeys.AddHotkey(hotkey);
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<String>[] getSortedList(final String skript) {
		ArrayList<String>[] output;

		// Splits the string in every new line

		String[] linesep = skript.split(System.lineSeparator());

		// Initialize the arraylist array with the length of how many lines there are

		output = new ArrayList[linesep.length];

		// Repeat for every line

		for (int i = 0; i < linesep.length; i++) {

			// Initialize the output at line 'i' as an arraylist

			output[i] = new ArrayList<>();

			int pointer = -1;

			boolean isString = false;

			for (int j = 0; j < linesep[i].length(); j++) {
				char ch = linesep[i].charAt(j);

				if (isString) {
					if (ch == '\"') {
						isString = false;

						output[i].add(linesep[i].substring(pointer, j));
						pointer = -1;
					}
				} else {
					if (isAlphabetical(ch)) {

						/**
						 * for example if there is a word it will set a pointer called 'sPointer' on the lowest place possible
						 * if there will be any separator it will substring the whole string from the pointer to the separator
						 */

						if (pointer == -1) {
							pointer = j;
						}
					} else if (ch == '\"') {
						isString = true;
						pointer = j;
					} else {
						boolean selfadd = false;

						if (ch != ' ' && pointer != -1) {
							selfadd = true;
						}

						if (pointer != -1) {
							output[i].add(linesep[i].substring(pointer, j));
							pointer = -1;
						} else {
							output[i].add(String.valueOf(ch));
						}

						if (selfadd) {
							output[i].add(String.valueOf(ch));
						}
					}
				}

				if (j == linesep[i].length() - 1) {
					if (pointer != -1) {
						output[i].add(linesep[i].substring(pointer, j + 1));
					} else if (isAlphabetical(linesep[i].charAt(j))) {
						output[i].add(linesep[i].substring(j, j + 1));
					}
				}
			}
		}

		return output;
	}

	private static ArrayList<String>[] removeComments(ArrayList<String>[] sorted) {
		for (ArrayList<String> list : sorted) {
			boolean isComment = false;
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i).equalsIgnoreCase("#")) {
					isComment = true;
				}

				if (isComment) {
					list.remove(i);
					i--;
				}
			}
		}

		return sorted;
	}

	private static boolean isAlphabetical(char ch) {
		if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
			return true;
		}

		return false;
	}

}
