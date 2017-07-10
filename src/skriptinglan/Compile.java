package skriptinglan;

import java.util.ArrayList;

import hotkey.Execute;
import hotkey.Hotkey;
import hotkey.Hotkeys;
import tasks.Task;

public class Compile {
	
	public static void compileSkript(final String path) {
		String skript = Execute.LoadStringFromFile(path);
		
		compile(skript);
	}
	
	public static void compile(final String str) {
		ArrayList<String>[] sorted = getSortedList(str);
		
		Hotkey hotkey = new Hotkey();
		
		hotkey.inputString = "test";
		
		for (ArrayList<String> list : sorted) {
			Command command = new Command();
			
			if (list.size() != 0) {
				switch (list.get(0)) {
				case "inps":
					String s = "";
					if (list.size() > 1) {
						for (int i = 1; i < list.size(); i++) {
							s += list.get(i);
						}
					}
					hotkey.inputString = s;
					break;
					
				case "req":
					if (list.size() > 1) {
						for (int i = 1; i < list.size(); i++) {
							String cs = list.get(i);
							
							if (cs.equalsIgnoreCase("key")) {
								i++;
								cs = list.get(i);
								
								hotkey.condition.add("key:" + cs);
							}
							
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
						command.parameters.add(list.get(i));
					}
				}
				
				hotkey.commandList.add(command);
			}
		}
		
		Hotkeys.AddHotkey(hotkey);
	}
	
	@SuppressWarnings("unchecked")
	private static ArrayList<String>[] getSortedList(final String skript) {
		ArrayList<String>[] sorted;
		
		String[] linesep = skript.split(System.lineSeparator());
		
		sorted = new ArrayList[linesep.length];
		
		for (int i = 0; i < linesep.length; i++) {
			
			sorted[i] = new ArrayList<>();
			
			// pointer
			int sPointer = -1;
			
			for (int j = 0; j < linesep[i].length(); j++) {
				char ch = linesep[i].charAt(j);
				
				if (isAlphabetical(ch)) {
					
					/**
					 * for example if there is a word it will set a pointer called 'sPointer' on the lowest place possible
					 * if there will be any separator it will substring the whole string from the pointer to the separator
					 */
					
					if (sPointer == -1)
						sPointer = j;
				} else {
					boolean selfadd = false;
					
					if (ch != ' ' && sPointer != -1)
						selfadd = true;
					
					if (sPointer != -1) {
						sorted[i].add(linesep[i].substring(sPointer, j));
						sPointer = -1;
					} else {
						sorted[i].add(String.valueOf(ch));
					}
					
					if (selfadd)
						sorted[i].add(String.valueOf(ch));
				}
				
				if (j == linesep[i].length() - 1) {
					if (sPointer != -1) {
						sorted[i].add(linesep[i].substring(sPointer, j + 1));
					} else if (isAlphabetical(linesep[i].charAt(j))) {
						sorted[i].add(linesep[i].substring(j, j + 1));
					}
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
