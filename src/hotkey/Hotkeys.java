package hotkey;

import java.util.ArrayList;

public class Hotkeys {
	
	private static ArrayList<Hotkey> hotkeys;
	
	public static void Init() {
		hotkeys = new ArrayList<>();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					
					Update();
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	public static void Input(String input) {
		for (Hotkey hotkey : hotkeys) {
			try {
				if (hotkey.inputString.equalsIgnoreCase(input)) {
					hotkey.execute(true);
				}
			} catch (NullPointerException e) {
				
			}
		}
	}
	
	public static void AddHotkey(Hotkey hotkey) {
		hotkeys.add(hotkey);
	}
	
	private static void Update() {
		for (int i = 0; i < hotkeys.size(); i++) {
			if (hotkeys.get(i) != null) {
				hotkeys.get(i).update();
			}
		}
	}
	
}
