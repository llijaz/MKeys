package main;

import javax.swing.UIManager;

import files.Files;
import frame.Frame;
import frame.LoadingFrame;
import hotkey.Execute;
import hotkey.Hotkeys;
import tasks.Task;

public class Main {

	public static Frame frame;

	public static LoadingFrame loading;
	
	public static boolean threading = true;
	public static boolean clear = false;
	
	public static void main(String[] args) {
		// TODO:
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {

		}

		Task.init();

		frame = new Frame("MKey", 400, 400);
		loading = new LoadingFrame();

		Files.init();
		Execute.init();
		HotkeyListener.init();
		Hotkeys.init();

		String s = Files.getContent("inputframekey");

		if (s != null) {
			try {
				HotkeyListener.inputframekey = Integer.parseInt(s);
			} catch (NumberFormatException e) {

			}
		}
	}
	
	public static void executeAllHotkeys(String inputstring, boolean mode) {
		if (!threading) {
			return;
		}
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for (String path : Files.paths) {
					Lua.execute(path, inputstring, null, mode);
				}
				
				if (clear) {
					HotkeyListener.keys = new boolean[250];
					clear = false;
				}
				
				Main.threading = true;
			}
		});
		
		t.setPriority(1);
		
		t.start();
	}

}