package main;

import javax.swing.UIManager;

import frame.Frame;
import hotkey.Execute;
import hotkey.Hotkey;

public class Main {
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			
		}
		
		Frame frame = new Frame("MKey", 100, 100);
		
		Execute.Init();
		HotkeyListener.init();
		Hotkey.Init();
	}
	
}