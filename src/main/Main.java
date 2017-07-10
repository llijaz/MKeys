package main;

import javax.swing.UIManager;

import files.Files;
import frame.Frame;
import hotkey.Execute;
import hotkey.Hotkeys;
import skriptinglan.Compile;
import tasks.Task;

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

		}

		new Frame("MKey", 400, 400);
		
		Files.Init();
		Execute.Init();
		HotkeyListener.init();
		Task.Init();
		Hotkeys.Init();
		
		for (String path : Files.paths) {
			Compile.compileSkript(path);
		}
		
		String s = Files.getContent("inputframekey");
		
		if (s != null) {
			try {
				HotkeyListener.inputframekey = Integer.parseInt(s);
			} catch (NumberFormatException e) {
				
			}
		}
		
	}

}