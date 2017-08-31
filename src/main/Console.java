package main;

import java.util.ArrayList;

public class Console {
	
	public static final String[] MODES = new String[] {
		"Message", "Warning", "Error", "Debug", "Lua"	
	};
	
	public static final int OFFSET = 8;
	public static final int MESSAGE = 0;
	public static final int WARNING = 1;
	public static final int ERROR = 2;
	public static final int DEBUG = 3;
	public static final int LUA = 4;

	public static boolean[] printAsSysout = new boolean[] {
			true, false, false, true, false
	};

	public static boolean[] printInConsole = new boolean[] {
			true, true, true, true, true
	};
	
	private static ArrayList<ConsoleListener> listeners = new ArrayList<>();
	
	public static void print(int mode, String message) {
		String s = "[" + MODES[mode] + "]:";
		
		int spaces = OFFSET - MODES[mode].length();
		
		for (int i = 0; i < spaces; i++) {
			s += " ";
		}
		
		if (printAsSysout[mode]) {
			System.out.println(s);
		}
		
		if (printInConsole[mode]) {
			for (ConsoleListener listener : listeners) {
				listener.getInput(s);
			}
		}
	}
	
	public static void addListener(ConsoleListener listener) {
		listeners.add(listener);
	}
	
}
